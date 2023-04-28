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

    //ActionPanel ap;
    Monster monster;
    Player player;
    public static SpellFrame spellFrame;

    public ActionButtonController() {
        //this.ap = ap;
        spellFrame = new SpellFrame();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        spellFrame = new SpellFrame();
        player = PlayerPanel.getPlayer();
        monster = GamePanel.getMonster();
        if (e.getSource() == ActionPanel.attackButton) {
            System.out.println("Attack: " + PlayerPanel.getPlayer().getAttack());
            monster.setHP(monster.getHP() - (player.getAttack()/ monster.getDefense() + 10));
            player.setProgress(0);
        }
        if (e.getSource() == ActionPanel.spellButton) {
            spellFrame.setVisible(true);


        }
        if (e.getSource() == ActionPanel.itemButton) {
            System.out.println("Item: " + "PlayerPanel.getPlayer().getItem()");
            player.setProgress(0);
        }
        if (e.getSource() == ActionPanel.defendButton) {
            System.out.println("Defend: " + PlayerPanel.getPlayer().getDefense());
            player.setProgress(0);
        }
        if (e.getSource() == ActionPanel.runButton) {
            System.out.println("Run: " + PlayerPanel.getPlayer().getSpeed());
            player.setProgress(0);
        }
    }
}
