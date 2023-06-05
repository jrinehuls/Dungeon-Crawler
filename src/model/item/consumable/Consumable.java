package model.item.consumable;

import model.item.Item;

public abstract class Consumable extends Item {

    protected int quantity;

    public Consumable(String name, int cost, int salePrice) {
        super(name, cost, salePrice);
        quantity = 1;
    }

    public int getQty() {
        return this.quantity;
    }

    public void increaseQty() {
        this.quantity += 1;
    }

    public void decreaseQty() {
        if (this.quantity > 0) {
            this.quantity -= 1;
        }
    }

    @Override
    public String toString() {
        return (this.getName() + " - Qty: " + this.quantity);
    }
}
