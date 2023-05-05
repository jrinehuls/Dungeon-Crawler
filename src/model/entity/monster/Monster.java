package model.entity.monster;

import model.entity.Entity;
import model.entity.player.Player;
import model.spell.AttackSpell;
import model.spell.HealSpell;
import model.spell.StealGoldSpell;
import view.panels.GamePanel;
import view.panels.PlayerPanel;

import javax.swing.*;

public abstract class Monster extends Entity implements MonsterActions {

    protected String name;
    protected ImageIcon icon;
    //public HashMap<String, Spell> spells = new HashMap<>();
    Player player;

    public Monster(String name, int HP, int MP, int attack, int defense, int magicAttack, int magicDefense, int speed, ImageIcon icon) {
        super(HP, MP, attack, defense, magicAttack, magicDefense, speed);
        this.icon = icon;
        this.name = name;
        player = PlayerPanel.getPlayer();
    }

    @Override
    public void attack() {
        player.setHP(player.getHP() - (attack/player.getDefense() + 10));
        System.out.println(this.getName() + " attacked!");
    }

    @Override
    public void castHealSpell(HealSpell spell) {
        spell.cast(this);
        System.out.println(this.getName() + " casted " + spell.NAME);
    }

    @Override
    public void castAttackSpell(AttackSpell spell) {
        spell.cast(this, player);
    }

    @Override
    public void castStealSpell(StealGoldSpell spell) {
        spell.cast(this);
        System.out.println(this.getName() + " casted " + spell.NAME);
    }

    public String  getName() {
        return name;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public Player getPlayer() {
        return player;
    }

}
