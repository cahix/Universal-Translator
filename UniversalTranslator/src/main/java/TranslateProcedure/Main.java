package TranslateProcedure;

import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.StreamingRecognitionResult;
import com.google.cloud.speech.v1.StreamingRecognizeResponse;



public class Main {
    public static void main(String[] args) throws Exception {
        String spokenLangauge = "ar-IL";
        String destinationLanguage = "de-DE";
        speechToText x = new speechToText(spokenLangauge);
        String output="";
        try {
            x.streamingMicRecognize();
            for (StreamingRecognizeResponse response : x.responses) {
                StreamingRecognitionResult result = response.getResultsList().get(0);
                SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
                output = alternative.getTranscript();
            }
            String result2 = Translator.translate(output , spokenLangauge.substring(0,2) , destinationLanguage.substring(0 , 2          ));
            textReader txtReader = new textReader(result2);
            txtReader.speak();
            //System.out.println(spokenLangauge.substring(0,2));
            //System.out.println(destinationLanguage.substring(0,2));
        } catch (Exception e) {
            e.printStackTrace();
        }}



}
