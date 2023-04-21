package tiles;

import panels.MapPanel;

import java.awt.*;

public class TileManager {

    private static final int tileWidth = MapPanel.GRID_SIZE;
    private static final int tileHeight = MapPanel.GRID_SIZE;

    private static final int[][] TILE_GRID = {
            {8, 1, 1, 9, 9, 9, 9, 9, 9, 5},
            {4, 3, 6, 8, 9, 9, 9, 1, 14, 10},
            {4, 1, 5, 10, 8, 9, 1, 6, 12, 2},
            {11, 10, 7, 2, 10, 12, 3, 1, 14, 10},
            {8, 0, 5, 11, 4, 5, 8, 2, 8, 2},
            {4, 0, 0, 9, 3, 2, 10, 11, 4, 6},
            {10, 7, 6, 8, 14, 10, 7, 5, 7, 5},
            {7, 9, 1, 6, 12, 3, 5, 4, 5, 10},
            {8, 14, 4, 1, 1, 1, 2, 4, 6, 10},
            {7, 9, 3, 6, 7, 3, 3, 6, 12, 6}};

    private static final Tile[] tileTypes = {
            new Tile(false, false, false, false),
            new Tile(true, false, false, false),
            new Tile(false, false, false, true),
            new Tile(false, true, false, false),
            new Tile(false, false, true, false),
            new Tile(true, false, false, true),
            new Tile(false, true, false, true),
            new Tile(false, true, true, false),
            new Tile(true, false, true, false),
            new Tile(true, true, false, false),
            new Tile(false, false, true, true),
            new Tile(false, true, true, true),
            new Tile(true, true, true, false),
            new Tile(true, false, true, true),
            new Tile(true, true, false, true),
            new Tile(true, true, true, true)
    };

    public static void drawTiles(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
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
                    g2d.drawLine(x, y, x + tileWidth, y);
                }
                if (tileTypes[TILE_GRID[i][j]].isBottom()) {
                    g2d.drawLine(x, y + tileHeight, x + tileWidth, y + tileHeight);
                }
                if (tileTypes[TILE_GRID[i][j]].isLeft()) {
                    g2d.drawLine(x, y, x, y + tileHeight);
                }
                if (tileTypes[TILE_GRID[i][j]].isRight()) {
                    g2d.drawLine(x + tileWidth, y, x + tileWidth, y + tileHeight);
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

    // return array of all tile types. use getTileTypes[index] for a specific type.
    // index should be TileManager.TILE_GRID[i][j].
    public static Tile[] getTileTypes() {
        return tileTypes;
    }

    public static int[][] getTileGrid() {
        return TILE_GRID;
    }

}

