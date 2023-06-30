package model.tileobject;

import tiles.TileManager;

public class AscendingStaircase extends InteractableTileObject implements Ascendable{


    public AscendingStaircase(String iconPath, String backgroundFileName) {
        super(iconPath, backgroundFileName);
    }

    @Override
    public void goUpstairs() {

    }
}
