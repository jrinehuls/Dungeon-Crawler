package model.entity.player;

import collections.spell.AttackSpellCollection;
import collections.spell.HealSpellCollection;
import collections.spell.StealSpellCollection;
import model.entity.Entity;
import model.entity.monster.Monster;
import model.spell.AttackSpell;
import model.spell.HealSpell;
import enums.Level;
import model.spell.StealSpell;
import view.panels.GamePanel;
import view.panels.MonsterPanel;

public class Player extends Entity {

    private static int level = 1;
    private static int exp = 0;
    private static int nextExp = 50;
    private static int gold = 5;
    //public HashMap<String, Spell> spells = new HashMap<>();

    public Player() {
        super(100, 10,  20, 20, 10, 10, 25);
        spells.put("First Aid", HealSpellCollection.FIRST_AID);
        spells.put("Flare", AttackSpellCollection.FLARE);
    }

    @Override
    public void attack() {
        Monster monster = MonsterPanel.getMonster();
        monster.setHP(monster.getHP() - (5 * this.getAttack() / monster.getDefense() + 10));
    }

    @Override
    public void castAttackSpell(AttackSpell spell) {
        spell.cast(this, MonsterPanel.getMonster());
    }

    @Override
    public void castStealSpell(StealSpell spell) {
        spell.cast(this);
    }

    @Override
    public void useItem() {

    }

    public void castHealSpell(HealSpell spell) {
        spell.cast(this);
    }

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
                    // break;
                }
            }
        }
    }

    public int getLevel() {
        return level;
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


}
