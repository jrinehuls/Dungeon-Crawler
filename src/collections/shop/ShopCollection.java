package collections.shop;

import collections.equipment.WeaponCollection;
import model.item.Item;
import model.item.consumable.AttackItem;
import model.item.consumable.HealingItem;
import model.item.equipment.*;

import java.util.HashMap;

public class ShopCollection {

    private final HashMap<String, Weapon> weaponsMap = new HashMap<>();
    private final Weapon[] weaponsArray = { WeaponCollection.WOODEN_DAGGER, WeaponCollection.BRONZE_DAGGER,
            WeaponCollection.IRON_SWORD, WeaponCollection.MITHRIL_SWORD};

    private final HashMap<String, Head> headGearsMap = new HashMap<>();
    private final Head[] headGearsArray = {};

    private final HashMap<String, Body> armorMap = new HashMap<>();
    private final Body[] armorArray = {};

    private final HashMap<String, Arm> armMap = new HashMap<>();
    private final Arm[] armArray = {};

    private final HashMap<String, Feet> footWearsMap = new HashMap<>();
    private final Feet[] footWearsArray = {};

    private final HashMap<String, Accessory> accessoriesMap = new HashMap<>();
    private final Accessory[] accessoriesArray = {};

    private final HashMap<String, AttackItem> attackItemsMap = new HashMap<>();
    private final AttackItem[] attackItemsArray = {};

    private final HashMap<String, HealingItem> healingItemsMap = new HashMap<>();
    private final HealingItem[] healingItemsArray = {};

    public ShopCollection() {
        this.setWeaponsMap();
        this.setHeadGearsMapMap();
    }

    // ----------------------------- Weapon Stuff -----------------------------
    public Weapon[] getWeaponsArray() {
        return this.weaponsArray;
    }

    public HashMap<String, Weapon> getWeaponsMap() {
        return this.weaponsMap;
    }

    public void setWeaponsMap() {
        for (Weapon weapon: this.weaponsArray) {
            this.weaponsMap.put(this.generateKey(weapon), weapon);
        }
    }

    // ---------------------------- Head Gear Stuff ----------------------------
    public Head[] getHeadGearsArray() {
        return this.headGearsArray;
    }

    public HashMap<String, Head> getHeadGearsMap() {
        return this.headGearsMap;
    }

    public void setHeadGearsMapMap() {
        for (Head headGear: this.headGearsArray) {
            this.headGearsMap.put(this.generateKey(headGear), headGear);
        }
    }

    public String generateKey(Item item) {
        return item.getName() + " - Price: " + item.getCost();
    }

}
