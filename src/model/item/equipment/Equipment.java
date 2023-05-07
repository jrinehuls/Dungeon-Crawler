package model.item.equipment;

import model.item.Item;

public abstract class Equipment extends Item {

    public Equipment(String name, int cost, int salePrice) {
        super(name, cost, salePrice);
    }
}
