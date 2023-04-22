package collections;

import model.monster.Karen;
import model.monster.Monster;
import model.monster.Spaghetti;

public class MonsterCollection {

    // TODO: Add all monsters to this array
    private static final Monster[] monsters = {
            new Karen(),
            new Spaghetti()
    };

    private static double randomNumber = 1.0;

    // TODO: Set conditions for all monsters
    public static Monster getMonster() {
        randomNumber = Math.random();
        System.out.println("MonsterCollections: " + randomNumber);
        if (randomNumber >= 0.0 && randomNumber < 0.33) {
            return monsters[0];
        } else if (randomNumber >= 0.33 && randomNumber < 0.67) {
            return monsters[1];
        }
        else return null;
    }
}
