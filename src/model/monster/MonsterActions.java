package model.monster;

import model.spell.Spell;

public interface MonsterActions {

    void takeAction();
    void attack();

    void castHealingSpell(Spell spell);

    void useItem();

    void dropItem();

    void dropGold();

    void giveExp();
}
