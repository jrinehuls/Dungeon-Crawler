package background;

import view.panels.game.DisplayPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class BackgroundImage {

    private ImageIcon[] backgroundImages;

    {
        try {
            backgroundImages = new ImageIcon[]{
                    new ImageIcon(ImageIO.read((getClass().getResourceAsStream("/backgrounds/All-Open.png")))),
                    new ImageIcon(ImageIO.read((getClass().getResourceAsStream("/backgrounds/Front-Only.png")))),
                    new ImageIcon(ImageIO.read((getClass().getResourceAsStream("/backgrounds/Left-Only.png")))),
                    new ImageIcon(ImageIO.read((getClass().getResourceAsStream("/backgrounds/Right-Only.png")))),
                    new ImageIcon(ImageIO.read((getClass().getResourceAsStream("/backgrounds/No-Front.png")))),
                    new ImageIcon(ImageIO.read((getClass().getResourceAsStream("/backgrounds/No-Left.png")))),
                    new ImageIcon(ImageIO.read((getClass().getResourceAsStream("/backgrounds/No-Right.png")))),
                    new ImageIcon(ImageIO.read((getClass().getResourceAsStream("/backgrounds/All-Sides.png"))))
                    //new ImageIcon("res/backgrounds/3-sides.png")
            };
        } catch (IOException e) {
            // DisplayPanel.appendConsoleModel(e.getMessage());
            throw new RuntimeException(e);
        }
    }


    public BackgroundImage() {
    }



    public ImageIcon getBackgroundImage(int index) {
        return backgroundImages[index];
    }

    public ImageIcon[] getBackgroundImages() {
        return backgroundImages;
    }

}
