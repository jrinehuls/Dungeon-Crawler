package model.player;

import model.Entity;

public class Player extends Entity {

    private int level = 1;
    private int exp = 0;
    private int nextExp = 50;
    private int gold = 0;

    public Player() {
        super(100, 100, 10, 10, 15);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
