package model.spell;

import model.entity.Entity;

public class HealSpell extends Spell {

    public final int health;

    public HealSpell(String name, int mp, int health) {
        super(name, mp);
        this.health = health;
    }

    @Override
    public void cast(Entity caster) {
        caster.setHP(caster.getHP() + health);
        caster.setMP(caster.getMP() - MP);
    }

    @Override
    public void cast(Entity caster, Entity target) {
        // Don't use
    }

}
