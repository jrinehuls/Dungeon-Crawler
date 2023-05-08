package model.entity.monster;

import collections.spell.AttackSpellCollection;
import model.spell.AttackSpell;

import javax.swing.*;

public class Spaghetti extends Monster{

    public Spaghetti() {
        super("Flying Spaghetti Monster", 75,  10,  10, 10, 10, 1, 15, new ImageIcon("src/res/monsters/Spaghetti.png"));
        spells.put("Flare", AttackSpellCollection.FLARE);
    }

    @Override
    public void takeAction() {
        if (progress >= 100) {
            if (MP >= spells.get("Flare").MP) {
                castAttackSpell((AttackSpell) spells.get("Flare"));
            } else {
                attack(player);
            }
            progress = 0;
        }
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
        player.setExp(player.getExp() + 30);
    }

}
