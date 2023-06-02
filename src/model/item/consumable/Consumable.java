package model.item.consumable;

import model.item.Item;

public abstract class Consumable extends Item {

    protected int quantity;

    public Consumable(String name, int cost, int salePrice) {
        super(name, cost, salePrice);
        quantity = 1;
    }

}
