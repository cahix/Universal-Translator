package TranslateProcedure;

import com.darkprograms.speech.synthesiser.SynthesiserV2;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class textReader{
    SynthesiserV2 synthesizer = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
    String text;

    public textReader(String text){
        this.text = text;
    }

    public void speak(){
        /*Thread thread = new Thread(() -> {
            try {
                AdvancedPlayer player = new AdvancedPlayer(synthesizer.getMP3Data(this.text)) ;
                player.play();
            } catch (Exception e) {
                System.out.println(e);
            }
        });*/
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    AdvancedPlayer player = new AdvancedPlayer(synthesizer.getMP3Data(text)) ;
                    player.play();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });


        thread.setDaemon(false);

        thread.start();
    }

    public static void main(String[] args){
        textReader x = new textReader("Ciao ");
        x.speak();
    }
}