package view.frames;

import model.player.Player;
import model.spell.AttackSpell;
import model.spell.HealingSpell;
import model.spell.Spell;
import view.panels.PlayerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class SpellFrame extends JFrame implements ActionListener {

    Player player;

    JPanel radioPanel = new JPanel();
    public static final int RADIO_PANEL_WIDTH = 300;
    public static final int RADIO_PANEL_HEIGHT = 300;

    JPanel buttonPanel = new JPanel();
    public static final int Button_PANEL_WIDTH = RADIO_PANEL_WIDTH;
    public static final int BUTTON_PANEL_HEIGHT = 100;

    ButtonGroup spellButtonGroup = new ButtonGroup();

    JButton submitButton = new JButton("Submit");
    JButton cancelButton = new JButton("Cancel");

    public SpellFrame() {
        player = PlayerPanel.getPlayer();

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setPreferredSize(new Dimension(RADIO_PANEL_WIDTH, RADIO_PANEL_HEIGHT + BUTTON_PANEL_HEIGHT));

        // --------------Stuff for radio buttons------------------------------------
        radioPanel.setPreferredSize(new Dimension(RADIO_PANEL_WIDTH, RADIO_PANEL_HEIGHT));
        radioPanel.setLayout(new GridLayout(0, 3));
        radioPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        for (Map.Entry<String, Spell> spell: player.spells.entrySet()) {
            int spellMP = spell.getValue().MP;
            JRadioButton spellButton = new JRadioButton(spell.getKey() + ": " + String.valueOf(spellMP));
            // I don't exactly know what this does, but it's used to identify which radio button is selected.
            spellButton.setActionCommand(spellButton.getText().split(":")[0]);
            spellButtonGroup.add(spellButton);
            radioPanel.add(spellButton);
            if (spellMP > player.getMP()) {
                spellButton.setEnabled(false);
            }
        }

        this.add(radioPanel);

        // -------------------------Stuff for buttons-------------------------------------
        buttonPanel.setPreferredSize(new Dimension(Button_PANEL_WIDTH, BUTTON_PANEL_HEIGHT));
        buttonPanel.setLayout(new FlowLayout());

        submitButton.addActionListener(this);
        submitButton.setFocusable(false);
        buttonPanel.add(submitButton);

        cancelButton.addActionListener(this);
        cancelButton.setFocusable(false);
        buttonPanel.add(cancelButton);

        this.add(buttonPanel);

        //------------------------Frame stuff---------------------------------------------
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        //this.setLocationRelativeTo(MainGameFrame.getFrames()[0]);
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            this.dispose();
            spellButtonGroup.clearSelection();
        } else if (e.getSource() == submitButton && spellButtonGroup.getSelection() != null) {
            String key = spellButtonGroup.getSelection().getActionCommand();
            if (player.spells.get(key) instanceof HealingSpell) {
                player.castHealingSpell((HealingSpell) player.spells.get(key));
            } else if (player.spells.get(key) instanceof AttackSpell) {
                player.castAttackSpell((AttackSpell) player.spells.get(key));
            }
            player.setProgress(0);
            this.dispose();
            spellButtonGroup.clearSelection();
        }

    }
}
