package model.entity;

import model.item.consumable.AttackItem;
import model.item.consumable.HealingItem;
import model.spell.AttackSpell;
import model.spell.HealSpell;
import model.spell.StealSpell;

public interface EntityActions {

    void attack(Entity target);

    void castHealSpell(HealSpell healSpell);

    void castAttackSpell(AttackSpell attackSpell);

    void castStealGoldSpell(StealSpell stealSpell);

    void castStealItemSpell(StealSpell stealSpell);

    void useHealingItem(HealingItem healingItem);

    void useAttackItem(AttackItem attackItem);

}
