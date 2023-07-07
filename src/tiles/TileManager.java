package tiles;

import collections.floor.FloorCollection;
import view.panels.game.MapPanel;

import java.awt.*;

public class TileManager {

    private static final int tileWidth = MapPanel.GRID_SIZE;
    private static final int tileHeight = MapPanel.GRID_SIZE;

    private static Tile[][] floorPlan = FloorCollection.getFloor().getFloorPlan();

    public TileManager() {

    }

    public static void drawTiles(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        int numRows = floorPlan.length;
        int numCols = floorPlan[0].length;
        //x & y top left corner of grid map.
        int x = 0;
        int y = 0;
        // Counter for the loops
        int i = 0;
        int j = 0;
        int gridWidth = tileWidth * numCols;
        int gridHeight = tileHeight * numRows;
        int iconSize = 16;
        int iconPadding = (tileWidth - iconSize + 1) / 2;


        while (y < gridHeight) {
            // start at row 0 col 0. get the value from the grid to use as index of the type of tile.
            // for each side that tile type has, draw it using the coordinates. Move to the right
            // by the width of the tile to draw the next one. get the next value in the row of the grid table.
            while(x < gridWidth) {
                if (floorPlan[i][j].isTop()) {
                    //x1, y1, x2, y2
                    g2d.drawLine(x, y, x + tileWidth, y);
                }
                if (floorPlan[i][j].isBottom()) {
                    g2d.drawLine(x, y + tileHeight, x + tileWidth, y + tileHeight);
                }
                if (floorPlan[i][j].isLeft()) {
                    g2d.drawLine(x, y, x, y + tileHeight);
                }
                if (floorPlan[i][j].isRight()) {
                    g2d.drawLine(x + tileWidth, y, x + tileWidth, y + tileHeight);
                }
                if (floorPlan[i][j].getTileObject() != null) {
                    g2d.drawImage(floorPlan[i][j].getTileObject().getIconImage(), x+iconPadding, y+iconPadding, iconSize, iconSize, null);
                }
                /* To set color for tiles before being seen
                if (!floorPlan[i][j].isVisited()) {
                    g2d.setColor(Color.BLACK);
                    g2d.fillRect(x,y,tileWidth,tileHeight);
                }
                */
                x += tileWidth;
                j++;
            }
            // move to the next row.
            x = 0;
            y += tileHeight;
            j=0;
            i++;
        }
    }

    public static Tile[][] getFloorPlan() {
        return floorPlan;
    }

    public static void updateFloorPlan(boolean goingUp) {
        if (goingUp) {
            FloorCollection.currentFloorNumber--;
        } else {
            FloorCollection.currentFloorNumber++;
        }
        TileManager.floorPlan = FloorCollection.getFloor().getFloorPlan();
    }
}

