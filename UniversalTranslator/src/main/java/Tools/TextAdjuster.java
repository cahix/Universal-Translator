package Tools;

public class TextAdjuster {
    //this method is used to adjust text , to make it fit into the JTextArea with a given column width.
    public static String adjustText(String text , int textAreaWidth){
        String[] splitText = text.split(" "); // given text will be split and add to String array.
        String result = join(splitText , textAreaWidth);
        return result;
    }

    private static String join(String[] splitText , int textAreaWidth){
        int counter = 0;
        String result = "";
        for(String word : splitText){
            if(counter + word.length() >= textAreaWidth){
                result += "\r\n" + word;
                counter = word.length();
            } else {
                result += word + " ";
                counter += word.length() + 1;
            }
        }
        return result;
    }
}
