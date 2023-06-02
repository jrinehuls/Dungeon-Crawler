package model.item.consumable;

public class HealingItem extends Consumable{

    protected int HP;

    public HealingItem(String name, int cost, int salePrice, int HP) {
        super(name, cost, salePrice);
        this.HP = HP;
    }

}
