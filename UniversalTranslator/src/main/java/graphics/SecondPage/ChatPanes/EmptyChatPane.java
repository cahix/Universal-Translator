package graphics.SecondPage.ChatPanes;

import graphics.SecondPage.MainPage;

import javax.swing.*;
import java.awt.*;

public class EmptyChatPane extends JPanel {
    public EmptyChatPane(){
        setOpaque(false);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MainPage.WIDTH / 2, MainPage.HEIGHT / 8);
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(MainPage.WIDTH / 2, MainPage.HEIGHT / 8);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(MainPage.WIDTH / 2, MainPage.HEIGHT / 8);
    }
}
