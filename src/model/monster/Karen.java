package model.monster;



import model.spell.Spell;

import javax.swing.*;

public class Karen extends Monster{




    public Karen() {
        super("Karen", 50, 50, 10, 10,  10, 10, 5, 10, 20, new ImageIcon("src/res/monsters/Karen.png"));
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
    public void castHealingSpell(Spell spell) {
        spell.cast(this);
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
