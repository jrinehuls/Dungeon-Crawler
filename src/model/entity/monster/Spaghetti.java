package model.entity.monster;

import collections.consumable.AttackItemCollection;
import collections.consumable.HealingItemCollection;
import collections.spell.AttackSpellCollection;
import model.spell.AttackSpell;

import javax.swing.*;

public class Spaghetti extends Monster{

    public Spaghetti() {
        super("Flying Spaghetti Monster", 75,  10,  18, 18, 18, 18, 16, 40, 70, new ImageIcon("res/monsters/Spaghetti.png"));
        spells.put("Flare", AttackSpellCollection.FLARE);
        items.add(AttackItemCollection.BOMB);
        items.add(HealingItemCollection.HEALING_HERB);
    }

    @Override
    public void takeAction() {
        if (progress >= 100) {
            double random = Math.random();
            if (random < 0.50 && !items.isEmpty()) {
                this.useRandomItem();
            } else if (MP >= spells.get("Flare").MP && random < 0.9) {
                this.castAttackSpell((AttackSpell) spells.get("Flare"));
            } else {
                this.attack(player);
            }
            progress = 0;
        }
    }


}
