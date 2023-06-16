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
        Monster monster;
        DisplayPanel.appendConsoleModel(String.valueOf(randomNumber));
        // Decide which monster
        if (randomNumber < 0.30) { // 0.50
            monster = monsters[0];
        } else if (randomNumber < 0.70) { // 0.80
            monster = monsters[1];
        } else {
            monster = null;
        }
        // Display which monster appeared
        if (monster != null) {
            DisplayPanel.appendConsoleModel("A wild " + monster + " appeared!");
        }
        return monster;
    }
}
