package model.entity;

import model.spell.AttackSpell;
import model.spell.HealSpell;
import model.spell.StealSpell;

public interface EntityActions {

    void attack(Entity target);

    void castHealSpell(HealSpell healSpell);

    void castAttackSpell(AttackSpell attackSpell);

    void castStealGoldSpell(StealSpell stealSpell);

    void castStealItemSpell(StealSpell stealSpell);

    void useItem();

}