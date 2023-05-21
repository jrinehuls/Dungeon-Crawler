package view.panels.equipment;

import view.frames.EquipmentFrame;

import javax.swing.*;
import java.awt.*;

public class NewStatsPanel extends JPanel {

    JLabel newStatsLabel = new JLabel("New Stats: ");
    JLabel newBlankLabel = new JLabel("");
    JLabel newMaxHPLabel = new JLabel("Max HP: ");
    JLabel newMaxMPLabel = new JLabel("Max MP: ");
    JLabel newAttackLabel = new JLabel("Attack: ");
    JLabel newDefenseLabel = new JLabel("Defense: ");
    JLabel newMagicAttackLabel = new JLabel("Magic Attack: ");
    JLabel newMagicDefenseLabel = new JLabel("Magic Defense: ");
    JLabel newSpeedLabel = new JLabel("Speed: ");

    JLabel[] newStatsLabels = {newStatsLabel, newBlankLabel, newMaxHPLabel, newMaxMPLabel, newAttackLabel,
            newDefenseLabel, newMagicAttackLabel, newMagicDefenseLabel, newSpeedLabel};

    public NewStatsPanel() {
        super(new GridLayout(5, 2, 0, 0));

        this.setPreferredSize(new Dimension(EquipmentFrame.SCREEN_WIDTH/2, EquipmentFrame.STATS_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.ORANGE);


        // TODO: add stuff to new stats panel
        int newStatsCounter = 0;
        for (JLabel label: newStatsLabels) {
            if (newStatsCounter % 2 ==0) {
                label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
            }
            this.add(label);
            newStatsCounter++;
        }

    }
}
