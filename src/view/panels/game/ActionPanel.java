package view.panels.game;

import controller.game.ActionButtonController;

import javax.swing.*;
import java.awt.*;

public class ActionPanel extends JPanel {

    public static final int SCREEN_WIDTH = MapPanel.SCREEN_WIDTH;
    public static final int SCREEN_HEIGHT = MapPanel.SCREEN_HEIGHT;

    public static JButton attackButton = new JButton("Attack");;
    public static JButton spellButton = new JButton("Spell");
    public static JButton itemButton = new JButton("Item");
    public static JButton defendButton = new JButton("Defend");
    public static JButton runButton = new JButton("Run");
    public static JButton equipButton = new JButton("Equipment");

    static JButton[] battleButtons = {attackButton, defendButton, runButton};
    static JButton[] anyTimeButtons = {spellButton, itemButton};

    ActionButtonController abc = new ActionButtonController();

    public ActionPanel() {
        final int BUTTON_WIDTH = 120;
        final int BUTTON_HEIGHT = 30;
        final int HGAP = (SCREEN_WIDTH - BUTTON_WIDTH) / 2;
        final int VGAP = 10;

        this.setLayout(new FlowLayout(FlowLayout.CENTER, HGAP, VGAP));
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // ------------------------------- Battle only buttons --------------------------
        for (JButton button: battleButtons) {
            if (!MonsterPanel.isMonster()) {
                button.setEnabled(false);
            }
            button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
            button.addActionListener(abc);
            button.setFocusable(false);
            this.add(button);
        }
        // -------------------------------- Any time buttons ----------------------------
        for (JButton button: anyTimeButtons) {
            button.setEnabled(true);
            button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
            button.addActionListener(abc);
            button.setFocusable(false);
            this.add(button);
        }
        // ---------------------------- Special for equip button ------------------------
        if (!MonsterPanel.isMonster()) {
            equipButton.setEnabled(true);
        }
        equipButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        equipButton.addActionListener(abc);
        equipButton.setFocusable(false);
        this.add(equipButton);
    }

    public static void update() {
        boolean isMonster = MonsterPanel.isMonster();
        boolean progressFull = PlayerPanel.getPlayer().getProgress() >= 100;
        for (JButton button: battleButtons) {
            button.setEnabled(isMonster && progressFull);
        }
        for (JButton button: anyTimeButtons) {
            button.setEnabled(!isMonster || progressFull);
        }
        equipButton.setEnabled(!isMonster);
    }

}
