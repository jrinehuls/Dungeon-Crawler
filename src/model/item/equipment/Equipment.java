package model.item.equipment;

import model.item.Item;

public abstract class Equipment extends Item {

    protected int maxHP;
    protected int maxMP;
    protected int attack;
    protected int defense;
    protected int magicAttack;
    protected int magicDefense;
    protected int speed;

    public Equipment(String name, int cost, int salePrice, int maxHP, int maxMP, int attack, int defense,
                     int magicAttack, int magicDefense, int speed) {
        super(name, cost, salePrice);
        this.maxHP = maxHP;
        this.maxMP = maxMP;
        this.attack = attack;
        this.defense = defense;
        this.magicAttack = magicAttack;
        this.magicDefense = magicDefense;
        this.speed = speed;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getMagicAttack() {
        return magicAttack;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return (this.getName() + " - Qty: " + this.quantity);
    }

}
