package controller;

import model.monster.Monster;
import model.player.Player;
import model.spell.HealingSpell;
import view.frames.SpellFrame;
import view.panels.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButtonController implements ActionListener {

    ActionPanel ap;
    Monster monster;
    Player player;
    public static SpellFrame spellFrame = new SpellFrame();

    public ActionButtonController(ActionPanel ap) {
        this.ap = ap;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        player = PlayerPanel.getPlayer();
        monster = GamePanel.getMonster();
        if (e.getSource() == ap.attackButton) {
            System.out.println("Attack: " + PlayerPanel.getPlayer().getAttack());
            monster.setHP(monster.getHP() - (player.getAttack()/ monster.getDefense() + 10));
            player.setProgress(0);
        }
        if (e.getSource() == ap.spellButton) {
            spellFrame.setVisible(true);
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
