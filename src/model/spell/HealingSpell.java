package model.spell;

import model.Entity;

public class HealingSpell extends Spell {

    public final int health;

    public HealingSpell(String name, int mp, int health) {
        super(name, mp);
        this.health = health;
    }

    @Override
    public void cast(Entity entity) {
        entity.setHP(entity.getHP() + health);
        entity.setMP(entity.getMP() - MP);
    }

    @Override
    public void cast(Entity user, Entity enemy) {
        // Don't use
    }

}
