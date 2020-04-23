package graphics.FirstPage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class backgroundImage extends JPanel {
    private BufferedImage image;
    private int w,h;
    public backgroundImage(String fname){

        //reads the image
        try {
            image = ImageIO.read(new File(fname));
            w = 200;
            h = 200;

        } catch (IOException ioe) {
            System.out.println("Could not read in the pic");
            //System.exit(0);
        }

    }

    public Dimension getPreferredSize() {
        return new Dimension(w,h);
    }
    //this will draw the image
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0,this);
    }
}
