package model.entity.monster;

import model.spell.AttackSpell;
import model.spell.HealSpell;
import model.spell.StealSpell;

public interface MonsterActions {

    void takeAction();

    void dropGold();

    void giveExp();

    void dropItem();
}
