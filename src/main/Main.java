package main;

import util.SoundEffects;
import view.frames.MainGameFrame;

public class Main {

	public Main () {

	}
	public static MainGameFrame gameFrame;

	public static void main(String[] args) {

		SoundEffects.playThemeMusic();
		gameFrame = new MainGameFrame();

	}

}
