package main;

import view.frames.BuyFrame;
import view.frames.MainGameFrame;
import view.frames.MenuFrame;

public class Main {

	private static MenuFrame menuFrame;
	private static BuyFrame buyFrame;
	private static final MainGameFrame gameFrame = new MainGameFrame();

	public Main () {

	}

	public static void main(String[] args) {
		menuFrame = new MenuFrame();
	}

	public static BuyFrame getBuyFrame() {
		return Main.buyFrame;
	}

	public static void setBuyFrame(BuyFrame buyFrame) {
		Main.buyFrame = buyFrame;
	}

	public static MenuFrame getMenuFrame() {
		return Main.menuFrame;
	}

	public static void setMenuFrame(MenuFrame menuFrame) {
		Main.menuFrame = menuFrame;
	}

	public static MainGameFrame getMainGameFrame() {
		return Main.gameFrame;
	}

}
