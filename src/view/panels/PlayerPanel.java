package view.panels;

import model.player.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {

    public static final int SCREEN_WIDTH = MapPanel.SCREEN_EDGE_LENGTH;
    public static final int SCREEN_HEIGHT = 350;
    private static Player player = new Player();
    private static JLabel levelLabel;
    private static JLabel expLabel;
    private static JLabel hpLabel;
    private static JLabel attackLabel;
    private static JLabel defenseLabel;
    private static JLabel speedLabel;
    private static JLabel goldLabel;

    public PlayerPanel() {

        this.setLayout(null);
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        levelLabel = new JLabel("Level: " + player.getLevel(), 0);
        levelLabel.setBounds(0, 10, SCREEN_WIDTH, 20);
        this.add(levelLabel);

        expLabel = new JLabel("Exp: " + player.getExp() + "/" + player.getNextExp(), 0);
        expLabel.setBounds(0, 40, SCREEN_WIDTH, 20);
        this.add(expLabel);

        hpLabel = new JLabel("HP: " + player.getHp() + "/" + player.getMaxHP(), 0);
        hpLabel.setBounds(0, 70, SCREEN_WIDTH, 20);
        this.add(hpLabel);

        attackLabel = new JLabel("Attack: " + player.getAttack(), 0);
        attackLabel.setBounds(0, 100, SCREEN_WIDTH, 20);
        this.add(attackLabel);

        defenseLabel = new JLabel("Defense: " + player.getDefense(), 0);
        defenseLabel.setBounds(0, 130, SCREEN_WIDTH, 20);
        this.add(defenseLabel);

        speedLabel = new JLabel("Speed: " + player.getSpeed(), 0);
        speedLabel.setBounds(0, 160, SCREEN_WIDTH, 20);
        this.add(speedLabel);

        goldLabel = new JLabel("Gold: " + player.getGold(), 0);
        goldLabel.setBounds(0, 190, SCREEN_WIDTH, 20);
        this.add(goldLabel);

    }

    public static Player getPlayer() {
        return player;
    }

    public static void update() {
        levelLabel.setText("Level: " + player.getLevel());
        expLabel.setText("Exp: " + player.getExp() + "/" + player.getNextExp());
        hpLabel.setText("HP: " + player.getHp() + "/" + player.getMaxHP());
        attackLabel.setText("Attack: " + player.getAttack());
        defenseLabel.setText("Defense: " + player.getDefense());
        speedLabel.setText("Speed: " + player.getSpeed());
        goldLabel.setText("Gold: " + player.getGold());
    }


}
