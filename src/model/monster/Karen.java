package model.monster;



import javax.swing.*;

public class Karen extends Monster{

    public Karen() {
        super("Karen", 100, 100, 10, 10, 15, new ImageIcon("src/res/monsters/Karen.png"));

    }

    @Override
    public void takeAction() {
        if (progress >= 100) {
            attack();
            progress = 0;
        }
    }

    @Override
    public void attack() {
        System.out.println("Now it's Karen time");
    }

}
