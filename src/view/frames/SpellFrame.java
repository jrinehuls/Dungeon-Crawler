package view.frames;

import model.entity.player.Player;
import model.spell.AttackSpell;
import model.spell.HealSpell;
import model.spell.Spell;
import model.spell.StealSpell;
import view.panels.game.MonsterPanel;
import view.panels.game.PlayerPanel;
import view.panels.item.ItemButtonPanel;
import view.panels.item.ItemListPanel;
import view.panels.item.ItemRadioButtonPanel;
import view.panels.spell.SpellButtonPanel;
import view.panels.spell.SpellListPanel;
import view.panels.spell.SpellRadioButtonPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

// public class SpellFrame extends JFrame implements ActionListener {
public class SpellFrame extends JFrame {

    public static final int SCREEN_WIDTH = 500;
    JPanel spellPanel;

    //------------- TOP ------------------------------------------
    JPanel selectionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    public static final int SELECTION_PANEL_HEIGHT = 200;
    public SpellRadioButtonPanel spellRadioButtonPanel;
    public SpellListPanel spellListPanel;

    //------------- BOTTOM ---------------------------------------
    public static final int BUTTON_PANEL_HEIGHT = 80;
    public SpellButtonPanel spellButtonPanel;


    public SpellFrame() {

        // --------------------Stuff for main panel---------------------------------------
        spellPanel = new JPanel();
        spellPanel.setLayout(new BoxLayout(spellPanel, BoxLayout.Y_AXIS));

        // --------------------Stuff for selection panel (TOP)---------------------------------------
        selectionPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, SELECTION_PANEL_HEIGHT));

        spellRadioButtonPanel = new SpellRadioButtonPanel();
        spellListPanel = new SpellListPanel();

        selectionPanel.add(spellRadioButtonPanel);
        selectionPanel.add(spellListPanel);
        spellPanel.add(selectionPanel);

        //--------------------Stuff for button panel (BOTTOM)---------------------------------------
        spellButtonPanel = new SpellButtonPanel();
        spellPanel.add(spellButtonPanel);

        //------------------------Frame stuff---------------------------------------------
        this.add(spellPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setIconImage(new ImageIcon("res/icons/Icon.png").getImage());
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        // this.setLocationRelativeTo(MainGameFrame.getFrames()[0]);
        // this.setVisible(false);
        this.setVisible(false);
    }

    /*
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

        setSpells();

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
        this.setIconImage(new ImageIcon("res/icons/Icon.png").getImage());
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        //this.setLocationRelativeTo(MainGameFrame.getFrames()[0]);
        this.setVisible(false);
    }

    private void setSpells() {
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
            } else if (!MonsterPanel.isMonster() && !(spell.getValue() instanceof HealSpell)) {
                spellButton.setEnabled(false);
            }
        }
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
    */

}
