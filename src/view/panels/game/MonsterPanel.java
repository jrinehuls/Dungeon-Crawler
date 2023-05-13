package view.panels.game;

import collections.monster.MonsterCollection;
import controller.MonsterController;
import model.entity.monster.Monster;

import javax.swing.*;
import java.awt.*;

public class MonsterPanel extends JPanel {

    public final static int SCREEN_WIDTH = PlayerPanel.SCREEN_WIDTH;
    public final static int SCREEN_HEIGHT = 350;


    private static final JLabel nameLabel = new JLabel("", JLabel.CENTER);
    private static final JLabel hpLabel = new JLabel("", JLabel.CENTER);
    private static final JLabel mpLabel = new JLabel("", JLabel.CENTER);
    private static final JLabel attackLabel = new JLabel("", JLabel.CENTER);
    private static final JLabel defenseLabel = new JLabel("", JLabel.CENTER);
    private static final JLabel magicAttackLabel = new JLabel("", JLabel.CENTER);
    private static final JLabel magicDefenseLabel = new JLabel("", JLabel.CENTER);
    private static final JLabel speedLabel = new JLabel("", JLabel.CENTER);
    private static final JProgressBar speedProgress = new JProgressBar();

    static JLabel[] labels = { nameLabel, hpLabel, mpLabel, attackLabel, defenseLabel,
            magicAttackLabel, magicDefenseLabel, speedLabel };

    static String lastPosition = MapPanel.getPosition();
    static String currentPosition;

    static Monster monster;

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
        // If player moved, get a new monster
        currentPosition = MapPanel.getPosition();
        if (!lastPosition.equals(currentPosition)) {
            monster = new MonsterCollection().getMonster();
            lastPosition = currentPosition;
        }

        // Monster takes action or dies
        MonsterController.handleMonster();

        // Set info for labels and progress bar
        if (isMonster()) {
            setMonsterDetails();
            MonsterController.progress();
        } else {
            clearMonsterDetails();
        }

    }

    public static boolean isMonster() {
        return monster != null;
    }

    public static Monster getMonster() {
        return monster;
    }

    public static void clearMonster() {
        monster = null;
    }

}
