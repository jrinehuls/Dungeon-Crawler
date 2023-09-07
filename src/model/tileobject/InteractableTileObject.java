package model.tileobject;

import view.panels.game.DisplayPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

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
            this.iconImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(this.iconPath)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            this.iconImage = null;
        } catch (IllegalArgumentException e) {
            System.out.println("Bad file path");
        }
        return this.iconImage;
    }

    public ImageIcon getBackgroundImage() {
        // this.backgroundImage = new ImageIcon(this.backgroundFileName);
        try {
            this.backgroundImage = new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(this.backgroundFileName))));
        } catch (IOException e) {
            DisplayPanel.appendConsoleModel(e.getMessage());
            throw new RuntimeException(e);
        }
        return this.backgroundImage;
    }

}
