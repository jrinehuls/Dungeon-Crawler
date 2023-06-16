package model.entity.monster;

import collections.spell.AttackSpellCollection;
import model.spell.AttackSpell;
import view.panels.game.DisplayPanel;

import javax.swing.*;

public class Spaghetti extends Monster{

    public Spaghetti() {
        super("Flying Spaghetti Monster", 75,  10,  10, 10, 10, 1, 15, 20, 40, new ImageIcon("res/monsters/Spaghetti.png"));
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

}
