package model.spell;

import model.entity.Entity;
import model.entity.monster.Monster;
import model.entity.player.Player;

public class StealSpell extends Spell {

    public final int gold;

    // TODO: Make overloaded constructor for items
    public StealSpell(String name, int MP, int gold) {
        super(name, MP);
        this.gold = gold;
    }

    @Override
    public void cast(Entity caster) {
        if (caster.getMP() >= MP) {
            caster.setMP(caster.getMP() - MP);
            if (caster instanceof Monster monster) {
                Player player = monster.getPlayer();
                if (player.getGold() > gold) {
                    player.setGold(monster.getPlayer().getGold() - gold);
                } else {
                    player.setGold(0);
                }
            } else if (caster instanceof Player player) {
                player.setGold(player.getGold() + gold);
            }
        }
    }

    @Override
    public void cast(Entity caster, Entity target) {
        // Can maybe steal an item with this overload

    }
}
