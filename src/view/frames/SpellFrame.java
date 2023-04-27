package view.frames;

import controller.ActionButtonController;
import model.player.Player;
import model.spell.Spell;
import view.panels.PlayerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class SpellFrame extends JFrame implements ActionListener {

    Player player = PlayerPanel.getPlayer();

    ButtonGroup spellButtonGroup = new ButtonGroup();
    JButton submit = new JButton("Submit");

    JPanel radioPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    public SpellFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        radioPanel.setBounds(0, 0, 300, 300);
        //radioPanel.setLayout(new GridLayout(0, 3));
        radioPanel.setLayout(null);
        radioPanel.setBackground(Color.BLUE);
        radioPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE));


        for (Map.Entry<String, Spell> spell: player.spells.entrySet()) {
            JRadioButton spellButton = new JRadioButton(spell.getKey());
            spellButtonGroup.add(spellButton);
            radioPanel.add(spellButton);
        }

        this.add(radioPanel);

        buttonPanel.setBounds(0,300,300,100);
        buttonPanel.setLayout(new FlowLayout());

        submit.addActionListener(this);
        submit.setFocusable(false);
        buttonPanel.add(submit);

        this.add(buttonPanel);


        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ActionButtonController.spellFrame.dispose();
        spellButtonGroup.clearSelection();
        /*
        if (spellList.getSelectedValue().equals("First Aid")) {
            player.castSpell(player.spells.get("First Aid"));
            ActionButtonController.spellFrame.dispose();
        }
        */
    }
}
