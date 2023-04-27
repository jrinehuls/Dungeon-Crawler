package view.panels;

import controller.ActionButtonController;
import model.monster.Monster;
import model.player.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {

    public static final int SCREEN_WIDTH = MapPanel.SCREEN_EDGE_LENGTH;
    public static final int SCREEN_HEIGHT = 350;
    private static Player player = new Player();
    static Monster monster;
    private static JLabel levelLabel;
    private static JLabel expLabel;
    private static JLabel hpLabel;
    private static JLabel mpLabel;
    private static JLabel attackLabel;
    private static JLabel defenseLabel;
    private static JLabel magicAttackLabel;
    private static JLabel magicDefenseLabel;
    private static JLabel speedLabel;
    private static JLabel goldLabel;
    static JProgressBar speedProgress = new JProgressBar();

    public PlayerPanel() {

        monster = GamePanel.getMonster();

        this.setLayout(null);
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        levelLabel = new JLabel("Level: " + player.getLevel(), 0);
        levelLabel.setBounds(0, 10, SCREEN_WIDTH, 20);
        this.add(levelLabel);

        expLabel = new JLabel("Exp: " + player.getExp() + "/" + player.getNextExp(), 0);
        expLabel.setBounds(0, 40, SCREEN_WIDTH, 20);
        this.add(expLabel);

        hpLabel = new JLabel("HP: " + player.getHP() + "/" + player.getMaxHP(), 0);
        hpLabel.setBounds(0, 70, SCREEN_WIDTH, 20);
        this.add(hpLabel);

        mpLabel = new JLabel("MP: " + player.getMP() + "/" + player.getMaxMP(), 0);
        mpLabel.setBounds(0, 100, SCREEN_WIDTH, 20);
        this.add(mpLabel);

        attackLabel = new JLabel("Attack: " + player.getAttack(), 0);
        attackLabel.setBounds(0, 130, SCREEN_WIDTH, 20);
        this.add(attackLabel);

        defenseLabel = new JLabel("Defense: " + player.getDefense(), 0);
        defenseLabel.setBounds(0, 160, SCREEN_WIDTH, 20);
        this.add(defenseLabel);

        magicAttackLabel = new JLabel("Magic Attack: " + player.getMagicAttack(), 0);
        magicAttackLabel.setBounds(0, 190, SCREEN_WIDTH, 20);
        this.add(magicAttackLabel);

        magicDefenseLabel = new JLabel("Magic Defense: " + player.getMagicDefense(), 0);
        magicDefenseLabel.setBounds(0, 220, SCREEN_WIDTH, 20);
        this.add(magicDefenseLabel);

        speedLabel = new JLabel("Speed: " + player.getSpeed(), 0);
        speedLabel.setBounds(0, 250, SCREEN_WIDTH, 20);
        this.add(speedLabel);

        goldLabel = new JLabel("Gold: " + player.getGold(), 0);
        goldLabel.setBounds(0, 280, SCREEN_WIDTH, 20);
        this.add(goldLabel);

        speedProgress.setBounds(10, 310, SCREEN_WIDTH - 20, 20);
        this.add(speedProgress);
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayerDetails() {
        levelLabel.setText("Level: " + player.getLevel());
        expLabel.setText("Exp: " + player.getExp() + "/" + player.getNextExp());
        hpLabel.setText("HP: " + player.getHP() + "/" + player.getMaxHP());
        mpLabel.setText("MP: " + player.getMP() + "/" + player.getMaxMP());
        attackLabel.setText("Attack: " + player.getAttack());
        defenseLabel.setText("Defense: " + player.getDefense());
        magicAttackLabel.setText("Magic Attack: " + player.getMagicAttack());
        magicDefenseLabel.setText("Magic Defense: " + player.getMagicDefense());
        speedLabel.setText("Speed: " + player.getSpeed());
        goldLabel.setText("Gold: " + player.getGold());
        speedProgress.setValue((int)player.getProgress());
    }

    public static void update() {
        setPlayerDetails();
        boolean barIsProgressable = player.getProgress() < 100 && monster != null && !ActionButtonController.spellFrame.isDisplayable();
        monster = GamePanel.getMonster();
        if (barIsProgressable) {
            player.setProgress(player.getProgress() + (player.getSpeed() / 10.0));
        }
    }


}
