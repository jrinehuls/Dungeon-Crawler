package background;

import javax.swing.*;

public class BackgroundImage {

    private ImageIcon[] backgroundImages = {new ImageIcon("src/res/backgrounds/All-Open.png"),
            new ImageIcon("src/res/backgrounds/Front-Only.png"), new ImageIcon("src/res/backgrounds/Left-Only.png"),
            new ImageIcon("src/res/backgrounds/Right-Only.png"), new ImageIcon("src/res/backgrounds/No-Front.png"),
            new ImageIcon("src/res/backgrounds/No-Left.png"), new ImageIcon("src/res/backgrounds/No-Right.png"),
            new ImageIcon("src/res/backgrounds/3-sides.png")};

    public BackgroundImage() {

    }

    public ImageIcon getBackgroundImage(int index) {
        return backgroundImages[index];
    }

    public ImageIcon[] getBackgroundImages() {
        return backgroundImages;
    }

}
