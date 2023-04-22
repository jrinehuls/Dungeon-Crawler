package view.panels;

import javax.swing.*;
import java.awt.*;

public class ActionPanel extends JPanel {

    public static final int SCREEN_WIDTH = MapPanel.SCREEN_EDGE_LENGTH;
    public static final int SCREEN_HEIGHT = MapPanel.SCREEN_EDGE_LENGTH;

    private JButton attackButton;
    private JButton spellButton;
    private JButton itemButton;
    private JButton defendButton;
    private JButton runButton;

    public ActionPanel() {
        final int BUTTON_WIDTH = 120;
        final int BUTTON_HEIGHT = 30;
        final int BUTTON_X = (SCREEN_WIDTH - BUTTON_WIDTH) / 2;

        this.setLayout(null);
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        attackButton = new JButton("Attack");
        attackButton.setBounds(BUTTON_X, 30, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(attackButton);

        spellButton = new JButton("Spell");
        spellButton.setBounds(BUTTON_X, 70, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(spellButton);

        itemButton = new JButton("Item");
        itemButton.setBounds(BUTTON_X, 110, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(itemButton);

        defendButton = new JButton("Defend");
        defendButton.setBounds(BUTTON_X, 150, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(defendButton);

        runButton = new JButton("Run");
        runButton.setBounds(BUTTON_X, 190, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(runButton);

        runButton = new JButton("Run");
        runButton.setBounds(BUTTON_X, 300, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(runButton);

    }





}
