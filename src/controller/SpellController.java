package controller;

import controller.game.ActionButtonController;
import model.entity.player.Player;
import model.spell.AttackSpell;
import model.spell.HealSpell;
import model.spell.Spell;
import view.frames.SpellFrame;
import view.panels.game.MonsterPanel;
import view.panels.game.PlayerPanel;
import view.panels.spell.SpellButtonPanel;
import view.panels.spell.SpellListPanel;
import view.panels.spell.SpellRadioButtonPanel;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpellController implements ActionListener, ListSelectionListener {

    Player player;
    SpellFrame spellFrame;
    SpellRadioButtonPanel spellRadioButtonPanel;
    SpellListPanel spellListPanel;
    SpellButtonPanel spellButtonPanel;
    static Spell selectedSpell = null;

    public SpellController() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player = PlayerPanel.getPlayer();
        spellFrame = ActionButtonController.spellFrame;
        spellRadioButtonPanel = spellFrame.spellRadioButtonPanel;
        spellListPanel = spellFrame.spellListPanel;
        spellButtonPanel = spellFrame.spellButtonPanel;
        // ------------------------- JButtons ------------------------------------
        if (e.getSource() == spellButtonPanel.getDoneButton()) {
            spellFrame.dispose();
        } if (e.getSource() == spellButtonPanel.getCastButton() && selectedSpell != null) {
            useSpell();
            selectedSpell = null;
            if (MonsterPanel.isMonster()) {
                player.setProgress(0);
                spellFrame.dispose();
            }
        }
        // --------------------- Radio Buttons ------------------------------------
        if (e.getSource() == spellRadioButtonPanel.healingSpellButton) {
            spellListPanel.loadHealingSpellModel();
            spellListPanel.spellJList.setModel(spellListPanel.getHealingSpellModel());
        } if (e.getSource() == spellRadioButtonPanel.attackSpellButton) {
            spellListPanel.loadAttackSpellModel();
            spellListPanel.spellJList.setModel(spellListPanel.getAttackSpellModel());
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        spellFrame = ActionButtonController.spellFrame;
        spellRadioButtonPanel = spellFrame.spellRadioButtonPanel;
        spellListPanel = spellFrame.spellListPanel;

        if (e.getValueIsAdjusting()) {
            selectedSpell = spellListPanel.spellJList.getSelectedValue();
        }
    }

    private void useSpell() {
        if (selectedSpell instanceof AttackSpell) {
            player.castAttackSpell((AttackSpell) selectedSpell);
            spellListPanel.loadAttackSpellModel();
            spellListPanel.spellJList.setModel(spellListPanel.getAttackSpellModel());
        } else if (selectedSpell instanceof HealSpell) {
            player.castHealSpell((HealSpell) selectedSpell);
            spellListPanel.loadHealingSpellModel();
            spellListPanel.spellJList.setModel(spellListPanel.getHealingSpellModel());
        }
    }









}
