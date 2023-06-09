package model.spell;

public abstract class Spell {

    public final String NAME;
    public final int MP;

    public Spell (String name, int mp) {
        this.NAME = name;
        this.MP = mp;
    }


    @Override
    public String toString() {
        return this.NAME + " - MP: " + this.MP;
    }
}
