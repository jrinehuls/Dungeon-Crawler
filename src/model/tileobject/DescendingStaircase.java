package model.tileobject;

import tiles.TileManager;
import util.SoundEffects;

public class DescendingStaircase extends InteractableTileObject {

    static SoundEffects se;

    public DescendingStaircase() {
        super("/icons/Downstairs.png", "/backgrounds/Downstairs.png");
        se = new SoundEffects();
    }

    public static void goDownstairs() {
        se.playSE(SoundEffects.STAIRS);
        TileManager.updateFloorPlan(false);
    }
}
