package model.spell;

import model.entity.Entity;

public class AttackSpell extends Spell{

    public final String TYPE;
    public final int POWER;

    public AttackSpell(String name, int MP, String type, int power) {
        super(name, MP);
        this.TYPE = type;
        this.POWER = power;
    }

    public void cast(Entity caster, Entity target) {
        if (caster.getMP() >= MP) {
            caster.setMP(caster.getMP() - MP);
            target.setHP(target.getHP() - ((this.POWER * caster.getMagicAttack() / target.getMagicDefense()) + 10));
        }
        // Maybe add: else { setProgress(100); }
    }
}
