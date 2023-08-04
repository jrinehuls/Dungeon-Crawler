package model.tileobject;

import tiles.TileManager;
import util.SoundEffects;

public class DescendingStaircase extends InteractableTileObject {

    static SoundEffects se;

    public DescendingStaircase(String iconPath, String backgroundFileName) {
        super(iconPath, backgroundFileName);
        se = new SoundEffects();
    }

    public static void goDownstairs() {
        se.playSE(SoundEffects.STAIRS);
        TileManager.updateFloorPlan(false);
    }
}
