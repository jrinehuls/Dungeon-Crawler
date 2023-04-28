package model.spell;

import model.Entity;

public interface SpellAction {
    public void cast(Entity entity);

    public void cast(Entity user, Entity enemy);
}
