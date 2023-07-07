package model.tileobject;

import collections.floor.FloorCollection;
import tiles.TileManager;

public class DescendingStaircase extends InteractableTileObject {

    public DescendingStaircase(String iconPath, String backgroundFileName) {
        super(iconPath, backgroundFileName);
    }

    public static void goDownstairs() {
        TileManager.updateFloorPlan(false);
    }
}
