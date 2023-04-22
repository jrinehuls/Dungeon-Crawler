package model.monster;

import model.Entity;

import javax.swing.*;

public abstract class Monster extends Entity {

    protected String name;
    protected ImageIcon icon;

    public Monster(String name, int hp, int maxHP, int attack, int defense, int speed, ImageIcon icon) {
        super(hp, maxHP, attack, defense, speed);
        this.icon = icon;
        this.name = name;
    }

    public String  getName() {
        return name;
    }

    public ImageIcon getIcon() {
        return icon;
    }


}
