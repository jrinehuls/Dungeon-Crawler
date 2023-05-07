package view.panels;

import model.entity.monster.Monster;
import model.entity.player.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {

    public static final int SCREEN_WIDTH = MapPanel.SCREEN_WIDTH;
    public static final int SCREEN_HEIGHT = MonsterPanel.SCREEN_HEIGHT;
    private static Player player = new Player(); //Needs to be instantiated here because of other panel dependencies
    private static Monster monster = GamePanel.getMonster();
    private static JLabel levelLabel = new JLabel("", JLabel.CENTER);
    private static JLabel expLabel = new JLabel("", JLabel.CENTER);
    private static JLabel hpLabel = new JLabel("", JLabel.CENTER);
    private static JLabel mpLabel = new JLabel("", JLabel.CENTER);
    private static JLabel attackLabel = new JLabel("", JLabel.CENTER);
    private static JLabel defenseLabel = new JLabel("", JLabel.CENTER);
    private static JLabel magicAttackLabel = new JLabel("", JLabel.CENTER);
    private static JLabel magicDefenseLabel = new JLabel("", JLabel.CENTER);
    private static JLabel speedLabel = new JLabel("", JLabel.CENTER);
    private static JLabel goldLabel = new JLabel("", JLabel.CENTER);
    private static JProgressBar speedProgress = new JProgressBar();

    static JLabel[] labels = {levelLabel, expLabel, hpLabel, mpLabel, attackLabel, defenseLabel,
                              magicAttackLabel, magicDefenseLabel, speedLabel, goldLabel};

    public PlayerPanel() {

        final int COMPONENT_WIDTH = SCREEN_WIDTH - 30;
        final int LABEL_HEIGHT = 20;
        final int HGAP = 30;
        final int VGAP = 10;

        this.setLayout(new FlowLayout(FlowLayout.CENTER, HGAP, VGAP));
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        for (JLabel label: labels) {
            label.setPreferredSize(new Dimension(COMPONENT_WIDTH, LABEL_HEIGHT));
            this.add(label);
        }

        speedProgress.setPreferredSize(new Dimension(COMPONENT_WIDTH, 30));
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
        speedProgress.setValue((int) player.getProgress());
    }

    public static void progress() {
        monster = GamePanel.getMonster();
        boolean barIsProgressable = player.getProgress() < 100 && monster != null;
        if (barIsProgressable) {
            player.setProgress(player.getProgress() + (player.getSpeed() / 10.0));
        }
    }

    public static void update() {
        player.levelUp();
        setPlayerDetails();
        progress();
    }


}
