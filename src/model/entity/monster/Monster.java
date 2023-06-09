package model.entity.monster;

import model.entity.Entity;
import model.entity.player.Player;
import model.item.Item;
import model.item.consumable.AttackItem;
import model.item.consumable.HealingItem;
import model.spell.AttackSpell;
import model.spell.HealSpell;
import model.spell.StealSpell;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Monster extends Entity implements MonsterActions {

    protected String name;
    protected ImageIcon icon;

    protected ArrayList<Item> items = new ArrayList<>();

    Player player;

    public Monster(String name, int HP, int MP, int attack, int defense, int magicAttack, int magicDefense, int speed, ImageIcon icon) {
        super(HP, MP, attack, defense, magicAttack, magicDefense, speed);
        this.icon = icon;
        this.name = name;
        player = PlayerPanel.getPlayer();
    }

    @Override
    public void attack(Entity player) {
        super.attack(player);
        System.out.println(this.getName() + " attacked!");
    }

    @Override
    public void castHealSpell(HealSpell healSpell) {
        healSpell.heal(this);
        System.out.println(this.getName() + " casted " + healSpell.NAME);
    }

    @Override
    public void castAttackSpell(AttackSpell attackSpell) {
        attackSpell.cast(this, player);
        System.out.println(this.getName() + " casted " + attackSpell.NAME);
    }

    @Override
    public void castStealGoldSpell(StealSpell stealSpell) {
        stealSpell.stealGold(this);
        System.out.println(this.getName() + " casted " + stealSpell.NAME);
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

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public String  getName() {
        return name;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public Player getPlayer() {
        return player;
    }

}
