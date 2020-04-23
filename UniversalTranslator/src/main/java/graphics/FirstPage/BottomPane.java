package graphics.FirstPage;

import TranslateProcedure.Translator;
import TranslateProcedure.speechToText;
import TranslateProcedure.textReader;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.StreamingRecognitionResult;
import com.google.cloud.speech.v1.StreamingRecognizeResponse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomPane extends JPanel{
    JButton button;
    JButton stopButton;
    String language1;
    String language2;
    long timer = 0;
    boolean activeButton = false;


    speechToText speechRecorder;
    public BottomPane() {
        setBackground(Color.BLACK);
        button = new JButton("Start recording");
        stopButton = new JButton("Stop recording");
        stopButton.setEnabled(false);
        final javax.swing.Timer timer = new javax.swing.Timer( 8000, new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                stopButton.setEnabled(true);
            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();   // t.stop() beendet.
                Thread newThread = new Thread(recorder);
                newThread.start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speechRecorder.stopRecording();
                stopButton.setEnabled(false);
                timer.stop();
            }
        });
        this.add(button);
        this.add(stopButton);
    }




    Runnable recorder = new Runnable() {
        @Override
        public void run() {
            language1 = LeftPane.firstLanguage;
            language2 = RightPane.secondLanguage;
            String spokenLangauge =  language1;
            String destinationLanguage = language2;
            speechRecorder = new speechToText(spokenLangauge);
            String output="";
            try {
                speechRecorder.streamingMicRecognize();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            for (StreamingRecognizeResponse response : speechRecorder.responses) {
                StreamingRecognitionResult result = response.getResultsList().get(0);
                SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
                output = alternative.getTranscript();
            }
            String result2 = null;
            try {
                result2 = Translator.translate(output , spokenLangauge.substring(0,2) , destinationLanguage.substring(0 , 2));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            textReader txtReader = new textReader(result2);
            txtReader.speak();
        }
    };

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 100);
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }
}
