package model.monster;

import javax.swing.*;

public class Spaghetti extends Monster{

    public Spaghetti() {
        super("Flying Spaghetti Monster", 100, 100, 10, 10, 15, new ImageIcon("src/res/monsters/Spaghetti.png"));
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

}
