package model.spell;

import model.entity.Entity;
import model.entity.monster.Monster;
import model.entity.player.Player;
import view.panels.game.DisplayPanel;
import view.panels.game.MonsterPanel;
import view.panels.game.PlayerPanel;

public class StealGoldSpell extends StealSpell{

    int gold;

    public StealGoldSpell(String name, int mp, int gold) {
        super(name, mp);
        this.gold = gold;
    }

    public void stealGold(Entity caster) {
        if (caster.getMP() >= MP) {
            caster.setMP(caster.getMP() - MP);
            // If caster is monster, try to steal player's gold.
            if (caster instanceof Monster monster) {
                Player player = PlayerPanel.getPlayer();
                double stealChance = Math.pow((double) monster.getSpeed() / (double) player.getSpeed(), 2);
                if (stealChance > Math.random()) {
                    if (player.getGold() > this.gold) {
                        player.setGold(player.getGold() - this.gold);
                    } else {
                        player.setGold(0);
                    }
                } else {
                    DisplayPanel.appendConsoleModel(monster.getName() + " failed to steal gold.");
                }
                // If caster is player, try to steal monster's gold.
            } else if (caster instanceof Player player) {
                Monster monster = MonsterPanel.getMonster();
                double stealChance = Math.pow((double) player.getSpeed() / (double) monster.getSpeed(), 2);
                if (stealChance > Math.random()) {
                    player.setGold(player.getGold() + this.gold);
                } else {
                    DisplayPanel.appendConsoleModel("You failed to steal gold.");
                }
            }
        }
    }
}
