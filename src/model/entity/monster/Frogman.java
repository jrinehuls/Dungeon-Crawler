package model.entity.monster;

import collections.consumable.AttackItemCollection;
import collections.consumable.HealingItemCollection;
import collections.spell.AttackSpellCollection;
import model.spell.AttackSpell;

import javax.swing.*;

public class Frogman extends Monster {

    public Frogman() {
        super("Loveland Frogman", 70,  15,  5, 5, 18, 12, 8, 10, 30, "/monsters/Frogman.png");
        spells.put("Flare", AttackSpellCollection.FLARE);
        items.add(AttackItemCollection.BOMB);
        items.add(HealingItemCollection.HEALING_HERB);
    }

    @Override
    public void takeAction() {
        if (progress >= 100) {
            double random = Math.random();
            if (MP >= spells.get("Flare").MP && random < 0.9) {
                castAttackSpell((AttackSpell) spells.get("Flare"));
            } else {
                attack(player);
            }
            progress = 0;
        }
    }


}
