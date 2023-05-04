package model.spell;

import model.entity.Entity;

public class AttackSpell extends Spell{

    String type;
    int power;

    public AttackSpell(String name, int MP, String type, int power) {
        super(name, MP);
        this.type = type;
        this.power = power;
    }


    @Override
    public void cast(Entity caster) {
        //Don't use
    }

    @Override
    public void cast(Entity caster, Entity target) {
        target.setHP(target.getHP() - (this.power * (caster.getMagicAttack() / target.getMagicDefense()) + 10));
        caster.setMP(caster.getMP() - MP);
    }
}
