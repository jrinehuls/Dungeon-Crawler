package model.entity;

import model.item.consumable.AttackItem;
import model.item.consumable.HealingItem;
import model.spell.*;

public interface EntityActions {

    void attack(Entity target);

    void castHealSpell(HealSpell healSpell);

    void castAttackSpell(AttackSpell attackSpell);

    void castStealGoldSpell(StealGoldSpell stealSpell);

    void castStealItemSpell(StealItemSpell stealSpell);

    void useHealingItem(HealingItem healingItem);

    void useAttackItem(AttackItem attackItem);

}
