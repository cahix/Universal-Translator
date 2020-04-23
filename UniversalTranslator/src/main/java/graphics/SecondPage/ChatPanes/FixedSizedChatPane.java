package graphics.SecondPage.ChatPanes;

import graphics.SecondPage.MainPage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FixedSizedChatPane extends JPanel {
    public final int HEIGHT = 600;
    public final int WIDTH = MainPage.WIDTH;
    public final static List<MessagePane> messages = new ArrayList<>();

    public FixedSizedChatPane(){
        setPreferredSize(new Dimension(WIDTH , HEIGHT));
        setMaximumSize(new Dimension(WIDTH , HEIGHT));
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        for (MessagePane message : messages) {
            add(message.ID == 0 ? message : new EmptyChatPane(), gbc);
            gbc.gridx++;
            add(message.ID == 0 ? new EmptyChatPane() : message, gbc);
            gbc.gridx--;
            gbc.gridy++;
        }
    }

}
