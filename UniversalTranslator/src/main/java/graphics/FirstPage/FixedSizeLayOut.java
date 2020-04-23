package graphics.FirstPage;

import Tools.ImageResizer;
import graphics.SecondPage.MainPage;

import javax.swing.*;
import java.awt.*;

public class FixedSizeLayOut  {
    public FixedSizeLayOut(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                Image backgroundImage = ImageResizer.resizeImage("src\\main\\java\\Images\\universalTranslator-background.png" , MainPage.WIDTH , MainPage.HEIGHT);
                JLabel background = new JLabel(new ImageIcon(backgroundImage));
                JFrame frame = new JFrame("Universal translator");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(background);
                frame.setLayout(new BorderLayout());
                frame.setResizable(false);
                final MainPage mainPage = new MainPage();
                frame.add(mainPage);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
