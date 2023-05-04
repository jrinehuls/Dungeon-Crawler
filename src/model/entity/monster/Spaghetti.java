package model.entity.monster;

import javax.swing.*;

public class Spaghetti extends Monster{

    public Spaghetti() {
        super("Flying Spaghetti Monster", 75, 75, 10, 10,  10, 10, 10, 1, 15, new ImageIcon("src/res/monsters/Spaghetti.png"));
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
    public void useItem() {

    }

    @Override
    public void dropItem() {

    }

    @Override
    public void dropGold() {
        if (HP <= 0) {
            player.setGold(player.getGold() + 20);
            System.out.println("You got 20 gold!");
        }
    }

    @Override
    public void giveExp() {

    }

}
