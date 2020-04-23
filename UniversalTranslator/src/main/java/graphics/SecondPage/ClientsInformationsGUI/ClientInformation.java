package graphics.SecondPage.ClientsInformationsGUI;

import javax.swing.*;
import java.awt.*;

public class ClientInformation extends JPanel {
    JLabel personId;
    JLabel personName;
    JLabel languageIcon;

    JButton germanButton;
    JButton englishButton;
    JButton arabicButton;

    String germanIcon = "src\\main\\java\\Images\\iconfinder_flag_germany_50241.png";
    String englishIcon = "src\\main\\java\\Images\\iconfinder_flag_usa_50305.png";
    String arabicIcon = "src\\main\\java\\Images\\arabic.png";

    public ClientInformation(String clientName , final int personNumber, String languageIconFileName){
        personId        = new JLabel("Person " + personNumber);
        personName      = new JLabel(clientName);
        languageIcon    = new JLabel();
        germanButton    = new JButton("german");
        englishButton   = new JButton("english");
        arabicButton    = new JButton("arabic");
        germanButton    .setPreferredSize(new Dimension(70,25));
        englishButton   .setPreferredSize(new Dimension(70,25));
        arabicButton    .setPreferredSize(new Dimension(70,25));

        /*germanButton    .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLanguage("german",personNumber);
            }
        });
        englishButton   .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLanguage("english",personNumber);
            }
        });
        arabicButton    .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLanguage("arabic",personNumber);
            }
        });

        Image icon = ImageResizer.resizeImage(languageIconFileName , 30 , 30);
        languageIcon.setIcon(new ImageIcon(icon));*/

        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(languageIcon , gbc);
        gbc.gridy++;
        add(germanButton, gbc);
        gbc.gridy++;
        add(englishButton, gbc);
        gbc.gridy++;
        add(arabicButton, gbc);
        gbc.gridx++;
        gbc.gridy-=3;
        add(personId , gbc);
        gbc.gridx++;
        add(personName , gbc);
    }

    public void setLanguage(String language, int PersonID){
    }


    @Override
    public Dimension getMinimumSize() {
        return new Dimension(200 , 50);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(200 , 50);
    }
}
