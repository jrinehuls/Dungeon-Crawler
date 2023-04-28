package model.monster;

import model.spell.HealingSpell;
import model.spell.Spell;

public interface MonsterActions {

    void takeAction();
    void attack();

    void castHealingSpell(HealingSpell spell);

    void useItem();

    void dropItem();

    void dropGold();

    void giveExp();
}
