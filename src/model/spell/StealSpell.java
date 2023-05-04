package model.spell;

import model.entity.Entity;
import model.entity.monster.Monster;
import model.entity.player.Player;

public class StealSpell extends Spell {

    public final int gold;

    public StealSpell(String name, int mp, int gold) {
        super(name, mp);
        this.gold = gold;
    }

    @Override
    public void cast(Entity caster) {
        // Don't use
    }

    @Override
    public void cast(Entity caster, Entity target) {
        if (caster instanceof Monster && target instanceof Player) {
            Player player = (Player) target;
            player.setGold(player.getGold() - gold);
        } else if (caster instanceof Player && target instanceof Monster) {
            Player player = (Player) caster;
            player.setGold(player.getGold() + gold);
        }
    }
}
