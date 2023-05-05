package model.spell;

import model.entity.Entity;
import model.entity.monster.Monster;
import model.entity.player.Player;

public class StealGoldSpell extends Spell {

    public final int gold;

    // TODO: Make and implement interface with methods for gold and item, if it's a good idea.
    public StealGoldSpell(String name, int mp, int gold) {
        super(name, mp);
        this.gold = gold;
    }

    @Override
    public void cast(Entity caster) {
        if (caster instanceof Monster monster){
            monster.getPlayer().setGold(monster.getPlayer().getGold() - gold);
        } else if (caster instanceof Player player) {
            player.setGold(player.getGold() + gold);
        }
    }

    @Override
    public void cast(Entity caster, Entity target) {
        // Can maybe steal an item with this overload
    }
}
