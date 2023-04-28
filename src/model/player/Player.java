package model.player;

import collections.SpellCollection;
import model.Entity;
import model.spell.AttackSpell;
import model.spell.HealingSpell;
import model.spell.Spell;
import view.panels.GamePanel;

import java.util.HashMap;

public class Player extends Entity {

    private static int level = 1;
    private int exp = 0;
    private int nextExp = 50;
    private int gold = 0;
    public HashMap<String, Spell> spells = new HashMap<>();

    public Player() {
        super(100, 100, 10, 10, 20, 20, 10, 10, 25);
        spells.put("First Aid", SpellCollection.spellMap.get("First Aid"));
        spells.put("Flare", SpellCollection.spellMap.get("Flare"));
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

    public void castHealingSpell(HealingSpell spell) {
        spell.cast(this);
    }

    public void castAttackSpell(AttackSpell spell) {
        spell.cast(this, GamePanel.getMonster());
    }

}
