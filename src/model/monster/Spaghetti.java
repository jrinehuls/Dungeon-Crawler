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
        player.setHP(player.getHP() - (attack/player.getDefense() + 10));
        System.out.println("Spaghetti attacked!");
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
        if (HP <= 0) {
            player.setGold(player.getGold() + 20);
            System.out.println("You got 20 gold!");
        }
    }

    @Override
    public void giveExp() {

    }

}
