package graphics.FirstPage;

import javax.swing.*;
import java.awt.*;

public class StartPage extends JPanel {
    public StartPage(){

        setLayout(new GridBagLayout());
        //add(new backgroundImage("C:\\Users\\osama\\Desktop\\Fopra v1\\universal-translator\\UniversalTranslator\\src\\main\\java\\graphics\\background.jpg"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new LeftPane() , gbc );
        gbc.gridx++;
        add(new RightPane(), gbc);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new BottomPane(), gbc);

    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }
}
