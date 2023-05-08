package model.spell;

import model.entity.Entity;
import model.entity.monster.Monster;
import model.entity.player.Player;
import model.item.Item;
import model.item.consumable.Consumable;
import model.item.equipment.Equipment;
import view.panels.MapPanel;
import view.panels.MonsterPanel;
import view.panels.PlayerPanel;

public class StealSpell extends Spell {

    private int gold;

    public StealSpell(String name, int mp) {
        super(name, mp);
    }

    // TODO: Make overloaded constructor for items
    public StealSpell(String name, int mp, int gold) {
        super(name, mp);
        this.gold = gold;
    }

    public void stealGold(Entity caster) {
        if (caster.getMP() >= MP) {
            caster.setMP(caster.getMP() - MP);
            if (caster instanceof Monster monster) {
                Player player = PlayerPanel.getPlayer();
                if (player.getGold() > gold) {
                    player.setGold(monster.getPlayer().getGold() - gold);
                } else {
                    player.setGold(0);
                }
            } else if (caster instanceof Player player) {
                player.setGold(player.getGold() + gold);
            }
        }
    }

    public void stealItem(Entity caster) {
        if (caster.getMP() >= MP) {
            caster.setMP(caster.getMP() - MP);
            if (caster instanceof Monster monster) {
                stealPlayerItem(monster);
            } else if (caster instanceof Player player) {
                stealMonsterItem(player);
            }
        }
    }

    // Check if player has items, then steal if so
    private void stealPlayerItem(Monster monster) {
        // TODO: Make stealing based on speed stat, not 100% of time.
        // TODO: Make it so monsters can't steal equipped items.
        Player player = PlayerPanel.getPlayer();
        int numItems = player.getConsumableItems().size();
        if (numItems > 0) {
            int index = (int) (Math.random() * numItems);
            Consumable item = player.getConsumableItems().get(index);
            monster.addItem(item);
            player.removeConsumableItem(item);
        } else {
            monster.setProgress(100);
        }
    }

    // Check if monster has items, then steal if so based on type of item
    private void stealMonsterItem(Player player) {
        // TODO: Make stealing based on speed stat, not 100% of time.
        Monster monster = MonsterPanel.getMonster();
        int numItems = monster.getItems().size();
        if (numItems > 0) {
            int index = (int) (Math.random() * numItems);
            Item item = monster.getItems().get(index);
            if (item instanceof Consumable consumable) {
                player.addConsumableItem(consumable);
            } else if (item instanceof Equipment equipment) {
                player.addEquipment(equipment);
            }
            monster.removeItem(item);
        } else {
            player.setProgress(100);
        }
    }




}
