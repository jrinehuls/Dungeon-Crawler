package controller;

import model.monster.Monster;
import model.player.Player;
import view.panels.ActionPanel;
import view.panels.GamePanel;
import view.panels.MonsterPanel;
import view.panels.PlayerPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButtonController implements ActionListener {

    ActionPanel ap;
    Monster monster;
    Player player = PlayerPanel.getPlayer();

    public ActionButtonController(ActionPanel ap) {
        this.ap = ap;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        monster = GamePanel.getMonster();
        if (e.getSource() == ap.attackButton) {
            System.out.println("Attack: " + PlayerPanel.getPlayer().getAttack());
            monster.setHP(monster.getHP() - (player.getAttack()/ monster.getDefense() + 10));
            player.setProgress(0);
        }
        if (e.getSource() == ap.spellButton) {
            System.out.println("Spell: " + "PlayerPanel.getPlayer().getSpell()");
            player.setProgress(0);
        }
        if (e.getSource() == ap.itemButton) {
            System.out.println("Item: " + "PlayerPanel.getPlayer().getItem()");
            player.setProgress(0);
        }
        if (e.getSource() == ap.defendButton) {
            System.out.println("Defend: " + PlayerPanel.getPlayer().getDefense());
            player.setProgress(0);
        }
        if (e.getSource() == ap.runButton) {
            System.out.println("Run: " + PlayerPanel.getPlayer().getSpeed());
            player.setProgress(0);
        }
    }
}
