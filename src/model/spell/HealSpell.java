package model.spell;

import model.entity.Entity;

public class HealSpell extends Spell {

    public final int HEALTH;

    public HealSpell(String name, int mp, int health) {
        super(name, mp);
        this.HEALTH = health;
    }

    public void heal(Entity caster) {
        if (caster.getMP() >= MP) {
            caster.setMP(caster.getMP() - MP);
            if (caster.getMaxHP() - caster.getHP() <= HEALTH) {
                caster.setHP(caster.getMaxHP());
            } else {
                caster.setHP(caster.getHP() + HEALTH);
            }
        }
        // Maybe add: else { setProgress(100); }
    }


}
