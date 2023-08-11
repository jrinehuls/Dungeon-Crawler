package collections.spell;

import model.spell.AttackSpell;

public class AttackSpellCollection {

    public final static AttackSpell SPRITZ = new AttackSpell("Spritz", 6, "Water", 7);
    public final static AttackSpell DOUSE = new AttackSpell("Douse", 15, "Water", 18);

    public final static AttackSpell BREEZE = new AttackSpell("Breeze", 5, "Wind", 6);
    public final static AttackSpell GALE = new AttackSpell("Gale", 25, "Wind", 35);

    public final static AttackSpell FLARE = new AttackSpell("Flare", 10, "Fire", 10);
    public final static AttackSpell INCINERATE = new AttackSpell("Incinerate", 22, "Fire", 28);

    public final static AttackSpell STALAGMITE = new AttackSpell("Stalagmite", 12, "Earth", 15);
    public final static AttackSpell FISSURE = new AttackSpell("Fissure", 24, "Earth", 32);

}
