package graphics.SecondPage.ClientsInformationsGUI;

import graphics.SecondPage.MainPage;

import javax.swing.*;
import java.awt.*;

public class InfoBox extends JPanel {
    ClientInformation firstClient;
    ClientInformation secondClient;

    String germanIcon = "src\\main\\java\\Images\\iconfinder_flag_germany_50241.png";
    String englishIcon = "src\\main\\java\\Images\\iconfinder_flag_usa_50305.png";
    String arabicIcon = "src\\main\\java\\Images\\arabic.png";
    String firstClientIcon = germanIcon;
    String secondClientIcon = arabicIcon;

    public InfoBox(){
        setPreferredSize(new Dimension(900 , 150));
        setMaximumSize(new Dimension(900 , 150));
        setLayout(new GridBagLayout());
        setOpaque(false);
        firstClient = new ClientInformation("1" , 1 , firstClientIcon);
        secondClient = new ClientInformation("2" , 2 , secondClientIcon);
        firstClient.setAlignmentX(Component.RIGHT_ALIGNMENT);
        secondClient.setAlignmentX(Component.LEFT_ALIGNMENT);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(firstClient , gbc);
        gbc.insets = new Insets(0 , MainPage.WIDTH / 2 , 0 , 0);
        gbc.gridx+=1;
        add(secondClient , gbc);
    }
}
