package model.entity.monster;

import collections.equipment.WeaponCollection;
import collections.spell.HealSpellCollection;
import collections.spell.StealSpellCollection;
import model.spell.HealSpell;
import model.spell.StealGoldSpell;
import model.spell.StealItemSpell;
import model.spell.StealSpell;

import javax.swing.*;

public class Karen extends Monster {


    public Karen() {
        super("Karen", 40, 8,  6, 8, 5, 6, 16, 10, 20, new ImageIcon("res/monsters/Karen.png"));
        spells.put("First Aid", HealSpellCollection.FIRST_AID);
        spells.put("Mug", StealSpellCollection.MUG);
        spells.put("Call Manager", StealSpellCollection.CALL_MANAGER);
        items.add(WeaponCollection.WOODEN_DAGGER);
        // items.add(AttackItemCollection.BOMB);
        // items.add(HealingItemCollection.HEALING_HERB);
    }

    @Override
    public void takeAction() {
        if (progress >= 100) {
            double random = Math.random();
            if (random <= 0.74 && MP >= spells.get("Mug").MP) {
                castStealItemSpell((StealItemSpell) spells.get("Mug"));
            } else if (random <= 0.75 && HP <= maxHP - HealSpellCollection.FIRST_AID.HEALTH && MP >= spells.get("First Aid").MP) {
                castHealSpell((HealSpell) spells.get("First Aid"));
            } else if (random <= 0.9 && MP >= spells.get("Call Manager").MP) {
                castStealGoldSpell((StealGoldSpell) spells.get("Call Manager"));
            } else {
                attack(player);
            }
            progress = 0;
        }
    }

}
