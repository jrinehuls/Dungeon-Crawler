package model.entity.monster;

import collections.SpellCollection;
import model.spell.HealingSpell;
import model.spell.StealSpell;

import javax.swing.*;

public class Karen extends Monster {

    public Karen() {
        super("Karen", 50, 50, 10, 10,  10, 10, 5, 10, 20, new ImageIcon("src/res/monsters/Karen.png"));
        spells.put("First Aid", SpellCollection.firstAid);
        spells.put("Call Manager", SpellCollection.callManager);
    }

    @Override
    public void takeAction() {
        if (progress >= 100) {
            if (HP <= maxHP - SpellCollection.firstAid.health && MP >= spells.get("First Aid").MP) {
                castHealSpell((HealingSpell) spells.get("First Aid"));
            } else {
                // Add RNG to pick action
                castStealSpell((StealSpell) spells.get("Call Manager"));
                attack();
            }
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
            player.setGold(player.getGold() + 10);
            System.out.println("You got 10 gold!");
        }
    }

    @Override
    public void giveExp() {
        player.setExp(player.getExp() + 60);
    }

}
