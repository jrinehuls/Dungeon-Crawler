package model.monster;



import javax.swing.*;

public class Karen extends Monster{

    public Karen() {
        super("Karen", 50, 50, 0, 0,  10, 10, 0, 0, 20, new ImageIcon("src/res/monsters/Karen.png"));
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
        System.out.println("Karen attacked!");
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
            player.setGold(player.getGold() + 10);
            System.out.println("You got 10 gold!");
        }
    }

    @Override
    public void giveExp() {

    }

}
