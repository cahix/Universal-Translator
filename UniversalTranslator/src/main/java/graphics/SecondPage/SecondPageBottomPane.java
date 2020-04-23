package graphics.SecondPage;

import graphics.SecondPage.ActionButtons.ActionButtonsPane;

import javax.swing.*;
import java.awt.*;

public class SecondPageBottomPane extends JPanel{
    JLabel text;
    ActionButtonsPane actionButtons;
    public SecondPageBottomPane(){
        setPreferredSize(new Dimension(900 , 150));
        setOpaque(false);
        setLayout(new GridBagLayout());
        actionButtons       = new ActionButtonsPane();
        text                =   new JLabel("FiifthPerson");
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.gridx = 0;
        gbc.gridy = 0;
        add(text , gbc);
        gbc.gridx++;
        add(actionButtons , gbc);
    }
}
