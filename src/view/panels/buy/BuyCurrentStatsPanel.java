package view.panels.buy;

import view.frames.BuyFrame;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import java.awt.*;

public class BuyCurrentStatsPanel extends JPanel {

    JLabel currentStatsLabel = new JLabel("Current Stats: ");
    JLabel currentBlankLabel = new JLabel(""); // Needed for placeholder in GridLayout
    JLabel currentMaxHPLabel = new JLabel("Max HP: " + PlayerPanel.getPlayer().getMaxHP());
    JLabel currentMaxMPLabel = new JLabel("Max MP: " + PlayerPanel.getPlayer().getMaxMP());
    JLabel currentAttackLabel = new JLabel("Attack: " + PlayerPanel.getPlayer().getAttack());
    JLabel currentDefenseLabel = new JLabel("Defense: " + PlayerPanel.getPlayer().getDefense());
    JLabel currentMagicAttackLabel = new JLabel("Magic Attack: " + PlayerPanel.getPlayer().getMagicAttack());
    JLabel currentMagicDefenseLabel = new JLabel("Magic Defense: " + PlayerPanel.getPlayer().getMagicDefense());
    JLabel currentSpeedLabel = new JLabel("Speed: " + PlayerPanel.getPlayer().getSpeed());
    JLabel currentGoldLabel = new JLabel("Gold: " + PlayerPanel.getPlayer().getGold());

    JLabel[] currentStatsLabels = {currentStatsLabel, currentBlankLabel, currentMaxHPLabel, currentMaxMPLabel,
            currentAttackLabel, currentDefenseLabel, currentMagicAttackLabel, currentMagicDefenseLabel,
            currentSpeedLabel, currentGoldLabel};

    public BuyCurrentStatsPanel() {
        super(new GridLayout(5, 2, 0, 0));

        this.setPreferredSize(new Dimension(BuyFrame.LEFT_PANEL_WIDTH, BuyFrame.STATS_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.MAGENTA);

        // Add stuff to current stats panel
        int currentStatsCounter = 0;
        for (JLabel label: currentStatsLabels) {
            if (currentStatsCounter % 2 == 0) {
                label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
            }
            this.add(label);
            currentStatsCounter++;
        }
    }

    public void updateLabels() {
        currentMaxHPLabel.setText("Max HP: " + PlayerPanel.getPlayer().getMaxHP());
        currentMaxMPLabel.setText("Max MP: " + PlayerPanel.getPlayer().getMaxMP());
        currentAttackLabel.setText("Attack: " + PlayerPanel.getPlayer().getAttack());
        currentDefenseLabel.setText("Defense: " + PlayerPanel.getPlayer().getDefense());
        currentMagicAttackLabel.setText("Magic Attack: " + PlayerPanel.getPlayer().getMagicAttack());
        currentMagicDefenseLabel.setText("Magic Defense: " + PlayerPanel.getPlayer().getMagicDefense());
        currentSpeedLabel.setText("Speed: " + PlayerPanel.getPlayer().getSpeed());
        currentGoldLabel.setText("Gold: " + PlayerPanel.getPlayer().getGold());
    }
}
