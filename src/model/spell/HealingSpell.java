package model.spell;

import model.Entity;

public class HealingSpell extends Spell {

    public final int health = 20;

    public HealingSpell(String name, int mp) {
        super(name, mp);
    }

    @Override
    public void cast (Entity entity) {
        entity.setHP(entity.getHP() + health);
    }

}
