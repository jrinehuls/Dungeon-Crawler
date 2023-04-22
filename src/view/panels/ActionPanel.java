package view.panels;

import controller.ActionButtonController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ActionPanel extends JPanel {

    public static final int SCREEN_WIDTH = MapPanel.SCREEN_EDGE_LENGTH;
    public static final int SCREEN_HEIGHT = MapPanel.SCREEN_EDGE_LENGTH;

    public static JButton attackButton = new JButton("Attack");;
    public static JButton spellButton = new JButton("Spell");
    public static JButton itemButton = new JButton("Item");
    public static JButton defendButton = new JButton("Defend");
    public static JButton runButton = new JButton("Run");

    static JButton[] buttons = {attackButton, spellButton, itemButton, defendButton, runButton};

    ActionListener abc = new ActionButtonController(this);

    public ActionPanel() {
        final int BUTTON_WIDTH = 120;
        final int BUTTON_HEIGHT = 30;
        final int BUTTON_X = (SCREEN_WIDTH - BUTTON_WIDTH) / 2;

        this.setLayout(null);
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        attackButton.setBounds(BUTTON_X, 30, BUTTON_WIDTH, BUTTON_HEIGHT);
        spellButton.setBounds(BUTTON_X, 70, BUTTON_WIDTH, BUTTON_HEIGHT);
        itemButton.setBounds(BUTTON_X, 110, BUTTON_WIDTH, BUTTON_HEIGHT);
        defendButton.setBounds(BUTTON_X, 150, BUTTON_WIDTH, BUTTON_HEIGHT);
        runButton.setBounds(BUTTON_X, 190, BUTTON_WIDTH, BUTTON_HEIGHT);

        for (JButton button : buttons) {
            if (GamePanel.getMonster() == null) {
                button.setEnabled(false);
            }
            button.addActionListener(abc);
            button.setFocusable(false);
            this.add(button);
        }


    }


    public static void update() {
        for (JButton button : buttons) {
            if (GamePanel.getMonster() == null) {
                button.setEnabled(false);
            } else {
                button.setEnabled(true);
            }
        }
    }

}
