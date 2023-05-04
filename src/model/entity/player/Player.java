package model.entity.player;

import collections.SpellCollection;
import model.entity.Entity;
import model.entity.monster.Monster;
import model.spell.AttackSpell;
import model.spell.HealingSpell;
import model.spell.Spell;
import enums.Level;
import view.panels.GamePanel;

import java.util.HashMap;

public class Player extends Entity {

    private static int level = 1;
    private static int exp = 0;
    private static int nextExp = 50;
    private static int gold = 0;
    public HashMap<String, Spell> spells = new HashMap<>();

    public Player() {
        super(100, 100, 10, 10, 20, 20, 10, 10, 25);
        spells.put("First Aid", SpellCollection.firstAid);
        spells.put("Flare", SpellCollection.spellMap.get("Flare"));
    }

    public int getLevel() {
        return level;
    }

    // This is a place-holder. Level up needs more functionality.
    public void levelUp() {
        if (exp >= nextExp) {
            level++;
            exp = exp - nextExp;
            for (Level nextLevel : Level.values()) {
                if (level == Integer.parseInt(nextLevel.name().substring(5))){
                    System.out.println("You've reached " + nextLevel.name());
                    System.out.println("You've reached " + level);
                    nextExp += nextLevel.increaseNextExp;
                    HP += nextLevel.increaseHP;
                    maxHP += nextLevel.increaseHP;
                    MP += nextLevel.increaseMP;
                    maxMP += nextLevel.increaseMP;
                    attack += nextLevel.increaseAttack;
                    defense += nextLevel.increaseDefense;
                    magicAttack += nextLevel.increaseMAttack;
                    magicDefense += nextLevel.increaseMDefense;
                    speed += nextLevel.increaseSpeed;
                }
            }
        }
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

    public void castHealSpell(HealingSpell spell) {
        spell.cast(this);
    }

    public void castAttackSpell(AttackSpell spell) {
        spell.cast(this, GamePanel.getMonster());
    }

    public void attack() {
        Monster monster = GamePanel.getMonster();
        monster.setHP(monster.getHP() - (5 * this.getAttack() / monster.getDefense() + 10));
    }
}
