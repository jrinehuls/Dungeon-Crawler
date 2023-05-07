package view.panels;

import model.entity.monster.Monster;
import model.entity.player.Player;

import javax.swing.*;
import java.awt.*;

public class MonsterPanel extends JPanel {

    public final static int SCREEN_WIDTH = PlayerPanel.SCREEN_WIDTH;
    public final static int SCREEN_HEIGHT = 350;
    static Monster monster = GamePanel.getMonster();
    static Player player = PlayerPanel.getPlayer();
    private static JProgressBar speedProgress = new JProgressBar();
    private static JLabel nameLabel = new JLabel("", JLabel.CENTER);
    private static JLabel hpLabel = new JLabel("", JLabel.CENTER);
    private static JLabel mpLabel = new JLabel("", JLabel.CENTER);
    private static JLabel attackLabel = new JLabel("", JLabel.CENTER);
    private static JLabel defenseLabel = new JLabel("", JLabel.CENTER);
    private static JLabel magicAttackLabel = new JLabel("", JLabel.CENTER);
    private static JLabel magicDefenseLabel = new JLabel("", JLabel.CENTER);
    private static JLabel speedLabel = new JLabel("", JLabel.CENTER);

    static JLabel[] labels = { nameLabel, hpLabel, mpLabel, attackLabel, defenseLabel,
            magicAttackLabel, magicDefenseLabel, speedLabel };

    public MonsterPanel() {

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
        speedProgress.setVisible(false);

    }

    private static void setMonsterDetails() {
        nameLabel.setText("A wild " + monster.getName() + " appeared!");
        hpLabel.setText("HP: " + monster.getHP() + "/" + monster.getMaxHP());
        mpLabel.setText("MP: " + monster.getMP() + "/" + monster.getMaxMP());
        attackLabel.setText("Attack: " + monster.getAttack());
        defenseLabel.setText("Defense: " + monster.getDefense());
        magicAttackLabel.setText("Magic Attack: " + monster.getMagicAttack());
        magicDefenseLabel.setText("Magic Defense: " + monster.getMagicDefense());
        speedLabel.setText("Speed: " + monster.getSpeed());
        speedProgress.setValue((int)monster.getProgress());
        speedProgress.setVisible(true);
    }

    private static void clearMonsterDetails() {
        nameLabel.setText("");
        hpLabel.setText("");
        mpLabel.setText("");
        attackLabel.setText("");
        defenseLabel.setText("");
        magicAttackLabel.setText("");
        magicDefenseLabel.setText("");
        speedLabel.setText("");
        speedProgress.setVisible(false);
    }

    public static void update() {
        monster = GamePanel.getMonster();
        boolean barIsProgressable = player.getProgress() < 100; // && !ActionButtonController.spellFrame.isDisplayable();
        if (monster != null) {
            setMonsterDetails();
            if (barIsProgressable) {
                monster.setProgress(monster.getProgress() + (monster.getSpeed() / 10.0));
            }
        } else {
            clearMonsterDetails();
        }
    }
}
