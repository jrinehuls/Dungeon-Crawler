package model.entity.monster;

import model.spell.AttackSpell;
import model.spell.HealSpell;
import model.spell.StealGoldSpell;

public interface MonsterActions {

    void takeAction();

    void attack();

    void castHealSpell(HealSpell spell);

    void castAttackSpell(AttackSpell spell);

    void castStealSpell(StealGoldSpell spell);

    void useItem();

    void dropItem();

    void dropGold();

    void giveExp();
}
