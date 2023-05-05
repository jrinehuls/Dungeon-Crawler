package collections;

import model.entity.monster.Karen;
import model.entity.monster.Monster;
import model.entity.monster.Spaghetti;

public class MonsterCollection {

    // TODO: Add all monsters to this array
    private final Monster[] monsters = new Monster[2];

    //TODO: Possibly have monster array in floor class, then have 2D array of [floor][monster] here
    public MonsterCollection() {
        monsters[0] = new Karen();
        monsters[1] = new Spaghetti();

    }

    // TODO: Set conditions for all monsters
    public Monster getMonster() {
        double randomNumber = Math.random();
        System.out.println(randomNumber);
        if (randomNumber < 0.50) {
            return monsters[0];
        } else if (randomNumber < 0.80) {
            return monsters[1];
        }
        else return null;
    }
}
