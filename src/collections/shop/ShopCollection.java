package collections.shop;

import collections.consumable.AttackItemCollection;
import collections.consumable.HealingItemCollection;
import collections.equipment.*;
import model.item.Item;
import model.item.consumable.AttackItem;
import model.item.consumable.Consumable;
import model.item.consumable.HealingItem;
import model.item.equipment.*;

import java.util.HashMap;

public class ShopCollection {

    private final HashMap<String, Equipment> weaponsMap = new HashMap<>();
    private final Weapon[] weaponsArray = { WeaponCollection.WOODEN_DAGGER, WeaponCollection.BRONZE_DAGGER,
            WeaponCollection.IRON_SWORD, WeaponCollection.MITHRIL_SWORD };

    private final HashMap<String, Equipment> headGearsMap = new HashMap<>();
    private final Head[] headGearsArray = { HeadCollection.STRAW_HAT, HeadCollection.LEATHER_CAP,
            HeadCollection.COPPER_HELM, HeadCollection.MITHRIL_HELM };

    private final HashMap<String, Equipment> armorMap = new HashMap<>();
    private final Body[] armorArray = { BodyCollection.LEATHER_VEST, BodyCollection.CHAIN_MAIL,
            BodyCollection.PLATE_MAIL, BodyCollection.MITHRIL_ARMOR };

    private final HashMap<String, Equipment> armMap = new HashMap<>();
    private final Arm[] armArray = { ArmCollection.RUBBER_BRACELET, ArmCollection.LEATHER_GLOVES,
            ArmCollection.STEEL_VAMBRACE, ArmCollection.MITHRIL_VAMBRACE };

    private final HashMap<String, Equipment> footWearsMap = new HashMap<>();
    private final Feet[] footWearsArray = { FeetCollection.LEATHER_SANDALS, FeetCollection.LEATHER_BOOTS,
            FeetCollection.IRON_GREAVES, FeetCollection.MITHRIL_GREAVES };

    private final HashMap<String, Equipment> accessoriesMap = new HashMap<>();
    private final Accessory[] accessoriesArray = { AccessoryCollection.SPELL_TOME, AccessoryCollection.RING_OF_VITALITY,
            AccessoryCollection.NECKLACE_OF_WISDOM, AccessoryCollection.VEIL_OF_PROTECTION };

    private final HashMap<String, Consumable> attackItemsMap = new HashMap<>();
    private final AttackItem[] attackItemsArray = { AttackItemCollection.BOMB, AttackItemCollection.THROWING_KNIFE,
            AttackItemCollection.LARGE_BOMB };

    private final HashMap<String, Consumable> healingItemsMap = new HashMap<>();
    private final HealingItem[] healingItemsArray = {HealingItemCollection.HEALING_HERB,
            HealingItemCollection.VIAL_OF_REJUVENATION};

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

    public HashMap<String, Equipment> getWeaponsMap() {
        return this.weaponsMap;
    }

    private void setWeaponsMap() {
        for (Weapon weapon: this.weaponsArray) {
            this.weaponsMap.put(this.generateBuyKey(weapon), weapon);
        }
    }

    // ---------------------------- Head Gear Stuff ----------------------------
    public Head[] getHeadGearsArray() {
        return this.headGearsArray;
    }

    public HashMap<String, Equipment> getHeadGearsMap() {
        return this.headGearsMap;
    }

    private void setHeadGearsMap() {
        for (Head headGear: this.headGearsArray) {
            this.headGearsMap.put(this.generateBuyKey(headGear), headGear);
        }
    }

    // ---------------------------- Armor Gear Stuff ----------------------------
    public Body[] getArmorArray() {
        return this.armorArray;
    }

    public HashMap<String, Equipment> getArmorMap() {
        return this.armorMap;
    }

    private void setArmorMap() {
        for (Body armor: this.armorArray) {
            this.armorMap.put(this.generateBuyKey(armor), armor);
        }
    }

    // ----------------------------- Arm Gear Stuff -----------------------------
    public Arm[] getArmArray() {
        return this.armArray;
    }

    public HashMap<String, Equipment> getArmMap() {
        return this.armMap;
    }

    private void setArmMap() {
        for (Arm arm: this.armArray) {
            this.armMap.put(this.generateBuyKey(arm), arm);
        }
    }

    // ----------------------------- Feet Stuff -----------------------------
    public Feet[] getFootWearsArray() {
        return this.footWearsArray;
    }

    public HashMap<String, Equipment> getFootWearsMap() {
        return this.footWearsMap;
    }

    private void setFootWearsMap() {
        for (Feet foot: this.footWearsArray) {
            this.footWearsMap.put(this.generateBuyKey(foot), foot);
        }
    }

    // ----------------------------- Accessory Stuff -----------------------------
    public Accessory[] getAccessoriesArray() {
        return this.accessoriesArray;
    }

    public HashMap<String, Equipment> getAccessoriesMap() {
        return this.accessoriesMap;
    }

    private void setAccessoriesMap() {
        for (Accessory accessory: this.accessoriesArray) {
            this.accessoriesMap.put(this.generateBuyKey(accessory), accessory);
        }
    }

    // ----------------------------- Attack Items Stuff -----------------------------
    public AttackItem[] getAttackItemsArray() {
        return this.attackItemsArray;
    }

    public HashMap<String, Consumable> getAttackItemsMap() {
        return this.attackItemsMap;
    }

    private void setAttackItemsMap() {
        for (AttackItem attackItem: this.attackItemsArray) {
            this.attackItemsMap.put(this.generateBuyKey(attackItem), attackItem);
        }
    }

    // ----------------------------- Healing Items Stuff -----------------------------
    public HealingItem[] getHealingItemsArray() {
        return this.healingItemsArray;
    }

    public HashMap<String, Consumable> getHealingItemsMap() {
        return this.healingItemsMap;
    }

    private void setHealingItemsMap() {
        for (HealingItem healingItem: this.healingItemsArray) {
            this.healingItemsMap.put(this.generateBuyKey(healingItem), healingItem);
        }
    }

    // -------------------------------- Key Stuff --------------------------------
    public String generateBuyKey(Item item) {
        return item.getName() + " - Price: " + item.getCost();
    }

    public String generateSellKey(Item item) {
        return item.getName() + " - Sale Price: " + item.getSalePrice();
    }

}
