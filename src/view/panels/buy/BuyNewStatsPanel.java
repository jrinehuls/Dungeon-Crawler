package view.panels.buy;

import view.frames.BuyFrame;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import java.awt.*;

public class BuyNewStatsPanel extends JPanel {
    JLabel newStatsLabel = new JLabel("New Stats: ");
    JLabel newBlankLabel = new JLabel(""); // Needed for placeholder in GridLayout
    JLabel newMaxHPLabel = new JLabel("Max HP: " + PlayerPanel.getPlayer().getHP());
    JLabel newMaxMPLabel = new JLabel("Max MP: " + PlayerPanel.getPlayer().getMP());
    JLabel newAttackLabel = new JLabel("Attack: " + PlayerPanel.getPlayer().getAttack());
    JLabel newDefenseLabel = new JLabel("Defense: " + PlayerPanel.getPlayer().getDefense());
    JLabel newMagicAttackLabel = new JLabel("Magic Attack: " + PlayerPanel.getPlayer().getMagicAttack());
    JLabel newMagicDefenseLabel = new JLabel("Magic Defense: " + PlayerPanel.getPlayer().getMagicDefense());
    JLabel newSpeedLabel = new JLabel("Speed: " + PlayerPanel.getPlayer().getSpeed());
    JLabel newGoldLabel = new JLabel("Gold: " + PlayerPanel.getPlayer().getGold());

    JLabel[] newStatsLabels = {newStatsLabel, newBlankLabel, newMaxHPLabel, newMaxMPLabel, newAttackLabel,
            newDefenseLabel, newMagicAttackLabel, newMagicDefenseLabel, newSpeedLabel, newGoldLabel};

    public BuyNewStatsPanel() {
        super(new GridLayout(5, 2, 0, 0));

        this.setPreferredSize(new Dimension(BuyFrame.LEFT_PANEL_WIDTH, BuyFrame.STATS_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.ORANGE);

        int newStatsCounter = 0;
        for (JLabel label: newStatsLabels) {
            if (newStatsCounter % 2 ==0) {
                label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
            }
            this.add(label);
            newStatsCounter++;
        }
    }

    private void setLabelColor(JLabel label, int stat) {
        if (stat == 0) {
            label.setForeground(Color.BLACK);
        } else if (stat < 0) {
            label.setForeground(Color.RED);
        } else {
            label.setForeground(new Color(25, 200, 75));
        }
    }

    public void setNewMaxHPLabel(int maxHP) {
        setLabelColor(newMaxHPLabel, maxHP);
        newMaxHPLabel.setText("Max HP: " + (PlayerPanel.getPlayer().getMaxHP() + maxHP));
    }

    public void setNewMaxMPLabel(int maxMP) {
        setLabelColor(newMaxMPLabel, maxMP);
        newMaxMPLabel.setText("Max MP: " + (PlayerPanel.getPlayer().getMaxMP() + maxMP));
    }

    public void setNewAttackLabel(int attack) {
        setLabelColor(newAttackLabel, attack);
        newAttackLabel.setText("Attack: " + (PlayerPanel.getPlayer().getAttack() + attack));
    }

    public void setNewDefenseLabel(int defense) {
        setLabelColor(newDefenseLabel, defense);
        newDefenseLabel.setText("Defense: " + (PlayerPanel.getPlayer().getDefense() + defense));
    }

    public void setNewMagicAttackLabel(int magicAttack) {
        setLabelColor(newMagicAttackLabel, magicAttack);
        newMagicAttackLabel.setText("Magic Attack: " + (PlayerPanel.getPlayer().getMagicAttack() + magicAttack));
    }

    public void setNewMagicDefenseLabel(int magicDefense) {
        setLabelColor(newMagicDefenseLabel, magicDefense);
        newMagicDefenseLabel.setText("Magic Defense: " + (PlayerPanel.getPlayer().getMagicDefense() + magicDefense));
    }

    public void setNewSpeedLabel(int speed) {
        setLabelColor(newSpeedLabel, speed);
        newSpeedLabel.setText("Speed: " + (PlayerPanel.getPlayer().getSpeed() + speed));
    }

    public void setNewGoldLabel(int gold) {
        setLabelColor(newGoldLabel, gold);
        newGoldLabel.setText("Gold: " + (PlayerPanel.getPlayer().getGold() + gold));
    }
}
