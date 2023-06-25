package model.item.consumable;

import model.item.Item;

public abstract class Consumable extends Item {

    public Consumable(String name, int cost, int salePrice) {
        super(name, cost, salePrice);
    }


}
