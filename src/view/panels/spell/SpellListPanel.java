package view.panels.spell;

import controller.SpellController;
import model.spell.AttackSpell;
import model.spell.HealSpell;
import model.spell.Spell;
import view.frames.SpellFrame;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class SpellListPanel extends JPanel {


    private DefaultListModel<Spell> healingSpellModel = new DefaultListModel<>();
    private DefaultListModel<Spell> attackSpellModel = new DefaultListModel<>();
    public JList<Spell> spellJList;

    private final int PANEL_WIDTH = SpellFrame.SCREEN_WIDTH/2;

    public JScrollPane spellJSP;

    SpellController sc;

    public SpellListPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 0, 35));

        sc = new SpellController();

        this.setPreferredSize(new Dimension(PANEL_WIDTH, SpellFrame.SELECTION_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.YELLOW);

        loadHealingSpellModel(); // Since defaults to healing items button, have to populate before adding.

        spellJList = new JList<>(healingSpellModel); // itemJList.setModel(); to change DefaultListModel.
        spellJList.setVisibleRowCount(5);
        spellJList.setFixedCellWidth(PANEL_WIDTH - 50);
        spellJList.setFixedCellHeight(25);
        spellJList.setFocusable(false);
        spellJList.addListSelectionListener(sc);

        spellJSP = new JScrollPane(spellJList);
        this.add(spellJSP);

    }

    // --------------------------------------------- Getters ---------------------------------------------
    public DefaultListModel<Spell> getHealingSpellModel() {
        return healingSpellModel;
    }
    public DefaultListModel<Spell> getAttackSpellModel() {
        return attackSpellModel;
    }

    // --------------------------------------------- Setters ---------------------------------------------
    public void loadHealingSpellModel() {
        healingSpellModel.clear();
        // Add healing spells from player's spells hashmap to the list model
        for (Map.Entry<String, Spell> spell: PlayerPanel.getPlayer().spells.entrySet()) {
            if (spell.getValue() instanceof HealSpell healSpell) {
                if (healSpell.MP <= PlayerPanel.getPlayer().getMP()) {
                    healingSpellModel.addElement(healSpell);
                }
            }
        }
    }

    public void loadAttackSpellModel() {
        attackSpellModel.clear();
        // Add healing spells from player's spells hashmap to the list model
        for (Map.Entry<String, Spell> spell: PlayerPanel.getPlayer().spells.entrySet()) {
            if (spell.getValue() instanceof AttackSpell attackSpell) {
                if (attackSpell.MP <= PlayerPanel.getPlayer().getMP()) {
                    attackSpellModel.addElement(attackSpell);
                }
            }
        }
    }


}
