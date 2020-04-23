package graphics.FirstPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class LeftPane extends JPanel {
    JLabel label;
    JComboBox<String>  comboBox;
    Map<String , String> languageCodeByLanguageName = new HashMap<>();
    public static String firstLanguage = "de_DE";

    public LeftPane(){
        languageCodeByLanguageName.put("arabic" , "ar-IL");
        languageCodeByLanguageName.put("german" , "de_DE");
        languageCodeByLanguageName.put("english" , "en_US");
        setBackground(Color.BLACK);
        label = new JLabel("First Language");
        label.setForeground(Color.WHITE);
        comboBox = new JComboBox(languageCodeByLanguageName.keySet().toArray());
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstLanguage = languageCodeByLanguageName.get(comboBox.getSelectedItem());
            }
        });
        this.add(label);
        this.add(comboBox);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200 , 300);
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
