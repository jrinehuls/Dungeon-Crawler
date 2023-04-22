package controller;

import view.panels.ActionPanel;
import view.panels.GamePanel;
import view.panels.PlayerPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButtonController implements ActionListener {

    ActionPanel ap;

    public ActionButtonController(ActionPanel ap) {
        this.ap = ap;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == ap.attackButton) {
            GamePanel.getMonster().setHp(5);
            System.out.println("Attack: " + PlayerPanel.getPlayer().getAttack());
        }
        if (e.getSource() == ap.spellButton) {
            System.out.println("Spell: " + "PlayerPanel.getPlayer().getSpell()");
        }
        if (e.getSource() == ap.itemButton) {
            System.out.println("Item: " + "PlayerPanel.getPlayer().getItem()");
        }
        if (e.getSource() == ap.defendButton) {
            System.out.println("Defend: " + PlayerPanel.getPlayer().getDefense());
        }
        if (e.getSource() == ap.runButton) {
            System.out.println("Run: " + PlayerPanel.getPlayer().getSpeed());
        }

    }
}
