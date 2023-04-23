package model.monster;

import model.Entity;
import model.player.Player;
import view.panels.GamePanel;
import view.panels.MonsterPanel;
import view.panels.PlayerPanel;

import javax.swing.*;

public abstract class Monster extends Entity implements MonsterActions {

    protected String name;
    protected ImageIcon icon;
    Player player;

    public Monster(String name, int HP, int maxHP, int MP, int maxMP, int attack, int defense, int magicAttack, int magicDefense, int speed, ImageIcon icon) {
        super(HP, maxHP, MP, maxMP, attack, defense, magicAttack, magicDefense, speed);
        this.icon = icon;
        this.name = name;
        player = PlayerPanel.getPlayer();
    }

    public String  getName() {
        return name;
    }

    public ImageIcon getIcon() {
        return icon;
    }

}
