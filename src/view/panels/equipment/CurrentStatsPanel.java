package view.panels.equipment;

import view.frames.EquipmentFrame;
import view.panels.game.GamePanel;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import java.awt.*;

public class CurrentStatsPanel extends JPanel {

    JLabel currentStatsLabel = new JLabel("Current Stats: ");
    JLabel currentBlankLabel = new JLabel("");
    JLabel currentMaxHPLabel = new JLabel("Max HP: " + PlayerPanel.getPlayer().getMaxHP());
    JLabel currentMaxMPLabel = new JLabel("Max MP: ");
    JLabel currentAttackLabel = new JLabel("Attack: ");
    JLabel currentDefenseLabel = new JLabel("Defense: ");
    JLabel currentMagicAttackLabel = new JLabel("Magic Attack: ");
    JLabel currentMagicDefenseLabel = new JLabel("Magic Defense: ");
    JLabel currentSpeedLabel = new JLabel("Speed: ");

    JLabel[] currentStatsLabels = {currentStatsLabel, currentBlankLabel, currentMaxHPLabel, currentMaxMPLabel,
            currentAttackLabel, currentDefenseLabel, currentMagicAttackLabel, currentMagicDefenseLabel, currentSpeedLabel};

    public  CurrentStatsPanel() {
        super(new GridLayout(5, 2, 0, 0));

        this.setPreferredSize(new Dimension(EquipmentFrame.SCREEN_WIDTH/2, EquipmentFrame.STATS_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.GREEN);

        // TODO: add stuff to current stats panel
        int currentStatsCounter = 0;
        for (JLabel label: currentStatsLabels) {
            if (currentStatsCounter % 2 ==0) {
                label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
            }
            this.add(label);
            currentStatsCounter++;
        }
    }
}
