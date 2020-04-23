package Tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageResizer {
    public static Image resizeImage(String path , int w , int h){
        try {
            Image originalImage = ImageIO.read(new File(path));
            BufferedImage resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = resizedImage.createGraphics();

            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(originalImage, 0, 0, w, h, null);
            g2.dispose();

            return resizedImage;
        } catch (Exception e){
            System.out.println("something wrong with Image resizing");
        }
        return null;
    }
}
