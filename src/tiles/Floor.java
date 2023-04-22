package tiles;

public class Floor {
    final int ROWS = 10;
    final int COLUMNS = 10;
    private int[][] floorPlan = new int[ROWS][COLUMNS];

    private boolean[][] locationVisited = new boolean[ROWS][COLUMNS];

    public Floor(int[][] floorPlan) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                this.floorPlan[i][j] = floorPlan[i][j];
            }
        }
    }

    public int[][] getFloorPlan() {
        return floorPlan;
    }

    public void setVisited(int row, int column) {
        this.locationVisited[row][column] = true;
    }
}
