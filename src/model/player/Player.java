package model.player;

import collections.SpellCollection;
import model.Entity;
import model.spell.HealingSpell;
import model.spell.Spell;

import java.util.HashMap;

public class Player extends Entity {

    private static int level = 1;
    private int exp = 0;
    private int nextExp = 50;
    private int gold = 0;
    public HashMap<String, Spell> spells = new HashMap<>();


    public Player() {
        super(100, 100, 4, 10, 20, 20, 10, 10, 25);
        spells.put("First Aid", SpellCollection.spellMap.get("First Aid"));
    }

    public int getLevel() {
        return level;
    }

    public void levelUp(int level) {
        Player.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getNextExp() {
        return nextExp;
    }

    public void setNextExp(int nextExp) {
        this.nextExp = nextExp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void castSpell(Spell spell) {
        spell.cast(this);
    }

}
