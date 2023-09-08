package collections.tileobject;

import collections.consumable.AttackItemCollection;
import collections.consumable.HealingItemCollection;
import collections.equipment.*;
import model.tileobject.Treasure;

public class TreasureCollection {

    // Attack Items
    public static final Treasure BOMB_TREASURE = new Treasure(AttackItemCollection.BOMB);

    // Heal Items
    public static final Treasure HEALING_HERB = new Treasure(HealingItemCollection.HEALING_HERB);

    // Accessories
    public static final Treasure NECKLACE_OF_WISDOM = new Treasure(AccessoryCollection.NECKLACE_OF_WISDOM);
    public static final Treasure RING_OF_VITALITY = new Treasure(AccessoryCollection.RING_OF_VITALITY);

    // Arms
    public static final Treasure LEATHER_GLOVES = new Treasure(ArmCollection.LEATHER_GLOVES);
    public static final Treasure STEEL_VAMBRACE = new Treasure(ArmCollection.STEEL_VAMBRACE);

    // Body
    public static final Treasure CHAIN_MAIL = new Treasure(BodyCollection.CHAIN_MAIL);
    public static final Treasure PLATE_MAIL = new Treasure(BodyCollection.PLATE_MAIL);

    // Feet
    public static final Treasure LEATHER_BOOTS = new Treasure(FeetCollection.LEATHER_BOOTS);
    public static final Treasure IRON_GREAVES = new Treasure(FeetCollection.IRON_GREAVES);

    // Head
    public static final Treasure LEATHER_CAP = new Treasure(HeadCollection.LEATHER_CAP);
    public static final Treasure COPPER_HELM = new Treasure(HeadCollection.COPPER_HELM);

    // Weapons
    public static final Treasure BRONZE_DAGGER = new Treasure(WeaponCollection.BRONZE_DAGGER);
    public static final Treasure IRON_SWORD = new Treasure(WeaponCollection.IRON_SWORD);

}
