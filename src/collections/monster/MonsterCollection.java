package collections.monster;

import model.entity.monster.Karen;
import model.entity.monster.Monster;
import model.entity.monster.Spaghetti;
import view.panels.game.DisplayPanel;
import view.panels.game.GamePanel;

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
        DisplayPanel.appendConsoleModel(String.valueOf(randomNumber));
        if (randomNumber < 0.10) { // 0.50
            return monsters[0];
        } else if (randomNumber < 0.20) { // 0.80
            return monsters[1];
        }
        else return null;
    }
}
