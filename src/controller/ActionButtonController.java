package controller;

import model.entity.monster.Monster;
import model.entity.player.Player;
import view.frames.EquipmentFrame;
import view.frames.ItemFrame;
import view.frames.SpellFrame;
import view.panels.game.ActionPanel;
import view.panels.game.MonsterPanel;
import view.panels.game.PlayerPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButtonController implements ActionListener {

    //ActionPanel ap;
    Monster monster;
    Player player;
    public static SpellFrame spellFrame = new SpellFrame(); // Needed here or NullPointer at Map Panel
    public static EquipmentFrame equipmentFrame = new EquipmentFrame(); // Needed here or NullPointer at Map Panel
    public static ItemFrame itemFrame = new ItemFrame(); // Needed here or NullPointer at Map Panel

    public ActionButtonController() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player = PlayerPanel.getPlayer();
        monster = MonsterPanel.getMonster();
        if (e.getSource() == ActionPanel.attackButton) {
            System.out.println("Attack: " + PlayerPanel.getPlayer().getAttack());
            player.attack(monster);
            player.setProgress(0);
        }
        if (e.getSource() == ActionPanel.spellButton) {
            spellFrame = new SpellFrame();
            spellFrame.setVisible(true);
        }
        if (e.getSource() == ActionPanel.itemButton) {
            itemFrame = new ItemFrame();
            itemFrame.setVisible(true);
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
            equipmentFrame = new EquipmentFrame(); // Needed here to populate Equipment Frame with updated equipment
            equipmentFrame.setVisible(true);
        }
    }
}
