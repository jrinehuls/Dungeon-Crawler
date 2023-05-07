package model.item.equipment;

public class Weapon extends Equipment {

    private final int attack;

    public Weapon(String name,int attack, int cost, int salePrice) {
        super(name, cost, salePrice);
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

}
