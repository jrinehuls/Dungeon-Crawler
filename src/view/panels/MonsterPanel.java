package view.panels;

import model.monster.Monster;

import javax.swing.*;
import java.awt.*;

public class MonsterPanel extends JPanel {

    public final static int SCREEN_WIDTH = PlayerPanel.SCREEN_WIDTH;
    public final static int SCREEN_HEIGHT = PlayerPanel.SCREEN_HEIGHT;
    static Monster monster = GamePanel.getMonster();
    static JLabel nameLabel;
    static JLabel hpLabel;
    static JLabel attackLabel;
    static JLabel defenseLabel;
    static JLabel speedLabel;

    public MonsterPanel() {
        this.setLayout(null);
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        nameLabel = new JLabel("", 0);
        nameLabel.setBounds(0, 10, SCREEN_WIDTH, 20);
        this.add(nameLabel);

        hpLabel = new JLabel("", 0);
        hpLabel.setBounds(0, 40, SCREEN_WIDTH, 20);
        this.add(hpLabel);

        attackLabel = new JLabel("", 0);
        attackLabel.setBounds(0, 70, SCREEN_WIDTH, 20);
        this.add(attackLabel);

        defenseLabel = new JLabel("", 0);
        defenseLabel.setBounds(0, 100, SCREEN_WIDTH, 20);
        this.add(defenseLabel);

        speedLabel = new JLabel("", 0);
        speedLabel.setBounds(0, 130, SCREEN_WIDTH, 20);
        this.add(speedLabel);

    }

    public static void update() {
        monster = GamePanel.getMonster();
        if (monster != null) {
            nameLabel.setText("A wild " + monster.getName() + " appeared!");
            hpLabel.setText("HP: " + monster.getHp() + "/" + monster.getMaxHP());
            attackLabel.setText("Attack: " + monster.getAttack());
            defenseLabel.setText("Defense: " + monster.getDefense());
            speedLabel.setText("Speed: " + monster.getSpeed());
        } else {
            nameLabel.setText("");
            hpLabel.setText("");
            attackLabel.setText("");
            defenseLabel.setText("");
            speedLabel.setText("");
        }
    }


}
