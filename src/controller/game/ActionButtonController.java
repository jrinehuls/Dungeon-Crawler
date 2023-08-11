package controller.game;

import model.entity.monster.Monster;
import model.entity.player.Player;
import util.SoundEffects;
import view.frames.EquipmentFrame;
import view.frames.ItemFrame;
import view.frames.SpellFrame;
import view.panels.game.ActionPanel;
import view.panels.game.DisplayPanel;
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
            player.attack(monster);
            player.setProgress(0);
        }
        if (e.getSource() == ActionPanel.defendButton) {
            player.defend();
            player.setProgress(0);
            DisplayPanel.appendConsoleModel("Your defense and magic defense temporarily doubled.");
        }
        if (e.getSource() == ActionPanel.runButton) {
            double escapeChance = Math.pow((double) player.getSpeed() / (double) monster.getSpeed(), 2);
            if (escapeChance > Math.random()) {
                MonsterPanel.clearMonster();
                SoundEffects.endBattleMusic();
                player.setProgress(0);
                DisplayPanel.appendConsoleModel("You got away safely.");
            } else {
                player.setProgress(0);
                DisplayPanel.appendConsoleModel("You were too slow.");
            }
        }
        if (e.getSource() == ActionPanel.spellButton && !isWindowVisible()) {
            spellFrame = new SpellFrame(); // Needed here to populate Spell Frame with updated spells
            spellFrame.setVisible(true);
        }
        if (e.getSource() == ActionPanel.itemButton && !isWindowVisible()) {
            itemFrame = new ItemFrame(); // Needed here to populate Item Frame with updated items
            itemFrame.setVisible(true);
        }
        if (e.getSource() == ActionPanel.equipButton && !isWindowVisible()) {
            equipmentFrame = new EquipmentFrame(); // Needed here to populate Equipment Frame with updated equipment
            equipmentFrame.setVisible(true);
        }
    }

    private boolean isWindowVisible() {
        return (ActionButtonController.spellFrame.isVisible() || ActionButtonController.itemFrame.isVisible()
                || ActionButtonController.equipmentFrame.isVisible());
    }
}
