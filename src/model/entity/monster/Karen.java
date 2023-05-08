package model.entity.monster;

import collections.spell.HealSpellCollection;
import collections.spell.StealSpellCollection;
import model.entity.Entity;
import model.spell.HealSpell;
import model.spell.StealSpell;

import javax.swing.*;

public class Karen extends Monster {

    public Karen() {
        super("Karen", 50, 12,  10, 10, 5, 10, 20, new ImageIcon("src/res/monsters/Karen.png"));
        spells.put("First Aid", HealSpellCollection.FIRST_AID);
        spells.put("Call Manager", StealSpellCollection.CALL_MANAGER);
    }

    @Override
    public void takeAction() {
        if (progress >= 100) {
            double random = Math.random();
            if (random <= 0.75 && HP <= maxHP - HealSpellCollection.FIRST_AID.HEALTH && MP >= spells.get("First Aid").MP) {
                castHealSpell((HealSpell) spells.get("First Aid"));
            } else if (random <= 0.9 && MP >= spells.get("Call Manager").MP) {
                castStealGoldSpell((StealSpell) spells.get("Call Manager"));
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
            player.setGold(player.getGold() + 10);
            System.out.println("You got 10 gold!");
        }
    }

    @Override
    public void giveExp() {
        player.setExp(player.getExp() + 60);
    }

}
