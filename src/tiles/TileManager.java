package tiles;

import collections.floor.FloorCollection;
import view.panels.game.MapPanel;

import java.awt.*;

public class TileManager {

    private static final int tileWidth = MapPanel.GRID_SIZE;
    private static final int tileHeight = MapPanel.GRID_SIZE;

    private static Tile[][] floorPlan = FloorCollection.getFloor(1).getFloorPlan();

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
                if (floorPlan[i][j].getImage() != null) {
                    g2d.drawImage(floorPlan[i][j].getImage(), x+iconPadding, y+iconPadding, iconSize, iconSize, null);
                }
                /*
                if (floorPlan[i][j].isVisited()) {
                    g2d.setColor(Color.ORANGE);
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

    // return array of all tile types. use getTileTypes[index] for a specific type.
    // index should be TileManager.getFloorPlan[i][j].
    /*
    public static Tile[] getTileTypes() {
        return tileTypes;
    }
    */

    public static Tile[][] getFloorPlan() {
        return floorPlan;
    }

    public static void setFloorPlan(int floorNumber) {
        TileManager.floorPlan = FloorCollection.getFloor(floorNumber).getFloorPlan();
    }
}

