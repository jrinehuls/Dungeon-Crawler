package model.tileobject;

import tiles.TileManager;
import util.SoundEffects;

public class AscendingStaircase extends InteractableTileObject {

    static SoundEffects se;

    public AscendingStaircase(String iconPath, String backgroundFileName) {
        super(iconPath, backgroundFileName);
        se = new SoundEffects();
    }

    public static void goUpstairs() {
        se.playSE(SoundEffects.STAIRS);
        TileManager.updateFloorPlan(true);
    }

}
