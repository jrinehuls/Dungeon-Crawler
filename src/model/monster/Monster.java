package model.monster;

import model.Entity;

import javax.swing.*;

public abstract class Monster extends Entity {

    protected ImageIcon icon;

    public Monster(int hp, int maxHP, int attack, int defense, int speed, ImageIcon icon) {
        super(hp, maxHP, attack, defense, speed);
        this.icon = icon;

    }
    public ImageIcon getIcon() {
        return icon;
    }


}
