package tiles;

import javax.swing.*;
import java.awt.*;

public class TileManager {

    private Tile[] tileTypes;
    private int[][] tileGrid;
    private int tileWidth;
    private int tileHeight;
    BackgroundImages bgi = new BackgroundImages();

    private final int[][] TILE_GRID = {{8, 1, 1, 9, 9, 9, 9, 9, 9, 5},
            {4, 3, 6, 8, 9, 9, 9, 1, 14, 10},
            {4, 1, 5, 10, 8, 9, 1, 6, 12, 2},
            {11, 10, 7, 2, 10, 12, 3, 1, 14, 10},
            {8, 0, 5, 11, 4, 5, 8, 2, 8, 2},
            {4, 0, 0, 9, 3, 2, 10, 11, 4, 6},
            {10, 7, 6, 8, 14, 10, 7, 5, 7, 5},
            {7, 9, 1, 6, 12, 3, 5, 4, 5, 10},
            {8, 14, 4, 1, 1, 1, 2, 4, 6, 10},
            {7, 9, 3, 6, 7, 3, 3, 6, 12, 6}};

    public TileManager(int tileWidth, int tileHeight) {
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;

        tileTypes = new Tile[16];

        //empty
        tileTypes[0] = new Tile(false, false, false, false);
        //top
        tileTypes[1] = new Tile(true, false, false, false);
        //right
        tileTypes[2] = new Tile(false, false, false, true);
        //bottom
        tileTypes[3] = new Tile(false, true, false, false);
        //left
        tileTypes[4] = new Tile(false, false, true, false);
        //top & right
        tileTypes[5] = new Tile(true, false, false, true);
        //right & bottom
        tileTypes[6] = new Tile(false, true, false, true);
        //bottom & left
        tileTypes[7] = new Tile(false, true, true, false);
        //left & top
        tileTypes[8] = new Tile(true, false, true, false);
        //top & bottom
        tileTypes[9] = new Tile(true, true, false, false);
        //left & right
        tileTypes[10] = new Tile(false, false, true, true);
        //not top
        tileTypes[11] = new Tile(false, true, true, true);
        //not right
        tileTypes[12] = new Tile(true, true, true, false);
        //not bottom
        tileTypes[13] = new Tile(true, false, true, true);
        //not left
        tileTypes[14] = new Tile(true, true, false, true);
        //filled
        tileTypes[15] = new Tile(true, true, true, true);
    }
    // return array of all tile types. use getTileTypes[index] for a specific type.
    // index should be TileManager.TILE_GRID[i][j].
    public Tile[] getTileTypes() {
        return tileTypes;
    }

    public int[][] getTileGrid() {
        return TILE_GRID;
    }

    public void drawTiles(Graphics g) {
        g.setColor(Color.BLACK);
        int numRows = TILE_GRID.length;
        int numCols = TILE_GRID[0].length;
        //x & y top left corner of grid map.
        int x = 0;
        int y = 0;
        // Counter for the loops
        int i = 0;
        int j = 0;
        int gridWidth = tileWidth * numCols;
        int gridHeight = tileHeight * numRows;

        while (y < gridHeight) {
            // start at row 0 col 0. get the value from the grid to use as index of the type of tile.
            // for each side that tile type has, draw it using the coordinates. Move to the right
            // by the width of the tile to draw the next one. get the next value in the row of the grid table.
            while(x < gridWidth) {
                if (tileTypes[TILE_GRID[i][j]].isTop()) {
                    //x1, y1, x2, y2
                    g.drawLine(x, y, x + tileWidth, y);
                }
                if (tileTypes[TILE_GRID[i][j]].isBottom()) {
                    g.drawLine(x, y + tileHeight, x + tileWidth, y + tileHeight);
                }
                if (tileTypes[TILE_GRID[i][j]].isLeft()) {
                    g.drawLine(x, y, x, y + tileHeight);
                }
                if (tileTypes[TILE_GRID[i][j]].isRight()) {
                    g.drawLine(x + tileWidth, y, x + tileWidth, y + tileHeight);
                }
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

    //Selects the appropriate bg Image. See bgImageTable.txt
    public ImageIcon getBackgroundImage(int tileType, char facing) {
        facing = String.valueOf(facing).toUpperCase().charAt(0);
        if (facing == 'U' && (tileType == 0 || tileType == 3) || facing == 'D' && (tileType == 0 || tileType == 1) ||
                facing == 'L' && (tileType == 0 || tileType == 2) || facing == 'R' && (tileType == 0 || tileType == 4)) {
            return bgi.getBackgroundImage(0);
        }
        else if (facing == 'U' && (tileType == 1 || tileType == 9) || facing =='D'  && (tileType == 3 || tileType == 9)
                || facing == 'L' && (tileType == 4 || tileType == 10) || facing == 'R' && (tileType == 2 || tileType == 10)) {
            return bgi.getBackgroundImage(1);
        }
        else if (facing == 'U' && (tileType == 4 || tileType == 7) || facing =='D'  && (tileType == 2 || tileType == 5)
                || facing == 'L' && (tileType == 3 || tileType == 6) || facing == 'R' && (tileType == 1 || tileType == 8)) {
            return  bgi.getBackgroundImage(2);
        }
        else if (facing == 'U' && (tileType == 2 || tileType == 6) || facing =='D'  && (tileType == 4 || tileType == 8)
                || facing == 'L' && (tileType == 1 || tileType == 5) || facing == 'R' && (tileType == 3 || tileType == 7)) {
            return  bgi.getBackgroundImage(3);
        }
        else if (facing == 'U' && (tileType == 10 || tileType == 11) || facing =='D'  && (tileType == 10 || tileType == 13)
                || facing == 'L' && (tileType == 9 || tileType == 14) || facing == 'R' && (tileType == 9 || tileType == 12)) {
            return  bgi.getBackgroundImage(4);
        }
        else if (facing == 'U' && (tileType == 5 || tileType == 14) || facing =='D'  && (tileType == 7 || tileType == 12)
                || facing == 'L' && (tileType == 8 || tileType == 13) || facing == 'R' && (tileType == 6 || tileType == 11)) {
            return  bgi.getBackgroundImage(5);
        }
        else if (facing == 'U' && (tileType == 8 || tileType == 12) || facing =='D'  && (tileType == 6 || tileType == 14)
                || facing == 'L' && (tileType == 7 || tileType == 11) || facing == 'R' && (tileType == 5 || tileType == 13)) {
            return  bgi.getBackgroundImage(6);
        }
        else {
            return bgi.getBackgroundImage(7);
        }
    }


}

