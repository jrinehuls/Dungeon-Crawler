package view.panels.spell;

import controller.SpellController;
import view.frames.SpellFrame;

import javax.swing.*;
import java.awt.*;

public class SpellButtonPanel extends JPanel {

    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 50;

    private final JButton doneButton = new JButton("Done");
    private final JButton castButton = new JButton("Cast Spell");

    SpellController sc;

    public SpellButtonPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 50, 15));

        JButton[] buttons = {doneButton, castButton};

        sc = new SpellController();

        for (JButton button: buttons) {
            button.addActionListener(sc);
            button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
            button.setFocusable(false);
            this.add(button);
        }

        this.setPreferredSize(new Dimension(SpellFrame.SCREEN_WIDTH, SpellFrame.BUTTON_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.CYAN);
    }

    public JButton getDoneButton() {
        return doneButton;
    }

    public JButton getCastButton() {
        return castButton;
    }

}
