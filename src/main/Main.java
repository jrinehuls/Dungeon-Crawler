package main;

import util.SoundEffects;
import view.frames.MainGameFrame;
import view.frames.MenuFrame;

public class Main {

	public static MainGameFrame gameFrame;

	public Main () {

	}

	public static void main(String[] args) {

		// SoundEffects.playThemeMusic();
		// gameFrame = new MainGameFrame();
		new MenuFrame();

	}

}
