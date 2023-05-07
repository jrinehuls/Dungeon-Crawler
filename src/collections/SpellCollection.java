package collections;

import model.spell.AttackSpell;
import model.spell.HealSpell;
import model.spell.Spell;
import model.spell.StealSpell;

import java.util.Map;

import static java.util.Map.entry;

public class SpellCollection {

    // TODO: Make these private. Entity gets from spellMap
    public static HealSpell firstAid = new HealSpell("First Aid", 5, 20);
    
    public static AttackSpell flare = new AttackSpell("Flare", 10, "Fire", 10);

    public static StealSpell callManager = new StealSpell("Call Manager", 2, 10);

    public static Map<String, Spell> spellMap = Map.ofEntries(
            entry("First Aid", firstAid),
            entry("Flare", flare),
            entry("Call Manager", callManager)
    );


}
