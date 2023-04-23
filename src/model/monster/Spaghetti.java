package model.monster;

import javax.swing.*;

public class Spaghetti extends Monster{

    public Spaghetti() {
        super("Flying Spaghetti Monster", 75, 75, 0, 0,  10, 10, 0, 0, 15, new ImageIcon("src/res/monsters/Spaghetti.png"));
        // hp = 500;
    }

    @Override
    public void takeAction() {
        if (progress >= 100) {
            attack();
            progress = 0;
        }
    }

    @Override
    public void attack() {
        System.out.println("Now it's Spaghetti time");
    }

    @Override
    public void castSpell() {

    }

    @Override
    public void useItem() {

    }

    @Override
    public void dropItem() {

    }

    @Override
    public void dropGold() {

    }

    @Override
    public void giveExp() {

    }

}
