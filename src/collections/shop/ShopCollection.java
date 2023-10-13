package collections.shop;

import collections.equipment.WeaponCollection;
import model.item.Item;
import model.item.equipment.Weapon;

import java.util.HashMap;

public class ShopCollection {

    private HashMap<String, Item> weaponsMap = new HashMap<>();

    private Item[] weapons = { WeaponCollection.WOODEN_DAGGER, WeaponCollection.BRONZE_DAGGER,
            WeaponCollection.IRON_SWORD, WeaponCollection.MITHRIL_SWORD};

    public ShopCollection() {
        this.setWeapons();
    }

    public HashMap<String, Item> getWeapons() {
        return this.weaponsMap;
    }

    public void setWeapons() {
        for (Item weapon: weapons) {
            this.weaponsMap.put(weapon.getName() + "-" + weapon.getCost(), weapon);
        }
    }

}
