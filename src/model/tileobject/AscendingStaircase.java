package model.tileobject;

import tiles.TileManager;

public class AscendingStaircase extends InteractableTileObject {

    public AscendingStaircase(String iconPath, String backgroundFileName) {
        super(iconPath, backgroundFileName);
    }

    public static void goUpstairs() {
        TileManager.updateFloorPlan(true);
    }

}
