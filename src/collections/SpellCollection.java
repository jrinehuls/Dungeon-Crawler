package collections;

import model.spell.HealingSpell;
import model.spell.Spell;

import java.util.Map;

import static java.util.Map.entry;

public class SpellCollection {

    public static Map<String, Spell> spellMap = Map.ofEntries(
            entry("First Aid", new HealingSpell("First Aid", 5))
    );


}
