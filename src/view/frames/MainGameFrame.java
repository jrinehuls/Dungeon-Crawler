package view.frames;

import view.panels.*;

import javax.swing.*;
import java.awt.*;

public class MainGameFrame extends JFrame {

    // Set up vertical panels to add game panels to
    JPanel leftPanel = new JPanel();
    JPanel middlePanel = new JPanel();
    JPanel rightPanel = new JPanel();

    public MainGameFrame() {

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        // ------------------------------<Left Panel Stuff>------------------------------------
        leftPanel.setPreferredSize(new Dimension(MapPanel.SCREEN_WIDTH, MapPanel.SCREEN_HEIGHT + MonsterPanel.SCREEN_HEIGHT));
        leftPanel.setBackground(Color.black);
        leftPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 0));
        leftPanel.add(new MapPanel());
        leftPanel.add(new MonsterPanel());
        this.add(leftPanel);

        // ------------------------------<Middle Panel Stuff>------------------------------------
        middlePanel.setPreferredSize(new Dimension(GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT + DisplayPanel.SCREEN_HEIGHT));
        middlePanel.setBackground(Color.red);
        middlePanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 0));
        middlePanel.add(new GamePanel());
        middlePanel.add(new DisplayPanel());
        this.add(middlePanel);

        // ------------------------------<Right Panel Stuff>------------------------------------
        rightPanel.setPreferredSize(new Dimension(ActionPanel.SCREEN_WIDTH,ActionPanel.SCREEN_HEIGHT + PlayerPanel.SCREEN_HEIGHT));
        rightPanel.setBackground(Color.GREEN);
        rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        rightPanel.add(new ActionPanel());
        rightPanel.add(new PlayerPanel());
        this.add(rightPanel);

        // ------------------------------<Frame Stuff>------------------------------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setIconImage(new ImageIcon("src/res/monsters/Spaghetti.png").getImage());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
