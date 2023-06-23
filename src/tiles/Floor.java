package tiles;

public class Floor {
    final int ROWS = 10;
    final int COLUMNS = 10;
    private int[][] floorPlan = new int[ROWS][COLUMNS];
    private ImageTile[][] imageTiles = new ImageTile[ROWS][COLUMNS];
    private boolean[][] locationVisited = new boolean[ROWS][COLUMNS];

    public Floor(int[][] floorPlan, ImageTile[][] imageTiles) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                this.floorPlan[i][j] = floorPlan[i][j];
            }
        }
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                this.imageTiles[i][j] = imageTiles[i][j];
            }
        }
    }

    public int[][] getFloorPlan() {
        return floorPlan;
    }

    public ImageTile[][] getImageTiles() {
        return imageTiles;
    }

    public void setVisited(int row, int column) {
        this.locationVisited[row][column] = true;
    }
}
