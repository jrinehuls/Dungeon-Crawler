package tiles;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageTile {

    private BufferedImage image = null;

    public ImageTile(String imagePath) {
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream(imagePath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            this.image = null;
        } catch (IllegalArgumentException e) {
            System.out.println("Bad file path");
        }
    }

    public BufferedImage getImage () {
        return image;
    }

}
