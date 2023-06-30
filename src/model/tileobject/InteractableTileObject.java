package model.tileobject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class InteractableTileObject {

    protected String iconPath;
    protected String backgroundFileName;
    protected BufferedImage iconImage;
    protected ImageIcon backgroundImage;


    public InteractableTileObject(String iconPath, String backgroundFileName) {
        this.iconPath = iconPath;
        this.backgroundFileName = backgroundFileName;
    }

    public BufferedImage getIconImage() {
        try {
            this.iconImage = ImageIO.read(getClass().getResourceAsStream(this.iconPath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            this.iconImage = null;
        } catch (IllegalArgumentException e) {
            System.out.println("Bad file path");
        }
        return this.iconImage;
    }

    public ImageIcon getBackgroundImage() {
        this.backgroundImage = new ImageIcon(this.backgroundFileName);
        return this.backgroundImage;
    }

}
