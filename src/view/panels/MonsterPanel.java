package view.panels;

import model.monster.Monster;
import model.player.Player;

import javax.swing.*;
import java.awt.*;

public class MonsterPanel extends JPanel implements Runnable {

    public final static int SCREEN_WIDTH = PlayerPanel.SCREEN_WIDTH;
    public final static int SCREEN_HEIGHT = PlayerPanel.SCREEN_HEIGHT;
    static Monster monster = GamePanel.getMonster();
    static JLabel nameLabel;
    static JLabel hpLabel;
    static JLabel attackLabel;
    static JLabel defenseLabel;
    static JLabel speedLabel;
    Thread gameThread = new Thread(this);

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

        gameThread.start();
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

    @Override
    public void run() {
        //game loop
        long lastTime = System.nanoTime();
        long currentTime;
        final double FPS = 30.0;
        final double drawInterval = 1_000_000_000 / FPS;
        double delta = 0;
        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            if(delta >= 1) {
                update();
                delta = 0.0;
            }
            lastTime = currentTime;
        }
    }
}
