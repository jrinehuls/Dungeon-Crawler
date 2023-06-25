package model.item;

public abstract class Item {

    private String name;
    private int cost;
    private int salePrice;
    protected int quantity;

    public Item(String name, int cost, int salePrice) {
        this.name = name;
        this.cost = cost;
        this.salePrice = salePrice;
        this.quantity = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
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
        return ((this.getName() + " - Qty: " + this.quantity));
    }
}
