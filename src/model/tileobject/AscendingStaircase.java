package model.tileobject;

import tiles.TileManager;
import util.SoundEffects;

public class AscendingStaircase extends InteractableTileObject {

    static SoundEffects se;

    public AscendingStaircase() {
        super("/icons/Upstairs.png", "/backgrounds/Upstairs.png");
        se = new SoundEffects();
    }

    public static void goUpstairs() {
        se.playSE(SoundEffects.STAIRS);
        TileManager.updateFloorPlan(true);
    }

}
