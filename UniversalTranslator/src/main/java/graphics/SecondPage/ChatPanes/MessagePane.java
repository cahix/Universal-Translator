package graphics.SecondPage.ChatPanes;

import Tools.TextAdjuster;
import graphics.SecondPage.ActionButtons.ActionButtonsPane;

import javax.swing.*;
import java.awt.*;

public class MessagePane extends JPanel{
    public int ID;
    public JTextArea textArea;
    public ActionButtonsPane actionButtons;
    public String text;
    public Polygon messagePolygon;
    public MessagePane(String text , int ID){
        //messagePolygon = PolygonGenerator.generate("3 3,5 6,27 40,25 52,25 62,26 72,23 94,22 101,36 115,180 117,222 116,229 107,236 99,235 38,235 30,232 23,231 20,219 14,210 11,125 13,36 16,26 14,19 13,13 11,9 7,0 0" );
        this.ID = ID;
        this.text = TextAdjuster.adjustText(text , 30);
        setOpaque(false);
        setLayout(new GridBagLayout());
        actionButtons          = new ActionButtonsPane();
        textArea               =   new JTextArea(this.text);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setColumns(30);
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.gridx = 0;
        gbc.gridy = 0;
        add(textArea, gbc);
        gbc.insets = new Insets(0 , 10 , 0 , 0);
        gbc.gridx++;
        add(actionButtons , gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color lightBlue = new Color(122 , 153 , 204);
        g.setColor(lightBlue);
        //g.fillPolygon(messagePolygon);
        //g.fillOval(0,0, MainPage.WIDTH/2 , 100 );
    }
}
