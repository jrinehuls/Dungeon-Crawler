package view.frames;

import view.panels.*;

import javax.swing.*;
import java.awt.*;

public class MainGameFrame extends JFrame {


    public MainGameFrame() {

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        // Set up vertical panels to add game panels to
        JPanel leftPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel rightPanel = new JPanel();

        // Set up sub panels. Leave map panel for last so other panels get started before game loop runs.
        MonsterPanel monsterPanel = new MonsterPanel();
        GamePanel gamePanel = new GamePanel();
        DisplayPanel displayPanel = new DisplayPanel();
        ActionPanel actionPanel = new ActionPanel();
        PlayerPanel playerPanel = new PlayerPanel();
        MapPanel mapPanel = new MapPanel();

        // ------------------------------<Left Panel Stuff>------------------------------------
        leftPanel.setPreferredSize(new Dimension(MapPanel.SCREEN_WIDTH, MapPanel.SCREEN_HEIGHT + MonsterPanel.SCREEN_HEIGHT));
        leftPanel.setBackground(Color.black);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(mapPanel);
        leftPanel.add(monsterPanel);
        this.add(leftPanel);

        // ------------------------------<Middle Panel Stuff>------------------------------------
        middlePanel.setPreferredSize(new Dimension(GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT + DisplayPanel.SCREEN_HEIGHT));
        middlePanel.setBackground(Color.red);
        middlePanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 0));
        middlePanel.add(gamePanel);
        middlePanel.add(displayPanel);
        this.add(middlePanel);

        // ------------------------------<Right Panel Stuff>------------------------------------
        rightPanel.setPreferredSize(new Dimension(ActionPanel.SCREEN_WIDTH,ActionPanel.SCREEN_HEIGHT + PlayerPanel.SCREEN_HEIGHT));
        rightPanel.setBackground(Color.GREEN);
        rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        rightPanel.add(actionPanel);
        rightPanel.add(playerPanel);
        this.add(rightPanel);

        // ------------------------------<Frame Stuff>------------------------------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setIconImage(new ImageIcon("src/res/monsters/Spaghetti.png").getImage());
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
