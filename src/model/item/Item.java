package model.item;

public abstract class Item {

    private String name;
    private int cost;
    private int salePrice;

    public Item(String name, int cost, int salePrice) {
        this.name = name;
        this.cost = cost;
        this.salePrice = salePrice;
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

    @Override
    public String toString() {
        return name;
    }
}
