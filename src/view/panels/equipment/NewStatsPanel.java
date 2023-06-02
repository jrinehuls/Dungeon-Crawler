package view.panels.equipment;

import view.frames.EquipmentFrame;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import java.awt.*;

public class NewStatsPanel extends JPanel {

    JLabel newStatsLabel = new JLabel("New Stats: ");
    JLabel newBlankLabel = new JLabel(""); // Needed for placeholder in GridLayout
    JLabel newMaxHPLabel = new JLabel("Max HP: " + PlayerPanel.getPlayer().getHP());
    JLabel newMaxMPLabel = new JLabel("Max MP: " + PlayerPanel.getPlayer().getMP());
    JLabel newAttackLabel = new JLabel("Attack: " + PlayerPanel.getPlayer().getAttack());
    JLabel newDefenseLabel = new JLabel("Defense: " + PlayerPanel.getPlayer().getDefense());
    JLabel newMagicAttackLabel = new JLabel("Magic Attack: " + PlayerPanel.getPlayer().getMagicAttack());
    JLabel newMagicDefenseLabel = new JLabel("Magic Defense: " + PlayerPanel.getPlayer().getMagicDefense());
    JLabel newSpeedLabel = new JLabel("Speed: " + PlayerPanel.getPlayer().getSpeed());

    JLabel[] newStatsLabels = {newStatsLabel, newBlankLabel, newMaxHPLabel, newMaxMPLabel, newAttackLabel,
            newDefenseLabel, newMagicAttackLabel, newMagicDefenseLabel, newSpeedLabel};

    public NewStatsPanel() {
        super(new GridLayout(5, 2, 0, 0));

        this.setPreferredSize(new Dimension(EquipmentFrame.SCREEN_WIDTH/2, EquipmentFrame.STATS_PANEL_HEIGHT));
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

    public void setNewMaxHPLabel(int maxHP) {
        newMaxHPLabel.setText("Max HP: " + (PlayerPanel.getPlayer().getMaxHP() + maxHP));
    }

    public void setNewMaxMPLabel(int maxMP) {
        newMaxMPLabel.setText("Max MP: " + (PlayerPanel.getPlayer().getMaxMP() + maxMP));
    }

    public void setNewAttackLabel(int attack) {
        newAttackLabel.setText("Attack: " + (PlayerPanel.getPlayer().getAttack() + attack));
    }

    public void setNewDefenseLabel(int defense) {
        newDefenseLabel.setText("Defense: " + (PlayerPanel.getPlayer().getDefense() + defense));
    }

    public void setNewMagicAttackLabel(int magicAttack) {
        newMagicAttackLabel.setText("Magic Attack: " + (PlayerPanel.getPlayer().getMagicAttack() + magicAttack));
    }

    public void setNewMagicDefenseLabel(int magicDefense) {
        newMagicDefenseLabel.setText("Magic Defense: " + (PlayerPanel.getPlayer().getMagicDefense() + magicDefense));
    }

    public void setNewSpeedLabel(int speed) {
        newSpeedLabel.setText("Speed: " + (PlayerPanel.getPlayer().getSpeed() + speed));
    }

}
