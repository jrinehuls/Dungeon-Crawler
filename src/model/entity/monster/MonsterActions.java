package model.entity.monster;

import model.spell.AttackSpell;
import model.spell.HealSpell;
import model.spell.StealSpell;

public interface MonsterActions {

    void takeAction();

    void dropItem();

    void dropGold();

    void giveExp();
}
