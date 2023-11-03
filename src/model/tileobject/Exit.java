package model.tileobject;

import main.Main;
import util.SoundEffects;
import view.frames.MenuFrame;

public class Exit extends InteractableTileObject {

    public Exit() {
        super("/icons/Exit.png", "/backgrounds/Exit.png");
    }

    public static void leaveDungeon() {
        SoundEffects.stopThemeMusic();
        Main.setMenuFrame(new MenuFrame());
        Main.getMainGameFrame().setVisible(false);
    }
}
