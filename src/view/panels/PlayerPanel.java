package view.panels;

import controller.ActionButtonController;
import model.monster.Monster;
import model.player.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {

    public static final int SCREEN_WIDTH = MapPanel.SCREEN_WIDTH;
    public static final int SCREEN_HEIGHT = MonsterPanel.SCREEN_HEIGHT;
    private static Player player = new Player(); //Needs to be instantiated here because of other panel dependencies
    private static Monster monster;
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
    private static JProgressBar speedProgress;

    public PlayerPanel() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        monster = GamePanel.getMonster();

        levelLabel = new JLabel("", JLabel.CENTER);
        levelLabel.setBounds(0, 10, SCREEN_WIDTH, 20);
        this.add(levelLabel);

        expLabel = new JLabel();
        expLabel.setBounds(0, 40, SCREEN_WIDTH, 20);
        this.add(expLabel);

        hpLabel = new JLabel();
        hpLabel.setBounds(0, 70, SCREEN_WIDTH, 20);
        this.add(hpLabel);

        mpLabel = new JLabel();
        mpLabel.setBounds(0, 100, SCREEN_WIDTH, 20);
        this.add(mpLabel);

        attackLabel = new JLabel();
        attackLabel.setBounds(0, 130, SCREEN_WIDTH, 20);
        this.add(attackLabel);

        defenseLabel = new JLabel();
        defenseLabel.setBounds(0, 160, SCREEN_WIDTH, 20);
        this.add(defenseLabel);

        magicAttackLabel = new JLabel();
        magicAttackLabel.setBounds(0, 190, SCREEN_WIDTH, 20);
        this.add(magicAttackLabel);

        magicDefenseLabel = new JLabel();
        magicDefenseLabel.setBounds(0, 220, SCREEN_WIDTH, 20);
        this.add(magicDefenseLabel);

        speedLabel = new JLabel();
        speedLabel.setBounds(0, 250, SCREEN_WIDTH, 20);
        this.add(speedLabel);

        goldLabel = new JLabel();
        goldLabel.setBounds(0, 280, SCREEN_WIDTH, 20);
        this.add(goldLabel);

        speedProgress = new JProgressBar();
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
        boolean barIsProgressable = player.getProgress() < 100 && monster != null; // && !ActionButtonController.spellFrame.isDisplayable();
        monster = GamePanel.getMonster();
        if (barIsProgressable) {
            player.setProgress(player.getProgress() + (player.getSpeed() / 10.0));
        }
    }


}
