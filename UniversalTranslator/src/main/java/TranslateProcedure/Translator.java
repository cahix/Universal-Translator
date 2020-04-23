package TranslateProcedure;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class Translator {
    public static String translate(String input , String from , String to) throws Exception {
        // Instantiates a client
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        Translation translation =
                translate.translate(
                        input,
                        TranslateOption.sourceLanguage(from),
                        TranslateOption.targetLanguage(to));

        return translation.getTranslatedText();
    }
    public static void main(String[] args){
        try {
            System.out.println(Translator.translate("Guten Morgen" , "ru" , "ar"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}