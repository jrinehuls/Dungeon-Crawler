package model.item.equipment;

public class Accessory extends Equipment {

    public Accessory(String name, int cost, int salePrice, int maxHP, int maxMP, int attack, int defense,
                     int magicAttack, int magicDefense, int speed) {
        super(name, cost, salePrice, maxHP, maxMP, attack, defense, magicAttack, magicDefense, speed);
    }
}
