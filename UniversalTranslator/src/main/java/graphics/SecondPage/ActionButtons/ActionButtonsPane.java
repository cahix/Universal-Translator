package graphics.SecondPage.ActionButtons;

import Tools.ImageResizer;
import graphics.SecondPage.ChatPanes.FixedSizedChatPane;
import graphics.SecondPage.ChatPanes.MessagePane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ActionButtonsPane extends JPanel{
    JButton replayButton;
    JButton stopButton;
    Image replayImage;
    Image stopImage;

    public ActionButtonsPane(){
        setOpaque(false);
        setLayout(new GridBagLayout());
        replayButton            = new JButton();
        stopButton              = new JButton();
        try{
            replayImage = ImageResizer.resizeImage("src\\main\\java\\Images\\iconfinder_icon-play_211876.png" , 10 , 10);
            stopImage= ImageResizer.resizeImage("src\\main\\java\\Images\\iconfinder_067_Pause_183196.png" , 10 , 10);
            final Random random = new Random();
            replayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    FixedSizedChatPane.messages.add(random.nextBoolean() ? new MessagePane("osidhfoihsd oijsdf oi oihnsd " , 0) : new MessagePane("osaidfjo paaspdo f" , 1));
                }
            });
            replayButton.setIcon(new ImageIcon(replayImage));
            stopButton.setIcon(new ImageIcon(stopImage));
        } catch (Exception ex){
            System.out.printf("Image not found");
        }
        GridBagConstraints gbc  = new GridBagConstraints();
        gbc.gridx               = 0;
        gbc.gridy               = 0;
        add(replayButton , gbc);
        gbc.gridx++;
        add(stopButton , gbc);
    }

    /*@Override
    public Dimension getMaximumSize() {
        return new Dimension(MainPage.WIDTH, MainPage.HEIGHT / 8);
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(MainPage.WIDTH , MainPage.HEIGHT / 8);
    }*/
}
