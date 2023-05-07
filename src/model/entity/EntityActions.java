package model.entity;

import model.spell.AttackSpell;
import model.spell.HealSpell;
import model.spell.StealSpell;

public interface EntityActions {

    void attack();

    void castHealSpell(HealSpell spell);

    void castAttackSpell(AttackSpell spell);

    void castStealSpell(StealSpell spell);

    void useItem();

}
