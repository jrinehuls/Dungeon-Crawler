package model.monster;

import model.Entity;
import model.player.Player;
import model.spell.HealingSpell;
import model.spell.Spell;
import view.panels.PlayerPanel;

import javax.swing.*;
import java.util.HashMap;

public abstract class Monster extends Entity implements MonsterActions {

    protected String name;
    protected ImageIcon icon;
    public HashMap<String, Spell> spells = new HashMap<>();
    Player player;

    public Monster(String name, int HP, int maxHP, int MP, int maxMP, int attack, int defense, int magicAttack, int magicDefense, int speed, ImageIcon icon) {
        super(HP, maxHP, MP, maxMP, attack, defense, magicAttack, magicDefense, speed);
        this.icon = icon;
        this.name = name;
        player = PlayerPanel.getPlayer();
    }

    @Override
    public void attack() {
        player.setHP(player.getHP() - (attack/player.getDefense() + 10));
        System.out.println("Monster attacked!");
    }

    @Override
    public void castHealingSpell(HealingSpell spell) {
        spell.cast(this);
    }



    public String  getName() {
        return name;
    }

    public ImageIcon getIcon() {
        return icon;
    }

}
