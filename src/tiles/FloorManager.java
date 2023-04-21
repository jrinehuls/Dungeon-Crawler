package tiles;

public class FloorManager {

    private static int[][] floor1 = {
            {8, 1, 1, 9, 9, 9, 9, 9, 9, 5},
            {4, 3, 6, 8, 9, 9, 9, 1, 14, 10},
            {4, 1, 5, 10, 8, 9, 1, 6, 12, 2},
            {11, 10, 7, 2, 10, 12, 3, 1, 14, 10},
            {8, 0, 5, 11, 4, 5, 8, 2, 8, 2},
            {4, 0, 0, 9, 3, 2, 10, 11, 4, 6},
            {10, 7, 6, 8, 14, 10, 7, 5, 7, 5},
            {7, 9, 1, 6, 12, 3, 5, 4, 5, 10},
            {8, 14, 4, 1, 1, 1, 2, 4, 6, 10},
            {7, 9, 3, 6, 7, 3, 3, 6, 12, 6}};

    private static Floor[] floors = {new Floor(floor1)};

    public static Floor getFloor(int floorNumber) {
        return floors[floorNumber - 1];
    }

}
