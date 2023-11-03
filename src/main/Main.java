package main;

import view.frames.BuyFrame;
import view.frames.MainGameFrame;
import view.frames.MenuFrame;

public class Main {

	public static MenuFrame menuFrame;
	public static MainGameFrame gameFrame = new MainGameFrame();
	public static BuyFrame buyFrame;

	public Main () {

	}

	public static void main(String[] args) {

		menuFrame = new MenuFrame();

	}

}
