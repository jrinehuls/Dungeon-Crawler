package model.spell;

import model.Entity;

public class StealSpell extends Spell {

    public final int gold;

    public StealSpell(String name, int mp, int gold) {
        super(name, mp);
        this.gold = gold;
    }

    @Override
    public void cast(Entity entity) {
        
    }

    @Override
    public void cast(Entity user, Entity enemy) {

    }
}
