package main;

import view.frames.MenuFrame;
import view.frames.BuyFrame;
import view.frames.SellFrame;
import view.frames.MainGameFrame;

public class Main {

	private static MenuFrame menuFrame;
	private static BuyFrame buyFrame;
	private static SellFrame sellFrame;
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

	public static SellFrame getSellFrame() {
		return Main.sellFrame;
	}

	public static void setSellFrame(SellFrame sellFrame) {
		Main.sellFrame = sellFrame;
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
