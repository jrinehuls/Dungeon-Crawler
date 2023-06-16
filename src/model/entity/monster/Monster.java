package model.entity.monster;

import model.entity.Entity;
import model.entity.player.Player;
import model.item.Item;
import model.item.consumable.AttackItem;
import model.item.consumable.HealingItem;
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
        DisplayPanel.appendConsoleModel(this.getName() + " attacked!");
    }

    @Override
    public void castHealSpell(HealSpell healSpell) {
        healSpell.heal(this);
        DisplayPanel.appendConsoleModel(this.getName() + " casted " + healSpell.NAME + "!");
    }

    @Override
    public void castAttackSpell(AttackSpell attackSpell) {
        attackSpell.cast(this, player);
        DisplayPanel.appendConsoleModel(this.getName() + " casted " + attackSpell.NAME + "!");
    }

    @Override
    public void castStealGoldSpell(StealSpell stealSpell) {
        stealSpell.stealGold(this);
        DisplayPanel.appendConsoleModel(this.getName() + " casted " + stealSpell.NAME + "!");
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
        int exp = (int) (this.baseExp * random.nextDouble(0.5, 1.5));
        player.setExp(player.getExp() + exp);
        DisplayPanel.appendConsoleModel(String.format("You got %d exp!", exp));
    }

    @Override
    public void dropItem() {
        if (this.items.size() > 0 ) {
            DisplayPanel.appendConsoleModel(this.name + " Dropped an item!");
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

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public String getName() {
        return name;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    /*
    public Player getPlayer() {
        return player;
    }*/

}
