package model.spell;

public abstract class Spell implements SpellAction{

    public final String NAME;
    public final int MP;

    public Spell (String name, int MP) {
        this.NAME = name;
        this.MP = MP;
    }


}
