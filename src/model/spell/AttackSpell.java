package model.spell;

import model.Entity;

public class AttackSpell extends Spell{

    String type;
    int power;

    public AttackSpell(String name, int MP, String type, int power) {
        super(name, MP);
        this.type = type;
        this.power = power;
    }


    @Override
    public void cast(Entity entity) {
        //Don't use
    }

    @Override
    public void cast(Entity user, Entity enemy) {
        enemy.setHP(enemy.getHP() - this.power * (user.getMagicAttack() / enemy.getMagicDefense() + 10));
        user.setMP(user.getMP() - MP);
    }
}
