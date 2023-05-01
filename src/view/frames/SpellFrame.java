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

    JButton submitButton = new JButton("Submit");
    JButton cancelButton = new JButton("Cancel");

    ButtonGroup spellButtonGroup = new ButtonGroup();
    JPanel radioPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    public SpellFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(false);

        player = PlayerPanel.getPlayer();

        radioPanel.setBounds(0, 0, 300, 300);
        radioPanel.setLayout(new GridLayout(0, 3));
        //radioPanel.setLayout(null);
        radioPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        for (Map.Entry<String, Spell> spell: player.spells.entrySet()) {
            int spellMP = spell.getValue().MP;
            JRadioButton spellButton = new JRadioButton(spell.getKey() + ": " + String.valueOf(spellMP));
            if (spellMP > player.getMP()) {
                spellButton.setEnabled(false);
            }
            // I don't exactly know what this does, but it's used to identify which radio button is selected.
            spellButton.setActionCommand(spellButton.getText().split(":")[0]);
            spellButtonGroup.add(spellButton);
            radioPanel.add(spellButton);
        }

        this.add(radioPanel);

        buttonPanel.setBounds(0,300,300,100);
        buttonPanel.setLayout(new FlowLayout());

        submitButton.addActionListener(this);
        submitButton.setFocusable(false);
        buttonPanel.add(submitButton);

        cancelButton.addActionListener(this);
        cancelButton.setFocusable(false);
        buttonPanel.add(cancelButton);

        this.add(buttonPanel);

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
            this.dispose();
            player.setProgress(0);
            spellButtonGroup.clearSelection();
        }
        /*
        if (spellList.getSelectedValue().equals("First Aid")) {
            player.castSpell(player.spells.get("First Aid"));
            ActionButtonController.spellFrame.dispose();
        }
        */
    }
}
