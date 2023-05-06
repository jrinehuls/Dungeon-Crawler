package controller;

import model.entity.monster.Monster;
import model.entity.player.Player;
import view.frames.SpellFrame;
import view.panels.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButtonController implements ActionListener {

    //ActionPanel ap;
    Monster monster;
    Player player;
    public static SpellFrame spellFrame;

    public ActionButtonController() {

        spellFrame = new SpellFrame();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //spellFrame = new SpellFrame();
        player = PlayerPanel.getPlayer();
        monster = GamePanel.getMonster();
        if (e.getSource() == ActionPanel.attackButton) {
            System.out.println("Attack: " + PlayerPanel.getPlayer().getAttack());
            player.attack();
            player.setProgress(0);
        }
        if (e.getSource() == ActionPanel.spellButton) {
            spellFrame = new SpellFrame();
            spellFrame.setVisible(true);
        }
        if (e.getSource() == ActionPanel.itemButton) {
            // System.out.println("Item: " + "PlayerPanel.getPlayer().getItem()");
            // player.setProgress(0);
        }
        if (e.getSource() == ActionPanel.defendButton) {
            //System.out.println("Defend: " + PlayerPanel.getPlayer().getDefense());
            //player.setProgress(0);
        }
        if (e.getSource() == ActionPanel.runButton) {
            // System.out.println("Run: " + PlayerPanel.getPlayer().getSpeed());
            // player.setProgress(0);
        }
        if (e.getSource() == ActionPanel.equipButton) {
            // System.out.println("Run: " + PlayerPanel.getPlayer().getSpeed());
            // player.setProgress(0);
        }
    }
}
