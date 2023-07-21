package view.panels.spell;

import controller.SpellController;
import view.frames.SpellFrame;
import view.panels.game.MonsterPanel;

import javax.swing.*;
import java.awt.*;

public class SpellRadioButtonPanel extends JPanel {

    public ButtonGroup spellButtonGroup = new ButtonGroup();

    public final JRadioButton healingSpellButton = new JRadioButton("Healing Spells");
    public final JRadioButton attackSpellButton = new JRadioButton("Attack Spells");
    public final JRadioButton stealSpellButton = new JRadioButton("Steal Spells");

    private static final int JBUTTON_LEFT_INSET = 50;

    JRadioButton[] spellButtons = {healingSpellButton, attackSpellButton, stealSpellButton};

    SpellController sc = new SpellController();

    public SpellRadioButtonPanel() {
        super(new GridLayout(6, 1, 0, 0));

        this.setPreferredSize(new Dimension(SpellFrame.SCREEN_WIDTH /2, SpellFrame.SELECTION_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.RED);

        // Add components to panel. Add margins and stuffs.
        for (JRadioButton button: spellButtons) {
            button.setMargin(new Insets(0, JBUTTON_LEFT_INSET,0,0));
            button.setOpaque(false);
            button.setFocusable(false);
            spellButtonGroup.add(button);
            button.addActionListener(sc);
            this.add(button);
        }

        if (MonsterPanel.isMonster()) {
            attackSpellButton.setEnabled(true);
            stealSpellButton.setEnabled(true);
        } else {
            attackSpellButton.setEnabled(false);
            stealSpellButton.setEnabled(false);
        }
        // Default to healing radio button being selected
        healingSpellButton.setSelected(true);

    }

}
