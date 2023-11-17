package model.inn;

public abstract class Room {

    private int cost;
    private double hpRate;
    private double mpRate;

    public Room(int cost, double hpRate, double mpRate) {
        this.cost = cost;
        this.hpRate = hpRate;
        this.mpRate = mpRate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public double getHpRate() {
        return hpRate;
    }

    public void setHpRate(double hpRate) {
        this.hpRate = hpRate;
    }

    public double getMpRate() {
        return mpRate;
    }

    public void setMpRate(double mpRate) {
        this.mpRate = mpRate;
    }
}
