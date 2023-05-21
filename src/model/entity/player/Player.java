package model.entity.player;

import collections.equipment.WeaponCollection;
import collections.spell.AttackSpellCollection;
import collections.spell.HealSpellCollection;
import model.entity.Entity;
import model.item.consumable.Consumable;
import model.item.equipment.*;
import model.spell.AttackSpell;
import model.spell.HealSpell;
import enums.Level;
import model.spell.StealSpell;
import view.panels.game.MonsterPanel;
import java.util.ArrayList;


public class Player extends Entity {

    private static int level = 1;
    private static int exp = 0;
    private static int nextExp = 50;
    private static int gold = 5;

    // TODO: Pop from Equipment if item is equipped.
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<Head> headGear = new ArrayList<>();
    private ArrayList<Body> armor = new ArrayList<>();
    private ArrayList<Arm> arm = new ArrayList<>();
    private ArrayList<Feet> footWear = new ArrayList<>();
    private ArrayList<Accessory> accessories = new ArrayList<>();
    private ArrayList<Consumable> consumableItems = new ArrayList<>();
    private Weapon weapon;

    public Player() {
        super(100, 10,  20, 20, 10, 10, 25);
        // -----------------------------------Spells------------------------------------------------------
        spells.put("First Aid", HealSpellCollection.FIRST_AID);
        spells.put("Flare", AttackSpellCollection.FLARE);
        // -------------------------------------Weapons-----------------------------------------------
        weapons.add(WeaponCollection.NONE);
        weapons.add(WeaponCollection.DAGGER);
        this.weapon = weapons.get(weapons.indexOf(WeaponCollection.NONE));
        // -------------------------------------Head Gear-----------------------------------------------
        // -------------------------------------Armor-----------------------------------------------
        // -------------------------------------Arm-----------------------------------------------
        // -------------------------------------Foot Wear-----------------------------------------------
        // -------------------------------------Accessories-----------------------------------------------
    }

    @Override
    public void attack(Entity monster) {
        super.attack(monster);
    }

    @Override
    public void castHealSpell(HealSpell healSpell) {
        healSpell.heal(this);
    }

    @Override
    public void castAttackSpell(AttackSpell attackSpell) {
        attackSpell.cast(this, MonsterPanel.getMonster());
    }

    @Override
    public void castStealGoldSpell(StealSpell stealSpell) {
        stealSpell.stealGold(this);
    }

    @Override
    public void castStealItemSpell(StealSpell stealSpell) {

    }

    @Override
    public void useItem() {

    }

    public void levelUp() {
        if (exp >= nextExp) {
            level++;
            exp = exp - nextExp;
            for (Level nextLevel : Level.values()) {
                if (level == Integer.parseInt(nextLevel.name().substring(5))){
                    System.out.println("You've reached " + nextLevel.name());
                    System.out.println("You've reached " + level);
                    nextExp += nextLevel.increaseNextExp;
                    HP += nextLevel.increaseHP;
                    maxHP += nextLevel.increaseHP;
                    MP += nextLevel.increaseMP;
                    maxMP += nextLevel.increaseMP;
                    attack += nextLevel.increaseAttack;
                    defense += nextLevel.increaseDefense;
                    magicAttack += nextLevel.increaseMAttack;
                    magicDefense += nextLevel.increaseMDefense;
                    speed += nextLevel.increaseSpeed;
                    break;
                }
            }
        }
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public void removeWeapon(Weapon weapon) {
        this.weapons.remove(weapon);
    }

    // TODO: --------add methods for other types of equipment-----------------------------

    public ArrayList<Consumable> getConsumableItems() {
        return consumableItems;
    }

    public void addConsumableItem(Consumable consumableItem) {
        this.consumableItems.add(consumableItem);
    }

    public void removeConsumableItem(Consumable consumableItem) {
        this.consumableItems.remove(consumableItem);
    }

    public void removeWeapon() {
        // TODO: put into arraylist (including WeaponCollection.NONE) and set to null
        this.maxHP -= this.weapon.getMaxHP();
        this.maxMP -= this.weapon.getMaxMP();
        this.attack -= this.weapon.getAttack();
        this.defense -= this.weapon.getDefense();
        this.magicAttack -= this.weapon.getMagicAttack();
        this.magicDefense -= this.weapon.getMagicDefense();
        this.speed -= this.weapon.getSpeed();
    }

    public void setWeapon(Weapon weapon) {
        // Remove current weapon
        removeWeapon();

        // TODO: Remove equipped weapon from arraylist.
        // Equip the weapon from the arraylist
        this.weapon = weapon;

        this.maxHP += weapon.getMaxHP();
        this.maxMP += weapon.getMaxMP();
        this.attack += weapon.getAttack();
        this.defense += weapon.getDefense();
        this.magicAttack += weapon.getMagicAttack();
        this.magicDefense += weapon.getMagicDefense();
        this.speed += weapon.getSpeed();
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getNextExp() {
        return nextExp;
    }

    public void setNextExp(int nextExp) {
        this.nextExp = nextExp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
