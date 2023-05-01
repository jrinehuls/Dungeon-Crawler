package view.panels;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {

    public static int SCREEN_WIDTH = GamePanel.SCREEN_WIDTH;
    public static int SCREEN_HEIGHT = MapPanel.SCREEN_HEIGHT;

    public DisplayPanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
