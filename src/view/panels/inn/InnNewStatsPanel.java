package view.panels.inn;

import view.frames.InnFrame;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import java.awt.*;

public class InnNewStatsPanel extends JPanel {

    JLabel newStatsLabel = new JLabel("New Stats: ");
    JLabel newBlankLabel = new JLabel(""); // Needed for placeholder in GridLayout
    JLabel newHPLabel = new JLabel("HP: " + PlayerPanel.getPlayer().getHP());
    JLabel newMaxHPLabel = new JLabel("Max HP: " + PlayerPanel.getPlayer().getMaxHP());
    JLabel newMPLabel = new JLabel("MP: " + PlayerPanel.getPlayer().getMP());
    JLabel newMaxMPLabel = new JLabel("Max MP: " + PlayerPanel.getPlayer().getMaxMP());
    JLabel newGoldLabel = new JLabel("Gold: " + PlayerPanel.getPlayer().getGold());

    JLabel[] newStatsLabels = {newStatsLabel, newBlankLabel, newHPLabel, newMaxHPLabel,
            newMPLabel, newMaxMPLabel, newGoldLabel};

    public InnNewStatsPanel() {
        super(new GridLayout(4, 2, 0, 0));

        this.setPreferredSize(new Dimension(InnFrame.PANEL_WIDTH, InnFrame.PANEL_HEIGHT / 2));
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

    public void setNewHPLabel(int hp) {
        setLabelColor(newHPLabel, hp);
        newHPLabel.setText("HP: " + (PlayerPanel.getPlayer().getHP() + hp));
    }

    public void setNewMPLabel(int mp) {
        setLabelColor(newMPLabel, mp);
        newMPLabel.setText("MP: " + (PlayerPanel.getPlayer().getMP() + mp));
    }

    public void setNewGoldLabel(int gold) {
        setLabelColor(newGoldLabel, gold);
        newGoldLabel.setText("Gold: " + (PlayerPanel.getPlayer().getGold() + gold));
    }
}
