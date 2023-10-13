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
        this.setHeadGearsMap();
        this.setArmorMap();
        this.setArmMap();
        this.setFootWearsMap();
        this.setAccessoriesMap();
        this.setAttackItemsMap();
        this.setHealingItemsMap();
    }

    // ----------------------------- Weapon Stuff -----------------------------
    public Weapon[] getWeaponsArray() {
        return this.weaponsArray;
    }

    public HashMap<String, Weapon> getWeaponsMap() {
        return this.weaponsMap;
    }

    private void setWeaponsMap() {
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

    private void setHeadGearsMap() {
        for (Head headGear: this.headGearsArray) {
            this.headGearsMap.put(this.generateKey(headGear), headGear);
        }
    }

    // ---------------------------- Armor Gear Stuff ----------------------------
    public Body[] getArmorArray() {
        return this.armorArray;
    }

    public HashMap<String, Body> getArmorMap() {
        return this.armorMap;
    }

    private void setArmorMap() {
        for (Body armor: this.armorArray) {
            this.armorMap.put(this.generateKey(armor), armor);
        }
    }

    // ----------------------------- Arm Gear Stuff -----------------------------
    public Arm[] getArmArray() {
        return this.armArray;
    }

    public HashMap<String, Arm> getArmMap() {
        return this.armMap;
    }

    private void setArmMap() {
        for (Arm arm: this.armArray) {
            this.armMap.put(this.generateKey(arm), arm);
        }
    }

    // ----------------------------- Feet Stuff -----------------------------
    public Feet[] getFootWearsArray() {
        return this.footWearsArray;
    }

    public HashMap<String, Feet> getFootWearsMap() {
        return this.footWearsMap;
    }

    private void setFootWearsMap() {
        for (Feet foot: this.footWearsArray) {
            this.footWearsMap.put(this.generateKey(foot), foot);
        }
    }

    // ----------------------------- Accessory Stuff -----------------------------
    public Accessory[] getAccessoriesArray() {
        return this.accessoriesArray;
    }

    public HashMap<String, Accessory> getAccessoriesMap() {
        return this.accessoriesMap;
    }

    private void setAccessoriesMap() {
        for (Accessory accessory: this.accessoriesArray) {
            this.accessoriesMap.put(this.generateKey(accessory), accessory);
        }
    }

    // ----------------------------- Attack Items Stuff -----------------------------
    public AttackItem[] getAttackItemsArray() {
        return this.attackItemsArray;
    }

    public HashMap<String, AttackItem> getAttackItemsMap() {
        return this.attackItemsMap;
    }

    private void setAttackItemsMap() {
        for (AttackItem attackItem: this.attackItemsArray) {
            this.attackItemsMap.put(this.generateKey(attackItem), attackItem);
        }
    }

    // ----------------------------- Healing Items Stuff -----------------------------
    public HealingItem[] getHealingItemsArray() {
        return this.healingItemsArray;
    }

    public HashMap<String, HealingItem> getHealingItemsMap() {
        return this.healingItemsMap;
    }

    private void setHealingItemsMap() {
        for (HealingItem healingItem: this.healingItemsArray) {
            this.healingItemsMap.put(this.generateKey(healingItem), healingItem);
        }
    }

    // -------------------------------- Key Stuff --------------------------------
    public String generateKey(Item item) {
        return item.getName() + " - Price: " + item.getCost();
    }

}
