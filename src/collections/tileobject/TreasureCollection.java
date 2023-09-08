package collections.tileobject;

import collections.consumable.AttackItemCollection;
import collections.equipment.WeaponCollection;
import model.tileobject.Treasure;

public class TreasureCollection {

    // private static final String iconPath = "/icons/Treasure.png";
    // private static final String backgroundFileName = "/backgrounds/Treasure.png";

    public static final Treasure BOMB_TREASURE = new Treasure(AttackItemCollection.BOMB);
    public static final Treasure MITHRIL_SWORD_TREASURE = new Treasure(WeaponCollection.MITHRIL_SWORD);

}
