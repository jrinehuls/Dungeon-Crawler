package model.entity;

public abstract class Entity {

    protected int HP;
    protected int maxHP;
    protected int MP;
    protected int maxMP;
    protected int attack;
    protected int defense;
    protected int magicAttack;
    protected int magicDefense;
    protected int speed;
    protected double progress;

    public Entity(int HP, int maxHP, int MP, int maxMP, int attack, int defense, int magicAttack, int magicDefense, int speed) {
        this.HP = HP;
        this.maxHP = maxHP;
        this.MP = MP;
        this.maxMP = maxMP;
        this.attack = attack;
        this.defense = defense;
        this.magicAttack = magicAttack;
        this.magicDefense = magicDefense;
        this.speed = speed;
        this.progress = 0;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMagicAttack() {
        return magicAttack;
    }

    public void setMagicAttack(int magicAttack) {
        this.magicAttack = magicAttack;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    public void setMagicDefense(int magicDefense) {
        this.magicDefense = magicDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}
