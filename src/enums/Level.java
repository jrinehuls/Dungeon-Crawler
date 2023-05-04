package enums;

public enum Level {

    LEVEL2(25, 20, 5, 3, 2, 1, 1, 2),
    LEVEL3(38, 12, 6, 4, 1, 2, 0, 1);

    public final int increaseNextExp;
    public final int increaseHP;
    public final int increaseMP;
    public final int increaseAttack;
    public final int increaseDefense;
    public final int increaseMAttack;
    public final int increaseMDefense;
    public final int increaseSpeed;

    Level(int increaseNextExp, int increaseHP, int increaseMP, int increaseAttack , int increaseDefense,
          int increaseMAttack, int increaseMDefense, int increaseSpeed) {

        this.increaseNextExp = increaseNextExp;
        this.increaseHP = increaseHP;
        this.increaseMP = increaseMP;
        this.increaseAttack = increaseAttack;
        this.increaseDefense = increaseDefense;
        this.increaseMAttack = increaseMAttack;
        this.increaseMDefense = increaseMDefense;
        this.increaseSpeed = increaseSpeed;
    }
}
