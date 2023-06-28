package model.tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class InteractableTileObject {

    protected String iconPath;
    protected String backgroundPath;
    protected BufferedImage iconImage;
    protected ImageIcon backgroundImage;


    public InteractableTileObject(String iconPath, String backgroundPath) {
        this.iconPath = iconPath;
        this.backgroundPath = backgroundPath;
    }

    private BufferedImage getIconImage(String imagePath) {
        try {
            this.iconImage = ImageIO.read(getClass().getResourceAsStream(imagePath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            this.iconImage = null;
        } catch (IllegalArgumentException e) {
            System.out.println("Bad file path");
        }
        return this.iconImage;
    }

    private ImageIcon getBackgroundImage(String backgroundPath) {
        this.backgroundImage = new ImageIcon(backgroundPath);
        return this.backgroundImage;
    }

}
