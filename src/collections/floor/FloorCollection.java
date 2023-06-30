package collections.floor;

import collections.consumable.AttackItemCollection;
import model.tileobject.Treasure;
import tiles.Floor;
import tiles.Tile;

public class FloorCollection {

    /* Map of first floor
    {8, 1, 1, 9, 9, 9, 9, 9, 9, 5}
    {4, 3, 6, 8, 9, 9, 9, 1, 14, 10}
    {4, 1, 5, 10, 8, 9, 1, 6, 12, 2}
    {11, 10, 7, 2, 10, 12, 3, 1, 14, 10}
    {8, 0, 5, 11, 4, 5, 8, 2, 8, 2}
    {4, 0, 0, 9, 3, 2, 10, 11, 4, 6}
    {10, 7, 6, 8, 14, 10, 7, 5, 7, 5}
    {7, 9, 1, 6, 12, 3, 5, 4, 5, 10}
    {8, 14, 4, 1, 1, 1, 2, 4, 6, 10}
    {7, 9, 3, 6, 7, 3, 3, 6, 12, 6}
    */

    public static final Treasure bombTreasure = new Treasure("/icons/Treasure.png", "res/backgrounds/Treasure.png", AttackItemCollection.BOMB);

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
        { new Tile(tileWalls[4]), new Tile(tileWalls[1]), new Tile(tileWalls[5]), new Tile(tileWalls[10]), new Tile(tileWalls[8], bombTreasure),
            new Tile(tileWalls[9]), new Tile(tileWalls[1]), new Tile(tileWalls[6]), new Tile(tileWalls[12]), new Tile(tileWalls[2]) },
        { new Tile(tileWalls[11]), new Tile(tileWalls[10]), new Tile(tileWalls[7]), new Tile(tileWalls[2]), new Tile(tileWalls[10]),
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

    private static Floor[] floors = { new Floor(floor1) };

    public static Floor getFloor(int floorNumber) {
        return floors[floorNumber - 1];
    }

}
