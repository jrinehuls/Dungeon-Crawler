package tiles;

import model.tileobject.InteractableTileObject;


public class Tile {

    private boolean top, bottom, left, right;
    private boolean[] tileWalls;
    private boolean visited;
    private InteractableTileObject tileObject = null;

    public Tile(boolean[] tileWalls) {
        this.top = tileWalls[0];
        this.bottom = tileWalls[1];
        this.left = tileWalls[2];
        this.right = tileWalls[3];
        this.tileWalls = tileWalls;
    }

    public Tile(boolean[] tileWalls, InteractableTileObject tileObject) {
        this.top = tileWalls[0];
        this.bottom = tileWalls[1];
        this.left = tileWalls[2];
        this.right = tileWalls[3];
        this.tileWalls = tileWalls;
        this.tileObject =tileObject;
    }

    public boolean isTop() {
        return top;
    }

    public boolean isBottom() {
        return bottom;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean[] getTileWalls() {
        return this.tileWalls;
    }

    public InteractableTileObject getTileObject () {
        return this.tileObject;
    }

    public void removeTileObject() {
        this.tileObject = null;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

}
