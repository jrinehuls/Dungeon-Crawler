package collections.floor;

import collections.tileobject.TreasureCollection;
import model.entity.monster.Karen;
import model.entity.monster.Monster;
import model.entity.monster.Spaghetti;
import model.tileobject.AscendingStaircase;
import model.tileobject.DescendingStaircase;
import tiles.Floor;
import tiles.Tile;

public class FloorCollection {

    private static final DescendingStaircase downstairs = new DescendingStaircase("/icons/Downstairs.png", "res/backgrounds/Downstairs.png");
    private static final AscendingStaircase upstairs = new AscendingStaircase("/icons/Upstairs.png", "res/backgrounds/Upstairs.png");

    public static int currentFloorNumber = 1;

    public static final boolean[][] tileWalls = {
            { false, false, false, false },
            { true, false, false, false },
            { false, false, false, true },
            { false, true, false, false },
            { false, false, true, false },
            { true, false, false, true },
            { false, true, false, true },
            { false, true, true, false },
            { true, false, true, false },
            { true, true, false, false },
            { false, false, true, true },
            { false, true, true, true },
            { true, true, true, false },
            { true, false, true, true },
            { true, true, false, true },
            { true, true, true, true }
    };

    private static Tile[][] floor1 = {
        { new Tile(tileWalls[8]), new Tile(tileWalls[1]), new Tile(tileWalls[1]), new Tile(tileWalls[9]), new Tile(tileWalls[9]),
            new Tile(tileWalls[9]), new Tile(tileWalls[9]), new Tile(tileWalls[9]), new Tile(tileWalls[9]), new Tile(tileWalls[5]) },
        { new Tile(tileWalls[4]), new Tile(tileWalls[3]), new Tile(tileWalls[6]), new Tile(tileWalls[8]), new Tile(tileWalls[9]),
            new Tile(tileWalls[9]), new Tile(tileWalls[9]), new Tile(tileWalls[1]), new Tile(tileWalls[14]), new Tile(tileWalls[10]) },
        { new Tile(tileWalls[4]), new Tile(tileWalls[1]), new Tile(tileWalls[5]), new Tile(tileWalls[10]), new Tile(tileWalls[8], TreasureCollection.BOMB_TREASURE),
            new Tile(tileWalls[9]), new Tile(tileWalls[1]), new Tile(tileWalls[6]), new Tile(tileWalls[12]), new Tile(tileWalls[2]) },
        { new Tile(tileWalls[11]), new Tile(tileWalls[10]), new Tile(tileWalls[7]), new Tile(tileWalls[2]), new Tile(tileWalls[10], downstairs),
            new Tile(tileWalls[12]), new Tile(tileWalls[3]), new Tile(tileWalls[1]), new Tile(tileWalls[14]), new Tile(tileWalls[10]) },
        { new Tile(tileWalls[8]), new Tile(tileWalls[0]), new Tile(tileWalls[5]), new Tile(tileWalls[11]), new Tile(tileWalls[4]),
            new Tile(tileWalls[5]), new Tile(tileWalls[8]), new Tile(tileWalls[2]), new Tile(tileWalls[8]), new Tile(tileWalls[2]) },
        { new Tile(tileWalls[4]), new Tile(tileWalls[0]), new Tile(tileWalls[0]), new Tile(tileWalls[9]), new Tile(tileWalls[3]),
            new Tile(tileWalls[2]), new Tile(tileWalls[10]), new Tile(tileWalls[11]), new Tile(tileWalls[4]), new Tile(tileWalls[6]) },
        { new Tile(tileWalls[10]), new Tile(tileWalls[7]), new Tile(tileWalls[6]), new Tile(tileWalls[8]), new Tile(tileWalls[14]),
            new Tile(tileWalls[10]), new Tile(tileWalls[7]), new Tile(tileWalls[5]), new Tile(tileWalls[7]), new Tile(tileWalls[5]) },
        { new Tile(tileWalls[7]), new Tile(tileWalls[9]), new Tile(tileWalls[1]), new Tile(tileWalls[6]), new Tile(tileWalls[12]),
            new Tile(tileWalls[3]), new Tile(tileWalls[5]), new Tile(tileWalls[4]), new Tile(tileWalls[5]), new Tile(tileWalls[10]) },
        { new Tile(tileWalls[8]), new Tile(tileWalls[14]), new Tile(tileWalls[4]), new Tile(tileWalls[1]), new Tile(tileWalls[1]),
            new Tile(tileWalls[1]), new Tile(tileWalls[2]), new Tile(tileWalls[4]), new Tile(tileWalls[6]), new Tile(tileWalls[10]) },
        { new Tile(tileWalls[7]), new Tile(tileWalls[9]), new Tile(tileWalls[3]), new Tile(tileWalls[6]), new Tile(tileWalls[7]),
            new Tile(tileWalls[3]), new Tile(tileWalls[3]), new Tile(tileWalls[6]), new Tile(tileWalls[12]), new Tile(tileWalls[6]) }
    };

    private static Tile[][] floor2 = {
            { new Tile(tileWalls[8]), new Tile(tileWalls[5]), new Tile(tileWalls[8]), new Tile(tileWalls[1]), new Tile(tileWalls[9]),
                    new Tile(tileWalls[9]), new Tile(tileWalls[1]), new Tile(tileWalls[5]), new Tile(tileWalls[13]), new Tile(tileWalls[13]) },
            { new Tile(tileWalls[11]), new Tile(tileWalls[10]), new Tile(tileWalls[4]), new Tile(tileWalls[2]), new Tile(tileWalls[8]),
                    new Tile(tileWalls[14]), new Tile(tileWalls[4]), new Tile(tileWalls[3]), new Tile(tileWalls[6]), new Tile(tileWalls[10]) },
            { new Tile(tileWalls[8]), new Tile(tileWalls[0]), new Tile(tileWalls[3]), new Tile(tileWalls[6]), new Tile(tileWalls[10]),
                    new Tile(tileWalls[8]), new Tile(tileWalls[2]), new Tile(tileWalls[8]), new Tile(tileWalls[1]), new Tile(tileWalls[2]) },
            { new Tile(tileWalls[10]), new Tile(tileWalls[10]), new Tile(tileWalls[12]), new Tile(tileWalls[5]), new Tile(tileWalls[4], upstairs),
                    new Tile(tileWalls[2]), new Tile(tileWalls[10]), new Tile(tileWalls[4]), new Tile(tileWalls[2]), new Tile(tileWalls[10]) },
            { new Tile(tileWalls[10]), new Tile(tileWalls[4]), new Tile(tileWalls[1]), new Tile(tileWalls[6]), new Tile(tileWalls[7]),
                    new Tile(tileWalls[2]), new Tile(tileWalls[10]), new Tile(tileWalls[4]), new Tile(tileWalls[2]), new Tile(tileWalls[11]) },
            { new Tile(tileWalls[10]), new Tile(tileWalls[4]), new Tile(tileWalls[2]), new Tile(tileWalls[8]), new Tile(tileWalls[5]),
                    new Tile(tileWalls[10]), new Tile(tileWalls[11]), new Tile(tileWalls[4]), new Tile(tileWalls[0]), new Tile(tileWalls[5]) },
            { new Tile(tileWalls[10]), new Tile(tileWalls[7]), new Tile(tileWalls[0]), new Tile(tileWalls[0]), new Tile(tileWalls[0]),
                    new Tile(tileWalls[3]), new Tile(tileWalls[9]), new Tile(tileWalls[0]), new Tile(tileWalls[0]), new Tile(tileWalls[2]) },
            { new Tile(tileWalls[4]), new Tile(tileWalls[9]), new Tile(tileWalls[3]), new Tile(tileWalls[2]), new Tile(tileWalls[4]),
                    new Tile(tileWalls[9]), new Tile(tileWalls[14]), new Tile(tileWalls[10]), new Tile(tileWalls[4]), new Tile(tileWalls[6]) },
            { new Tile(tileWalls[10]), new Tile(tileWalls[8]), new Tile(tileWalls[5]), new Tile(tileWalls[10]), new Tile(tileWalls[10]),
                    new Tile(tileWalls[12]), new Tile(tileWalls[9]), new Tile(tileWalls[2]), new Tile(tileWalls[10]), new Tile(tileWalls[8]) },
            { new Tile(tileWalls[7]), new Tile(tileWalls[3]), new Tile(tileWalls[6]), new Tile(tileWalls[7]), new Tile(tileWalls[3]),
                    new Tile(tileWalls[9]), new Tile(tileWalls[9]), new Tile(tileWalls[6]), new Tile(tileWalls[7]), new Tile(tileWalls[6]) }
    };


    private static Floor[] floors = { new Floor(floor1), new Floor(floor2) };

    public static Floor getFloor() {
        return floors[currentFloorNumber - 1];
    }


}
