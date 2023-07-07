package controller.game;

import model.tileobject.AscendingStaircase;
import model.tileobject.DescendingStaircase;
import model.tileobject.Treasure;
import tiles.Tile;
import tiles.TileManager;
import view.panels.game.GamePanel;
import view.panels.game.MapPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanelController implements ActionListener {


    public GamePanelController() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == GamePanel.treasureButton) {
            Tile tile = TileManager.getFloorPlan()[MapPanel.getYCord()][MapPanel.getXCord()];
            Treasure treasure = (Treasure) tile.getTileObject();
            treasure.awardItem();
            tile.removeTileObject();
        } else if (e.getSource() == GamePanel.ascendButton) {
            AscendingStaircase.goUpstairs();
        } else if (e.getSource() == GamePanel.descendButton) {
            DescendingStaircase.goDownstairs();
        }

    }
}
