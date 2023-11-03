package controller;

import main.Main;
import util.SoundEffects;
import view.frames.BuyFrame;
import view.frames.GameOverFrame;
import view.frames.MainGameFrame;
import view.frames.MenuFrame;
import view.panels.game.MapPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {

    MenuFrame menuFrame;

    public MenuController (MenuFrame menuFrame) {
        this.menuFrame = menuFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuFrame.getInnPanel().getButton()) {
            goToInn();
        } else if (e.getSource() == menuFrame.getShopPanel().getButton()) {
            goToShop();
        } else if (e.getSource() == menuFrame.getDungeonPanel().getButton()) {
            goToDungeon();
        }
    }

    private void goToInn() {
        System.out.println("Go to inn!");
    }

    private void goToShop() {
        Main.getMenuFrame().dispose();
        Main.setBuyFrame(new BuyFrame());
    }

    private void goToDungeon() {
        Main.getMenuFrame().dispose();
        SoundEffects.playThemeMusic();
        Main.getMainGameFrame().setVisible(true);
    }

}
