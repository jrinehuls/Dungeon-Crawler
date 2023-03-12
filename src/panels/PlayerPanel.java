package panels;

import model.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {

    final int SCREEN_WIDTH = MapPanel.SCREEN_EDGE_LENGTH;
    final int SCREEN_HEIGHT = 350;
    Player player = new Player(0,1);
    JLabel hpLabel;


    public PlayerPanel() {
        this.setLayout(null);
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        hpLabel = new JLabel("HP: " + player.getHp() + "/" + player.getMaxHP(), 0);
        hpLabel.setBounds(0, 10, SCREEN_WIDTH, 20);
        this.add(hpLabel);


    }
}
