package main;

import view.frames.*;

public class Main {

	private static MenuFrame menuFrame;
	private static InnFrame innFrame;
	private static BuyFrame buyFrame;
	private static SellFrame sellFrame;
	private static final MainGameFrame gameFrame = new MainGameFrame();

	public Main () {

	}

	public static void main(String[] args) {
		menuFrame = new MenuFrame();
	}


	public static MenuFrame getMenuFrame() {
		return Main.menuFrame;
	}

	public static void setMenuFrame(MenuFrame menuFrame) {
		Main.menuFrame = menuFrame;
	}

	public static InnFrame getInnFrame() {
		return Main.innFrame;
	}

	public static void setInnFrame(InnFrame innFrame) {
		Main.innFrame = innFrame;
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

	public static MainGameFrame getMainGameFrame() {
		return Main.gameFrame;
	}

}
