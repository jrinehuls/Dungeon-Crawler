package model.spell;

import model.entity.Entity;

public class HealSpell extends Spell {

    public final int health;

    public HealSpell(String name, int MP, int health) {
        super(name, MP);
        this.health = health;
    }

    @Override
    public void cast(Entity caster) {
        if (caster.getMP() >= MP) {
            caster.setMP(caster.getMP() - MP);
            if (caster.getMaxHP() - caster.getHP() <= health) {
                caster.setHP(caster.getMaxHP());
            } else {
                caster.setHP(caster.getHP() + health);
            }
        }
    }

    @Override
    public void cast(Entity caster, Entity target) {
        // Don't use
    }

}
