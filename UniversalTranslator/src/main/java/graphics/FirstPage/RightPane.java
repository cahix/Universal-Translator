package graphics.FirstPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class RightPane extends JPanel {
    JLabel label;
    JComboBox comboBox;
    Map<String , String> languageCodeByLanguageName = new HashMap<>();
    public static String secondLanguage = "ar-IL";

    public RightPane() {
        languageCodeByLanguageName.put("german" , "de_DE");
        languageCodeByLanguageName.put("arabic" , "ar-IL");
        languageCodeByLanguageName.put("english" , "en_US");
        setBackground(Color.BLACK);
        label = new JLabel("Second Language");
        label.setForeground(Color.WHITE);
        comboBox = new JComboBox(languageCodeByLanguageName.keySet().toArray());
        comboBox.setSelectedIndex(1);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondLanguage = languageCodeByLanguageName.get(comboBox.getSelectedItem());
            }
        });
        this.add(label);
        this.add(comboBox);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 300);
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
