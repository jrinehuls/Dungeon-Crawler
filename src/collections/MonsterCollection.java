package collections;

import model.monster.Karen;
import model.monster.Monster;
import model.monster.Spaghetti;

public class MonsterCollection {

    // TODO: Add all monsters to this array
    private Monster[] monsters = new Monster[2];

    private double randomNumber = 1.0;

    public MonsterCollection() {
        monsters[0] = new Karen();
        monsters[1] = new Spaghetti();

    }

    // TODO: Set conditions for all monsters
    public Monster getMonster() {
        randomNumber = Math.random();
        System.out.println(randomNumber);
        if (randomNumber < 0.50) {
            return monsters[0];
        } else if (randomNumber < 0.67) {
            return monsters[1];
        }
        else return null;
    }
}
