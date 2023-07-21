package model.spell;

import model.entity.Entity;
import model.entity.monster.Monster;
import model.entity.player.Player;
import model.item.Item;
import model.item.consumable.Consumable;
import model.item.equipment.Weapon;
import view.panels.game.DisplayPanel;
import view.panels.game.MonsterPanel;
import view.panels.game.PlayerPanel;

public abstract class StealSpell extends Spell {

    public StealSpell(String name, int mp) {
        super(name, mp);
    }



}
