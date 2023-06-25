package tiles;

public class Floor{

    private Tile[][] floorPlan;

    public Floor(Tile[][] floorPlan) {
        this.floorPlan = floorPlan;
    }

    public Tile[][] getFloorPlan() {
        return floorPlan;
    }

}
