package collections.monster;

import collections.floor.FloorCollection;
import model.entity.monster.*;
import tiles.Floor;
import view.panels.game.DisplayPanel;



public class MonsterCollection {
    
    private final Monster ELDER = new Elder();
    private final Monster FLATWOODS = new Flatwoods();
    private final Monster FROGMAN = new Frogman();
    private final Monster KAREN = new Karen();
    private final Monster METALMAN = new Metalman();
    private final Monster MOTHMAN = new Mothman();
    private final Monster NIGHTCRAWLER = new Nightcrawler();
    private final Monster SHOGGOTH = new Shoggoth();
    private final Monster SPAGHETTI = new Spaghetti();

    // TODO: Add all monsters to these arrays
    private Monster[] floor1Monsters = { KAREN };
    private Monster[] floor2Monsters = { SPAGHETTI, FROGMAN, MOTHMAN, SHOGGOTH, ELDER, FLATWOODS, METALMAN, NIGHTCRAWLER };
    private Monster[][] allMonsters = {floor1Monsters, floor2Monsters};

    private Floor floor;

    //TODO: Possibly have 2D array of monsters here where index is associated to floorCollection.currentFloorNumber
    public MonsterCollection() {

        floor = FloorCollection.getFloor();
        floor.setMonsters(allMonsters[FloorCollection.currentFloorNumber - 1]);

    }

    // TODO: Set conditions for all monsters
    public Monster getMonster() {
        double randomNumber = Math.random();
        Monster monster = null;
        DisplayPanel.appendConsoleModel(String.valueOf(randomNumber));
        double bound;
        double chanceNull = 0.50;
        /* Decide which monster. Say chanceNull = 0.50. If randomNumber is > 0.50, no monster appears.
        if <= 50%, The monster at an index is picked based on randomNumber. If 5 monsters on floor,
        0 picked if <= 0.10, 1 picked if <= 0.20, 4 picked if <= 0.50 */
        for (int i = 0; i < floor.getMonsters().length; i++) {
            bound = (i + 1.0) / (floor.getMonsters().length / chanceNull);
            if (randomNumber <= bound) {
                monster = floor.getMonsters()[i];
                break;
            }
        }
        if (monster != null) {
            DisplayPanel.appendConsoleModel("A wild " + monster + " appeared!");
        }
        return monster;
    }
}

        // Display which monster appeared
        /*
        if (randomNumber < 0.20) {
            monster = floor.getMonsters()[0];
        } else if (randomNumber < 0.40) {
            monster = floor.getMonsters()[1];
        } else {
            monster = null;
        }*/