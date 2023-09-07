package model.entity.monster;

import model.entity.Entity;
import model.entity.player.Player;
import model.item.Item;
import model.item.consumable.AttackItem;
import model.item.consumable.Consumable;
import model.item.consumable.HealingItem;
import model.item.equipment.*;
import model.spell.*;
import util.SoundEffects;
import view.panels.game.DisplayPanel;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class Monster extends Entity implements MonsterActions {

    protected String name;
    protected int baseGold;
    protected int baseExp;
    protected ImageIcon icon;

    protected ArrayList<Item> items = new ArrayList<>();
    protected Random random;

    Player player;

    public Monster(String name, int HP, int MP, int attack, int defense, int magicAttack, int magicDefense, int speed, int baseGold, int baseExp, ImageIcon icon) {
        super(HP, MP, attack, defense, magicAttack, magicDefense, speed);
        this.icon = icon;
        this.name = name;
        this.baseGold = baseGold;
        this.baseExp = baseExp;
        random = new Random();
        player = PlayerPanel.getPlayer();
    }

    @Override
    public void attack(Entity player) {
        this.se.playSE(SoundEffects.MONSTER_ATTACK);
        super.attack(player);
    }

    @Override
    public void castHealSpell(HealSpell healSpell) {
        this.se.playSE(SoundEffects.HEAL_SPELL);
        int oldHP = this.HP;
        healSpell.heal(this);
        int newHP = this.HP;
        DisplayPanel.appendConsoleModel(String.format("%s casted %s and healed %d HP!",
                this.getName(), healSpell.NAME, newHP - oldHP));
    }

    @Override
    public void castAttackSpell(AttackSpell attackSpell) {
        this.se.playSE(SoundEffects.ATTACK_SPELL);
        int oldHP = player.getHP();
        attackSpell.cast(this, player);
        int newHP = player.getHP();
        DisplayPanel.appendConsoleModel(String.format("%s casted %s and dealt %d HP of damage!",
                this.getName(), attackSpell.NAME, oldHP - newHP));
    }

    @Override
    public void castStealGoldSpell(StealGoldSpell stealSpell) {
        int oldGold = player.getGold();
        stealSpell.stealGold(this);
        int newGold = player.getGold();
        if (newGold < oldGold) {
            this.se.playSE(SoundEffects.STEAL_SPELL);
            DisplayPanel.appendConsoleModel(String.format("%s casted %s and stole %d gold!",
                    this.getName(), stealSpell.NAME, oldGold - newGold));
        }
    }

    @Override
    public void castStealItemSpell(StealItemSpell stealSpell) {
        Item item = stealSpell.stealItem(this);
        if (item != null){
            this.se.playSE(SoundEffects.STEAL_SPELL);
            DisplayPanel.appendConsoleModel(String.format("%s casted %s and stole %s!",
                    this.getName(), stealSpell.NAME, item.getName()));
        }
    }

    @Override
    public void useHealingItem(HealingItem healingItem) {
        this.se.playSE(SoundEffects.HEAL_ITEM);
        int oldHP = this.getHP();
        if (this.maxHP - this.HP > healingItem.getHP()) {
            this.setHP(this.getHP() + healingItem.getHP());
        } else {
            this.setHP(this.getMaxHP());
        }
        int newHP = this.getHP();
        DisplayPanel.appendConsoleModel(String.format("%s used %s and healed %d HP!",
                this.getName(), healingItem.getName(), newHP - oldHP));
        this.items.remove(healingItem);
    }

    @Override
    public void useAttackItem(AttackItem attackItem) {
        this.se.playSE(SoundEffects.ATTACK_ITEM);
        int oldHP = PlayerPanel.getPlayer().getHP();
        if (PlayerPanel.getPlayer().getHP() > attackItem.getDamage()) {
            PlayerPanel.getPlayer().setHP(PlayerPanel.getPlayer().getHP() - attackItem.getDamage());
        } else {
            PlayerPanel.getPlayer().setHP(0);
        }
        int newHP = PlayerPanel.getPlayer().getHP();
        DisplayPanel.appendConsoleModel(String.format("%s used %s and dealt %d HP of damage!",
                this.getName(), attackItem.getName(), oldHP - newHP));
        this.items.remove(attackItem);
    }

    @Override
    public void dropGold() {
        if (HP <= 0) {
            int gold = (int) (this.baseGold * random.nextDouble(0.5, 1.5));
            player.setGold(player.getGold() + gold);
            DisplayPanel.appendConsoleModel(String.format("You got %d gold!", gold));
        }
    }

    @Override
    public void giveExp() {
        int exp = (int) (this.baseExp * random.nextDouble(0.8, 1.2));
        player.setExp(player.getExp() + exp);
        DisplayPanel.appendConsoleModel(String.format("You got %d exp!", exp));
    }

    @Override
    public void dropItem() {
        if (this.items.size() > 0 && Math.random() < 0.75) {
            Item droppedItem = removeItem(items.get(random.nextInt(items.size())));
            DisplayPanel.appendConsoleModel(this.name + " dropped " + droppedItem.getName() + "!");
            if (droppedItem instanceof Consumable consumableItem) {
                player.addConsumableItem(consumableItem);
            } else if (droppedItem instanceof Weapon weapon) {
                player.addWeapon(weapon);
            } else if (droppedItem instanceof Head headGear) {
                player.addHeadgear(headGear);
            } else if (droppedItem instanceof Body armor) {
                player.addArmor(armor);
            } else if (droppedItem instanceof Arm arm) {
                player.addArm(arm);
            } else if (droppedItem instanceof Feet footwear) {
                player.addFootwear(footwear);
            } else if (droppedItem instanceof Accessory accessory) {
                player.addAccessory(accessory);
            }
        }
    }

    @Override
    public void die() {
        DisplayPanel.appendConsoleModel("You killed " + this + "!");
        this.se.playSE(SoundEffects.MONSTER_DIE);
        this.dropGold();
        this.giveExp();
        this.dropItem();
    }

    @Override
    public String toString() {
        return this.name;
    }

    protected void useRandomItem() {
        Item item = items.remove(0);
        if (item instanceof AttackItem attackItem) {
            this.useAttackItem(attackItem);
        } else if (item instanceof HealingItem healingItem) {
            this.useHealingItem(healingItem);
        }
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public Item removeItem(Item item) {
        Item returnableItem = items.get(this.getItems().indexOf(item));
        this.items.remove(item);
        return returnableItem;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getIcon() {
        return icon;
    }

}
