package model.tileobject;

import view.panels.game.DisplayPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public abstract class InteractableTileObject {

    protected BufferedImage iconImage;
    protected ImageIcon backgroundImage;

    public InteractableTileObject(String iconPath, String backgroundFileName) {
        setIconImage(iconPath);
        setBackgroundImage(backgroundFileName);
    }

    private void setIconImage(String iconPath) {
        try {
            this.iconImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(iconPath)));
        } catch (IOException e) {
            DisplayPanel.appendConsoleModel("ITO " + e.getMessage());
            this.iconImage = null;
            System.out.println("ITO Bad file path");
        }
    }

    public BufferedImage getIconImage() {
        return this.iconImage;
    }

    private void setBackgroundImage(String backgroundFileName) {
        try {
            this.backgroundImage = new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(backgroundFileName))));
        } catch (IOException e) {
            DisplayPanel.appendConsoleModel("ITO " + e.getMessage());
            this.iconImage = null;
            System.out.println("ITO Bad file path");
        }
    }

    public ImageIcon getBackgroundImage() {
        return this.backgroundImage;
    }

}
