package model.entity.monster;

import collections.consumable.AttackItemCollection;
import collections.consumable.HealingItemCollection;
import collections.spell.HealSpellCollection;
import collections.spell.StealSpellCollection;
import model.item.consumable.HealingItem;
import model.spell.HealSpell;
import model.spell.StealSpell;
import view.panels.game.DisplayPanel;

import javax.swing.*;

public class Karen extends Monster {


    public Karen() {
        super("Karen", 50, 12,  10, 7, 5, 10, 20, 10, 60, new ImageIcon("res/monsters/Karen.png"));
        spells.put("First Aid", HealSpellCollection.FIRST_AID);
        spells.put("Call Manager", StealSpellCollection.CALL_MANAGER);
        items.add(AttackItemCollection.BOMB);
        items.add(HealingItemCollection.HEALING_HERB);
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

}
