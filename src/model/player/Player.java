package model.player;

import model.Entity;

public class Player extends Entity {

    private int level;
    private int exp;

    public Player(int exp, int level) {
        super(100, 100, 10, 10, 15);
        this.exp = exp;
        this.level = level;
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


}
