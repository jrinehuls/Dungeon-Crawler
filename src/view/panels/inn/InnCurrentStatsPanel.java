package view.panels.inn;

import view.frames.InnFrame;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import java.awt.*;

public class InnCurrentStatsPanel extends JPanel {

    JLabel currentStatsLabel = new JLabel("Current Stats: ");
    JLabel currentBlankLabel = new JLabel(""); // Needed for placeholder in GridLayout
    JLabel currentHPLabel = new JLabel("HP: " + PlayerPanel.getPlayer().getHP());
    JLabel currentMaxHPLabel = new JLabel("Max HP: " + PlayerPanel.getPlayer().getMaxHP());
    JLabel currentMPLabel = new JLabel("MP: " + PlayerPanel.getPlayer().getMP());
    JLabel currentMaxMPLabel = new JLabel("Max MP: " + PlayerPanel.getPlayer().getMaxMP());
    JLabel currentGoldLabel = new JLabel("Gold: " + PlayerPanel.getPlayer().getGold());

    JLabel[] currentStatsLabels = {currentStatsLabel, currentBlankLabel, currentHPLabel, currentMaxHPLabel,
            currentMPLabel, currentMaxMPLabel, currentGoldLabel};

    public InnCurrentStatsPanel() {
        super(new GridLayout(4, 2, 0, 0));

        this.setPreferredSize(new Dimension(InnFrame.PANEL_WIDTH, InnFrame.PANEL_HEIGHT / 2));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.MAGENTA);

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
        currentHPLabel.setText("HP: " + PlayerPanel.getPlayer().getHP());
        currentMaxHPLabel.setText("Max HP: " + PlayerPanel.getPlayer().getMaxHP());
        currentMPLabel.setText("MP: " + PlayerPanel.getPlayer().getMP());
        currentMaxMPLabel.setText("Max MP: " + PlayerPanel.getPlayer().getMaxMP());
        currentGoldLabel.setText("Gold: " + PlayerPanel.getPlayer().getGold());
    }

}
