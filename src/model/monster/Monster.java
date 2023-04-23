package model.monster;

import model.Entity;
import view.panels.MonsterPanel;

import javax.swing.*;

public abstract class Monster extends Entity implements MonsterActions {

    protected String name;
    protected ImageIcon icon;
    protected int progress;

    public Monster(String name, int hp, int maxHP, int attack, int defense, int speed, ImageIcon icon) {
        super(hp, maxHP, attack, defense, speed);
        this.icon = icon;
        this.name = name;
        this.progress = 0;

    }

    public String  getName() {
        return name;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int pprogress) {
        this.progress = pprogress;
    }

}
