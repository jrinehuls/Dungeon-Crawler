package model.spell;

import model.entity.Entity;
import model.entity.monster.Monster;
import model.entity.player.Player;
import model.item.Item;
import model.item.consumable.Consumable;
import model.item.equipment.Weapon;
import view.panels.game.DisplayPanel;
import view.panels.game.MonsterPanel;
import view.panels.game.PlayerPanel;

public class StealItemSpell extends StealSpell{

    public StealItemSpell(String name, int mp) {
        super(name, mp);
    }


    public Item stealItem(Entity caster) {
        if (caster.getMP() >= MP) {
            caster.setMP(caster.getMP() - MP);
            if (caster instanceof Monster monster) {
                return stealPlayerItem(monster);
            } else if (caster instanceof Player player) {
                return stealMonsterItem(player);
            }
        }
        return null;
    }

    // Check if player has items, stealing chance is based on speed. Always steal if monster at least as fast as player
    private Item stealPlayerItem(Monster monster) {
        Player player = PlayerPanel.getPlayer();
        double stealChance = Math.pow((double) monster.getSpeed() / (double) player.getSpeed(), 2);
        int numItems = player.getConsumableItems().size();
        if (stealChance < Math.random()) {
            DisplayPanel.appendConsoleModel(monster.getName() + " failed to steal an item.");
            return null;
        }
        if (numItems > 0) {
            int index = (int) (Math.random() * numItems);
            Consumable item = player.getConsumableItems().get(index);
            monster.addItem(item);
            player.disposeConsumableItem(item);
            return item;
        } else {
            DisplayPanel.appendConsoleModel(monster.getName() + " failed to steal an item.");
            return null;
        }
    }

    // Check if monster has items, stealing chance is based on speed. Always steal if player at least as fast as monster
    private Item stealMonsterItem(Player player) {
        Monster monster = MonsterPanel.getMonster();
        double stealChance = Math.pow((double) player.getSpeed() / (double) monster.getSpeed(), 2);
        int numItems = monster.getItems().size();
        if (stealChance < Math.random()) {
            DisplayPanel.appendConsoleModel(monster.getName() + " failed to steal an item.");
            return null;
        }
        if (numItems > 0) {
            int index = (int) (Math.random() * numItems);
            Item item = monster.getItems().get(index);
            if (item instanceof Consumable consumable) {
                player.addConsumableItem(consumable);
            } else if (item instanceof Weapon weapon) {
                player.addWeapon(weapon);
            }
            return monster.removeItem(item);
        } else {
            DisplayPanel.appendConsoleModel(monster.getName() + " doesn't have any items.");
            return null;
        }
    }

}
