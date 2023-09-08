package background;

import view.panels.game.DisplayPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class BackgroundImage {

    private ImageIcon[] backgroundImages;

    public BackgroundImage() {
        setBackgroundImages();
    }

    private void setBackgroundImages() {
        {
            try {
                backgroundImages = new ImageIcon[]{
                        new ImageIcon(ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/backgrounds/All-Open.png"))))),
                        new ImageIcon(ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/backgrounds/Front-Only.png"))))),
                        new ImageIcon(ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/backgrounds/Left-Only.png"))))),
                        new ImageIcon(ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/backgrounds/Right-Only.png"))))),
                        new ImageIcon(ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/backgrounds/No-Front.png"))))),
                        new ImageIcon(ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/backgrounds/No-Left.png"))))),
                        new ImageIcon(ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/backgrounds/No-Right.png"))))),
                        new ImageIcon(ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/backgrounds/All-Sides.png")))))
                };
            } catch (IOException e) {
                DisplayPanel.appendConsoleModel(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    public ImageIcon getBackgroundImage(int index) {
        return backgroundImages[index];
    }

    public ImageIcon[] getBackgroundImages() {
        return backgroundImages;
    }

}
