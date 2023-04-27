package view.panels;

import controller.ActionButtonController;
import model.monster.Monster;
import model.player.Player;

import javax.swing.*;
import java.awt.*;

public class MonsterPanel extends JPanel {

    public final static int SCREEN_WIDTH = PlayerPanel.SCREEN_WIDTH;
    public final static int SCREEN_HEIGHT = PlayerPanel.SCREEN_HEIGHT;
    static Monster monster = GamePanel.getMonster();
    static Player player = PlayerPanel.getPlayer();
    private static JLabel nameLabel;
    private static JLabel hpLabel;
    private static JLabel mpLabel;
    private static JLabel attackLabel;
    private static JLabel defenseLabel;
    private static JLabel magicAttackLabel;
    private static JLabel magicDefenseLabel;
    private static JLabel speedLabel;
    private static JProgressBar speedProgress = new JProgressBar();


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

        mpLabel = new JLabel("", 0);
        mpLabel.setBounds(0, 70, SCREEN_WIDTH, 20);
        this.add(mpLabel);

        attackLabel = new JLabel("", 0);
        attackLabel.setBounds(0, 100, SCREEN_WIDTH, 20);
        this.add(attackLabel);

        defenseLabel = new JLabel("", 0);
        defenseLabel.setBounds(0, 130, SCREEN_WIDTH, 20);
        this.add(defenseLabel);

        magicAttackLabel = new JLabel("", 0);
        magicAttackLabel.setBounds(0, 160, SCREEN_WIDTH, 20);
        this.add(magicAttackLabel);

        magicDefenseLabel = new JLabel("", 0);
        magicDefenseLabel.setBounds(0, 190, SCREEN_WIDTH, 20);
        this.add(magicDefenseLabel);

        speedLabel = new JLabel("", 0);
        speedLabel.setBounds(0, 220, SCREEN_WIDTH, 20);
        this.add(speedLabel);

        speedProgress.setBounds(10, 250, SCREEN_WIDTH - 20, 20);
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
        boolean barIsProgressable = player.getProgress() < 100 && !ActionButtonController.spellFrame.isDisplayable();
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
