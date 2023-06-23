package model.entity.monster;

import model.entity.Entity;
import model.entity.player.Player;
import model.item.Item;
import model.item.consumable.AttackItem;
import model.item.consumable.Consumable;
import model.item.consumable.HealingItem;
import model.item.equipment.*;
import model.spell.AttackSpell;
import model.spell.HealSpell;
import model.spell.StealSpell;
import view.panels.game.DisplayPanel;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.random.RandomGenerator;

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
        super.attack(player);
    }

    @Override
    public void castHealSpell(HealSpell healSpell) {
        int oldHP = this.HP;
        healSpell.heal(this);
        int newHP = this.HP;
        DisplayPanel.appendConsoleModel(String.format("%s casted %s and healed %d HP!",
                this.getName(), healSpell.NAME, newHP - oldHP));
    }

    @Override
    public void castAttackSpell(AttackSpell attackSpell) {
        int oldHP = player.getHP();
        attackSpell.cast(this, player);
        int newHP = player.getHP();
        DisplayPanel.appendConsoleModel(String.format("%s casted %s and dealt %d HP of damage!",
                this.getName(), attackSpell.NAME, oldHP - newHP));
    }

    @Override
    public void castStealGoldSpell(StealSpell stealSpell) {
        int oldGold = player.getGold();
        stealSpell.stealGold(this);
        int newGold = player.getGold();
        DisplayPanel.appendConsoleModel(String.format("%s casted %s and stole %d gold!",
                this.getName(), stealSpell.NAME, oldGold - newGold));
    }

    @Override
    public void castStealItemSpell(StealSpell stealSpell) {

    }

    @Override
    public void useHealingItem(HealingItem healingItem) {

    }

    @Override
    public void useAttackItem(AttackItem attackItem) {

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
        if (this.items.size() > 0 ) {
            Item droppedItem = removeItem(items.get(random.nextInt(items.size())));
            DisplayPanel.appendConsoleModel(this.name + " Dropped " + droppedItem);
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
    public String toString() {
        return this.name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public Item removeItem(Item item) {
        Item returnableItem = items.get(getItems().indexOf(item));
        this.items.remove(item);
        return returnableItem;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getIcon() {
        return icon;
    }

}
