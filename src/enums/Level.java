package enums;

import collections.spell.*;
import model.spell.Spell;

public enum Level {

    LEVEL2(25, 14, 4, 3, 2, 1, 1, 2, StealSpellCollection.MUG),
    LEVEL3(38, 19, 5, 2, 1, 2, 0, 1, null);

    public final int increaseNextExp;
    public final int increaseHP;
    public final int increaseMP;
    public final int increaseAttack;
    public final int increaseDefense;
    public final int increaseMAttack;
    public final int increaseMDefense;
    public final int increaseSpeed;
    public final Spell spell;

    Level(int increaseNextExp, int increaseHP, int increaseMP, int increaseAttack , int increaseDefense,
          int increaseMAttack, int increaseMDefense, int increaseSpeed, Spell spell) {

        this.increaseNextExp = increaseNextExp;
        this.increaseHP = increaseHP;
        this.increaseMP = increaseMP;
        this.increaseAttack = increaseAttack;
        this.increaseDefense = increaseDefense;
        this.increaseMAttack = increaseMAttack;
        this.increaseMDefense = increaseMDefense;
        this.increaseSpeed = increaseSpeed;
        this.spell = spell;
    }

    @Override
    public String toString() {
        String oldName = this.name().toLowerCase();
        return "L" + oldName.substring(1, 5) + " " + oldName.substring(5);
    }
}
