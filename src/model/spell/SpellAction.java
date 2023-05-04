package model.spell;

import model.entity.Entity;

public interface SpellAction {
    public void cast(Entity caster);

    public void cast(Entity caster, Entity target);
}
