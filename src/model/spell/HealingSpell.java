package model.spell;

import model.entity.Entity;

public class HealingSpell extends Spell {

    public final int health;

    public HealingSpell(String name, int mp, int health) {
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
