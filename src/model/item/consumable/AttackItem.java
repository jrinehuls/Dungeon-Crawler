package model.item.consumable;

public class AttackItem extends Consumable{

    protected int damage;

    public AttackItem(String name, int cost, int salePrice, int damage) {
        super(name, cost, salePrice);
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }
}
