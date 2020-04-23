package graphics.SecondPage;

import TranslateProcedure.Translator;
import TranslateProcedure.speechToText;
import TranslateProcedure.textReader;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.StreamingRecognitionResult;
import com.google.cloud.speech.v1.StreamingRecognizeResponse;
import graphics.SecondPage.ChatPanes.FixedSizedChatPane;
import graphics.SecondPage.ChatPanes.MessagePane;
import graphics.SecondPage.ClientsInformationsGUI.InfoBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class MainPage extends JPanel implements KeyListener {
    //Static values.
    public final static int WIDTH = 900;
    public final static int HEIGHT = 900;
    public final static List<MessagePane> messages = new ArrayList<>();
    public static int speakingPersonID = 0; //The current speaking person (it can either be 0) or 1 or 2) , recorder Runnable object will be adjusted according to the current speaker.
                                            // 0 no one is currently speaking.
                                            // 1 first person currently speaking.
                                            // 0 second person currently speaking.
    //Gui components.
    GridBagConstraints gbc;
    String language1 = "de_DE";
    String language2 = "en_US";
    private final javax.swing.Timer timer = new javax.swing.Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { //here we have 60 FPS.
            revalidate();
            repaint();
        }
    });


    //Recorder/Translation items :
    speechToText speechRecorderPerson1;
    speechToText speechRecorderPerson2;
    Runnable recorder = new Runnable() {
        @Override
        public void run() {
            //language1 = firstLanguage; //TODO
            //language2 = secondLanguage; //TODO
            int personId = speakingPersonID;
            String sourceLanguage =  speakingPersonID == 1 ? language1 : language2;
            String targetLanguage =  speakingPersonID == 1 ? language2 : language1;
            speechRecorderPerson1 = new speechToText(sourceLanguage);
            String output="";
            try {
                speechRecorderPerson1.streamingMicRecognize();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            for (StreamingRecognizeResponse response : speechRecorderPerson1.responses) {
                StreamingRecognitionResult result = response.getResultsList().get(0);
                SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
                output = alternative.getTranscript();
            }
            String result2 = null;
            try {
                result2 = Translator.translate(output , sourceLanguage.substring(0,2) , targetLanguage.substring(0 , 2));
                //Add to the User-Interface as a MessagePane
                if(FixedSizedChatPane.messages.size() >= 5){
                    messages.remove(0);
                }
                FixedSizedChatPane.messages.add(new MessagePane(result2 , personId - 1));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            textReader txtReader = new textReader(result2);
            txtReader.speak();
            recordingThread = new Thread(recorder);
        }
    };
    Thread recordingThread = new Thread(recorder);

    public MainPage(){
        setLayout(new GridBagLayout());
        setFocusable(true);
        requestFocusInWindow();
        //On space-pressing recorder starts.
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(speakingPersonID == 0){
                    if(e.getKeyCode() == KeyEvent.VK_R) {
                        speakingPersonID = 1;
                        if (!recordingThread.isAlive()) {
                            recordingThread.start();
                        }
                    } else if(e.getKeyCode() == KeyEvent.VK_L) {
                        speakingPersonID = 2;
                        if (!recordingThread.isAlive()) {
                            recordingThread.start();
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //we need to check if really the key of the current speaker was released.
                if((e.getKeyCode() == KeyEvent.VK_R && speakingPersonID ==1) || (e.getKeyCode() == KeyEvent.VK_L && speakingPersonID == 2)) {
                    speechRecorderPerson1.stopRecording();
                    speakingPersonID = 0;
                }
            }
        });
        setOpaque(false);
        gbc = new GridBagConstraints();
        paintMainPage();
        timer.start();
    }
    private void paintMainPage(){
        if(gbc != null) {
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(new InfoBox(), gbc);
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridy++;
            add(new FixedSizedChatPane(), gbc);
            gbc.gridy++;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(new SecondPageBottomPane(), gbc);
        }
    }

    @Override
    public void repaint() {
        removeAll();
        paintMainPage();
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(WIDTH, HEIGHT);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            System.out.println("startRecording");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            System.out.println("startRecording");
        }
    }
}
