package model.entity.monster;

import model.spell.AttackSpell;
import model.spell.HealingSpell;
import model.spell.StealSpell;

public interface MonsterActions {

    void takeAction();
    void attack();

    void castHealSpell(HealingSpell spell);

    void castAttackSpell(AttackSpell spell);

    void castStealSpell(StealSpell spell);

    void useItem();

    void dropItem();

    void dropGold();

    void giveExp();
}
