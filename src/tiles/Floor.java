package tiles;

import model.entity.monster.Monster;

public class Floor{

    private Tile[][] floorPlan;
    private Monster[] monsters = null;

    public Floor(Tile[][] floorPlan) {
        this.floorPlan = floorPlan;
    }

    public Tile[][] getFloorPlan() {
        return this.floorPlan;
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    public void setMonsters(Monster[] monsters) {
        this.monsters = monsters;
    }
}
