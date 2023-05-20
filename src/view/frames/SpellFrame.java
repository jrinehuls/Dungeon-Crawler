package view.frames;

import model.entity.player.Player;
import model.spell.AttackSpell;
import model.spell.HealSpell;
import model.spell.Spell;
import model.spell.StealSpell;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class SpellFrame extends JFrame implements ActionListener {

    Player player;

    JPanel radioPanel = new JPanel();
    private static final int RADIO_PANEL_WIDTH = 300;
    private static final int RADIO_PANEL_HEIGHT = 300;
    private static final int RADIO_PANEL_COLS = 3;

    JPanel buttonPanel = new JPanel();
    private static final int BUTTON_PANEL_WIDTH = RADIO_PANEL_WIDTH;
    private static final int BUTTON_PANEL_HEIGHT = 50;

    ButtonGroup spellButtonGroup = new ButtonGroup();

    JButton submitButton = new JButton("Submit");
    JButton cancelButton = new JButton("Cancel");

    JPanel spellPanel;

    public SpellFrame() {

        player = PlayerPanel.getPlayer();

        //--------------------Stuff for main panel---------------------------------------
        spellPanel = new JPanel();
        spellPanel.setLayout(new BoxLayout(spellPanel, BoxLayout.Y_AXIS));
        spellPanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

        // --------------------Stuff for radio buttons------------------------------------
        radioPanel.setPreferredSize(new Dimension(RADIO_PANEL_WIDTH, RADIO_PANEL_HEIGHT));
        radioPanel.setLayout(new GridLayout(player.spells.size()/RADIO_PANEL_COLS , RADIO_PANEL_COLS, 0, 0));
        radioPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        for (Map.Entry<String, Spell> spell: player.spells.entrySet()) {
            int spellMP = spell.getValue().MP;
            JRadioButton spellButton = new JRadioButton(spell.getKey() + ": " + String.valueOf(spellMP));
            spellButton.setFocusable(false);
            // I don't exactly know what this does, but it's used to identify which radio button is selected.
            spellButton.setActionCommand(spellButton.getText().split(":")[0]);
            spellButtonGroup.add(spellButton);
            radioPanel.add(spellButton);
            if (spellMP > player.getMP()) {
                spellButton.setEnabled(false);
            }
        }

        spellPanel.add(radioPanel);

        // -------------------------Stuff for buttons-------------------------------------
        buttonPanel.setPreferredSize(new Dimension(BUTTON_PANEL_WIDTH, BUTTON_PANEL_HEIGHT));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));

        submitButton.addActionListener(this);
        submitButton.setFocusable(false);
        buttonPanel.add(submitButton);

        cancelButton.addActionListener(this);
        cancelButton.setFocusable(false);
        buttonPanel.add(cancelButton);

        spellPanel.add(buttonPanel);

        //------------------------Frame stuff---------------------------------------------
        this.add(spellPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
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
            if (player.spells.get(key) instanceof HealSpell) {
                player.castHealSpell((HealSpell) player.spells.get(key));
            } else if (player.spells.get(key) instanceof AttackSpell) {
                player.castAttackSpell((AttackSpell) player.spells.get(key));
            } else if (player.spells.get(key) instanceof StealSpell) {
                player.castStealGoldSpell((StealSpell) player.spells.get(key));
            }
            player.setProgress(0);
            this.dispose();
            spellButtonGroup.clearSelection();
        }

    }
}
