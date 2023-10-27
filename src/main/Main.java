package main;

import util.SoundEffects;
import view.frames.BuyFrame;
import view.frames.MainGameFrame;
import view.frames.MenuFrame;

public class Main {

	public static MainGameFrame gameFrame;
	public static MenuFrame menuFrame;

	public Main () {

	}

	public static void main(String[] args) {

		// gameFrame = new MainGameFrame();
		// SoundEffects.playThemeMusic();
		menuFrame = new MenuFrame();
		// new BuyFrame();

	}

}
