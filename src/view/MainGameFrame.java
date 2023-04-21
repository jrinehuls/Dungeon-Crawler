package view;

import view.panels.GamePanel;
import view.panels.MapPanel;
import view.panels.PlayerPanel;

import javax.swing.*;
import java.awt.*;

public class MainGameFrame extends JFrame {
    GamePanel gamePanel = new GamePanel();
    MapPanel mapPanel = new MapPanel();
    PlayerPanel playerPanel = new PlayerPanel();
    final int FRAME_WIDTH = MapPanel.SCREEN_EDGE_LENGTH + gamePanel.SCREEN_WIDTH + 16;
    final int FRAME_HEIGHT = gamePanel.SCREEN_HEIGHT + 39;

    public MainGameFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setIconImage(new ImageIcon("src/res/monsters/Spaghetti.png").getImage());
        this.setLayout(null);
        mapPanel.setLocation(0,0);
        this.add(mapPanel);
        gamePanel.setLocation(MapPanel.SCREEN_EDGE_LENGTH,0);
        this.add(gamePanel);
        playerPanel.setLocation(0, MapPanel.SCREEN_EDGE_LENGTH);
        this.add(playerPanel);
        this.setSize(FRAME_WIDTH ,FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
