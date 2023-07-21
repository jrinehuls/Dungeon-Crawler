package model.entity.player;

import collections.consumable.AttackItemCollection;
import collections.consumable.HealingItemCollection;
import collections.equipment.*;
import collections.spell.AttackSpellCollection;
import collections.spell.HealSpellCollection;
import collections.spell.StealSpellCollection;
import model.entity.Entity;
import model.item.Item;
import model.item.consumable.AttackItem;
import model.item.consumable.Consumable;
import model.item.consumable.HealingItem;
import model.item.equipment.*;
import model.spell.*;
import enums.Level;
import view.panels.game.DisplayPanel;
import view.panels.game.MonsterPanel;
import java.util.ArrayList;


public class Player extends Entity {

    // These were static
    private int level = 1;
    private int exp = 0;
    private int nextExp = 50;
    private int gold = 5;

    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<Head> headGears = new ArrayList<>();
    private ArrayList<Body> armors = new ArrayList<>();
    private ArrayList<Arm> arms = new ArrayList<>();
    private ArrayList<Feet> footWears = new ArrayList<>();
    private ArrayList<Accessory> accessories = new ArrayList<>();
    private ArrayList<Consumable> consumableItems = new ArrayList<>();

    private Weapon weapon;
    private Head headGear;
    private Body armor;
    private Arm arm;
    private Feet footwear;
    private Accessory accessory;

    private boolean defending = false;

    public Player() {
        super(100, 10,  20, 15, 10, 10, 25);
        // -------------------------------------------- Spells ---------------------------------------------------------
        spells.put("First Aid", HealSpellCollection.FIRST_AID);
        spells.put("Flare", AttackSpellCollection.FLARE);
        spells.put("Mug", StealSpellCollection.MUG);
        // -------------------------------------------- Weapons --------------------------------------------------------
        this.weapon = WeaponCollection.NONE;
        weapons.add(WeaponCollection.WOODEN_DAGGER);
        // ------------------------------------------- Head Gear -------------------------------------------------------
        this.headGear = HeadCollection.NONE;
        headGears.add(HeadCollection.STRAW_CAP);
        // --------------------------------------------- Armor ---------------------------------------------------------
        this.armor = BodyCollection.NONE;
        armors.add(BodyCollection.LEATHER_VEST);
        // ---------------------------------------------- Arm ----------------------------------------------------------
        this.arm = ArmCollection.NONE;
        arms.add(ArmCollection.RUBBER_BRACELET);
        // -------------------------------------------- Foot Wear ------------------------------------------------------
        this.footwear = FeetCollection.NONE;
        footWears.add(FeetCollection.LEATHER_SANDALS);
        // ------------------------------------------- Accessories -----------------------------------------------------
        this.accessory = AccessoryCollection.NONE;
        accessories.add(AccessoryCollection.SPELL_TOME);
        // ------------------------------------------- Consumables -----------------------------------------------------
        this.addConsumableItem(HealingItemCollection.HEALING_HERB);
        this.addConsumableItem(HealingItemCollection.HEALING_HERB);
        this.addConsumableItem(AttackItemCollection.BOMB);
    }

    // --------------------------------------------- Player Actions ----------------------------------------------------
    @Override
    public void attack(Entity monster) {
        super.attack(monster);
    }

    @Override
    public void castHealSpell(HealSpell healSpell) {
        int oldHP = this.HP;
        healSpell.heal(this);
        int newHP = this.HP;
        DisplayPanel.appendConsoleModel(String.format("You casted %s and healed %d HP!",
                healSpell.NAME, newHP - oldHP));
    }

    @Override
    public void castAttackSpell(AttackSpell attackSpell) {
        int oldHP = MonsterPanel.getMonster().getHP();
        attackSpell.cast(this, MonsterPanel.getMonster());
        int newHP = MonsterPanel.getMonster().getHP();
        DisplayPanel.appendConsoleModel(String.format("You casted %s and dealt %d HP of damage!",
                attackSpell.NAME, oldHP - newHP));
    }

    @Override
    public void castStealGoldSpell(StealGoldSpell stealSpell) {
        int oldGold = this.getGold();
        stealSpell.stealGold(this);
        int newGold = this.getGold();
        if (newGold > oldGold) {
            DisplayPanel.appendConsoleModel(String.format("You casted %s and stole %d gold!",
                    stealSpell.NAME, newGold - oldGold));
        }
    }

    @Override
    public void castStealItemSpell(StealItemSpell stealSpell) {
        Item item = stealSpell.stealItem(this);
        if (item != null) {
            DisplayPanel.appendConsoleModel(String.format("You casted %s and stole %s!",
                    stealSpell.NAME, item.getName()));
        }
    }

    @Override
    public void useHealingItem(HealingItem healingItem) {
        int oldHP = this.getHP();
        if (this.maxHP - this.HP > healingItem.getHP()) {
            this.setHP(this.getHP() + healingItem.getHP());
        } else {
            this.setHP(this.getMaxHP());
        }
        int newHP = this.getHP();
        DisplayPanel.appendConsoleModel(String.format("You used %s and healed %d HP!",
                healingItem.getName(), newHP - oldHP));
        this.disposeConsumableItem(healingItem);
    }

    @Override
    public void useAttackItem(AttackItem attackItem) {
        int oldHP = MonsterPanel.getMonster().getHP();
        if (MonsterPanel.getMonster().getHP() > attackItem.getDamage()) {
            MonsterPanel.getMonster().setHP(MonsterPanel.getMonster().getHP() - attackItem.getDamage());
        } else {
            MonsterPanel.getMonster().setHP(0);
        }
        int newHP = MonsterPanel.getMonster().getHP();
        DisplayPanel.appendConsoleModel(String.format("You used %s and dealt %d HP of damage!",
                attackItem.getName(), oldHP - newHP));
        this.disposeConsumableItem(attackItem);
    }

    public boolean isDefending() {
        return this.defending;
    }

    public void defend() {
        if (!isDefending()) {
            this.defense *= 2;
            this.magicDefense *= 2;
        }
        this.defending = true;
    }

    public void stopDefending() {
        if (isDefending()) {
            this.defense /= 2;
            this.magicDefense /= 2;
        }
        this.defending = false;
    }

    // ---------------------------------------------- Weapon Methods ---------------------------------------------------
    private void unequipWeapon() {
        // -------------- remove stats -------------------
        this.maxHP -= this.weapon.getMaxHP();
        this.maxMP -= this.weapon.getMaxMP();
        this.attack -= this.weapon.getAttack();
        this.defense -= this.weapon.getDefense();
        this.magicAttack -= this.weapon.getMagicAttack();
        this.magicDefense -= this.weapon.getMagicDefense();
        this.speed -= this.weapon.getSpeed();
        // ------------- put weapon in inventory -----------
        addWeapon(this.weapon);
        // ------------ no weapon is equipped --------------
        this.weapon = null;
    }

    public void equipWeapon(Weapon weapon) {
        // ----------- Remove old weapon ---------------------
        unequipWeapon();
        // --------- remove weapon from inventory ------------
        disposeWeapon(weapon);
        // --------------- Equip the weapon ------------------
        this.weapon = weapon;
        // ------- Update stats for new weapon ---------------
        this.maxHP += weapon.getMaxHP();
        this.maxMP += weapon.getMaxMP();
        this.attack += weapon.getAttack();
        this.defense += weapon.getDefense();
        this.magicAttack += weapon.getMagicAttack();
        this.magicDefense += weapon.getMagicDefense();
        this.speed += weapon.getSpeed();
    }

    public void addWeapon(Weapon weapon) {
        if (weapons.contains(weapon)) {
            weapon.increaseQty();
        } else {
            this.weapons.add(weapon);
        }
    }

    public void disposeWeapon(Weapon weapon) {
        // -------- For something like selling weapon----------
        if (weapon.getQty() > 1) {
            weapon.decreaseQty();
        } else {
            this.weapons.remove(weapon);
        }
    }

    // ---------------------------------------------- Headgear Methods -------------------------------------------------
    private void unequipHeadgear() {
        // -------------- remove stats -------------------
        this.maxHP -= this.headGear.getMaxHP();
        this.maxMP -= this.headGear.getMaxMP();
        this.attack -= this.headGear.getAttack();
        this.defense -= this.headGear.getDefense();
        this.magicAttack -= this.headGear.getMagicAttack();
        this.magicDefense -= this.headGear.getMagicDefense();
        this.speed -= this.headGear.getSpeed();
        // ------------- put headgear in inventory -----------
        addHeadgear(this.headGear);
        // ------------ no headgear is equipped --------------
        this.headGear = null;
    }

    public void equipHeadgear(Head headgear) {
        // ----------- Remove old headgear ---------------------
        unequipHeadgear();
        // --------- remove headgear from inventory ------------
        disposeHeadgear(headgear);
        // --------------- Equip the headgear ------------------
        this.headGear = headgear;
        // ------- Update stats for new headgear ---------------
        this.maxHP += headgear.getMaxHP();
        this.maxMP += headgear.getMaxMP();
        this.attack += headgear.getAttack();
        this.defense += headgear.getDefense();
        this.magicAttack += headgear.getMagicAttack();
        this.magicDefense += headgear.getMagicDefense();
        this.speed += headgear.getSpeed();
    }

    public void addHeadgear(Head headGear) {
        if (headGears.contains(headGear)) {
            headGear.increaseQty();
        } else {
            this.headGears.add(headGear);
        }
    }

    public void disposeHeadgear(Head headGear) {
        // -------- For something like selling armor ----------
        if (headGear.getQty() > 1) {
            headGear.decreaseQty();
        } else {
            this.headGears.remove(headGear);
        }
    }

    // --------------------------------------------- Armor Methods -----------------------------------------------------
    private void unequipArmor() {
        // -------------- remove stats -------------------
        this.maxHP -= this.armor.getMaxHP();
        this.maxMP -= this.armor.getMaxMP();
        this.attack -= this.armor.getAttack();
        this.defense -= this.armor.getDefense();
        this.magicAttack -= this.armor.getMagicAttack();
        this.magicDefense -= this.armor.getMagicDefense();
        this.speed -= this.armor.getSpeed();
        // ------------- put armor in inventory -----------
        addArmor(this.armor);
        // ------------ no armor is equipped --------------
        this.armor = null;
    }

    public void equipArmor(Body armor) {
        // ----------- Remove old armor ---------------------
        unequipArmor();
        // --------- remove armor from inventory ------------
        disposeArmor(armor);
        // --------------- Equip the armor ------------------
        this.armor = armor;
        // ------- Update stats for new armor ---------------
        this.maxHP += armor.getMaxHP();
        this.maxMP += armor.getMaxMP();
        this.attack += armor.getAttack();
        this.defense += armor.getDefense();
        this.magicAttack += armor.getMagicAttack();
        this.magicDefense += armor.getMagicDefense();
        this.speed += armor.getSpeed();
    }

    public void addArmor(Body armor) {
        if (armors.contains(armor)) {
            armor.increaseQty();
        } else {
            this.armors.add(armor);
        }
    }

    public void disposeArmor(Body armor) {
        // -------- For something like selling armor ----------
        if (armor.getQty() > 1) {
            armor.decreaseQty();
        } else {
            this.armors.remove(armor);
        }
    }

    // ---------------------------------------------- Arm Methods ------------------------------------------------------
    private void unequipArm() {
        // -------------- remove stats -------------------
        this.maxHP -= this.arm.getMaxHP();
        this.maxMP -= this.arm.getMaxMP();
        this.attack -= this.arm.getAttack();
        this.defense -= this.arm.getDefense();
        this.magicAttack -= this.arm.getMagicAttack();
        this.magicDefense -= this.arm.getMagicDefense();
        this.speed -= this.arm.getSpeed();
        // ------------- put arm in inventory -----------
        addArm(this.arm);
        // ------------ no arm is equipped --------------
        this.arm = null;
    }

    public void equipArm(Arm arm) {
        // ----------- Remove old arm ---------------------
        unequipArm();
        // --------- remove arm from inventory ------------
        disposeArm(arm);
        // --------------- Equip the arm ------------------
        this.arm = arm;
        // ------- Update stats for new arm ---------------
        this.maxHP += arm.getMaxHP();
        this.maxMP += arm.getMaxMP();
        this.attack += arm.getAttack();
        this.defense += arm.getDefense();
        this.magicAttack += arm.getMagicAttack();
        this.magicDefense += arm.getMagicDefense();
        this.speed += arm.getSpeed();
    }

    public void addArm(Arm arm) {
        if (arms.contains(arm)) {
            arm.increaseQty();
        } else {
            this.arms.add(arm);
        }
    }

    public void disposeArm(Arm arm) {
        // -------- For something like selling arm ----------
        if (arm.getQty() > 1) {
            arm.decreaseQty();
        } else {
            this.arms.remove(arm);
        }
    }

    // ------------------------------------------- Footwear Methods ----------------------------------------------------
    private void unequipFootwear() {
        // -------------- remove stats -------------------
        this.maxHP -= this.footwear.getMaxHP();
        this.maxMP -= this.footwear.getMaxMP();
        this.attack -= this.footwear.getAttack();
        this.defense -= this.footwear.getDefense();
        this.magicAttack -= this.footwear.getMagicAttack();
        this.magicDefense -= this.footwear.getMagicDefense();
        this.speed -= this.footwear.getSpeed();
        // ------------- put footwear in inventory -----------
        addFootwear(this.footwear);
        // ------------ no footwear is equipped --------------
        this.footwear = null;
    }

    public void equipFootwear(Feet footwear) {
        // ----------- Remove old footwear ---------------------
        unequipFootwear();
        // --------- remove footwear from inventory ------------
        disposeFootwear(footwear);
        // --------------- Equip the footwear ------------------
        this.footwear = footwear;
        // ------- Update stats for new footwear ---------------
        this.maxHP += footwear.getMaxHP();
        this.maxMP += footwear.getMaxMP();
        this.attack += footwear.getAttack();
        this.defense += footwear.getDefense();
        this.magicAttack += footwear.getMagicAttack();
        this.magicDefense += footwear.getMagicDefense();
        this.speed += footwear.getSpeed();
    }

    public void addFootwear(Feet footwear) {
        if (footWears.contains(footwear)) {
            footwear.increaseQty();
        } else {
            this.footWears.add(footwear);
        }
    }

    public void disposeFootwear(Feet footwear) {
        // -------- For something like selling footwear ----------
        if (footwear.getQty() > 1) {
            footwear.decreaseQty();
        } else {
            this.footWears.remove(footwear);
        }
    }

    // ------------------------------------------- Accessory Methods ---------------------------------------------------
    private void unequipAccessory() {
        // -------------- remove stats -------------------
        this.maxHP -= this.accessory.getMaxHP();
        this.maxMP -= this.accessory.getMaxMP();
        this.attack -= this.accessory.getAttack();
        this.defense -= this.accessory.getDefense();
        this.magicAttack -= this.accessory.getMagicAttack();
        this.magicDefense -= this.accessory.getMagicDefense();
        this.speed -= this.accessory.getSpeed();
        // ------------- put accessory in inventory -----------
        addAccessory(this.accessory);
        // ------------ no accessory is equipped --------------
        this.accessory = null;
    }

    public void equipAccessory(Accessory accessory) {
        // ----------- Remove old accessory ---------------------
        unequipAccessory();
        // --------- remove accessory from inventory ------------
        disposeAccessory(accessory);
        // --------------- Equip the accessory ------------------
        this.accessory = accessory;
        // ------- Update stats for new accessory ---------------
        this.maxHP += accessory.getMaxHP();
        this.maxMP += accessory.getMaxMP();
        this.attack += accessory.getAttack();
        this.defense += accessory.getDefense();
        this.magicAttack += accessory.getMagicAttack();
        this.magicDefense += accessory.getMagicDefense();
        this.speed += accessory.getSpeed();
    }

    public void addAccessory(Accessory accessory) {
        if (accessories.contains(accessory)) {
            accessory.increaseQty();
        } else {
            this.accessories.add(accessory);
        }
    }

    public void disposeAccessory(Accessory accessory) {
        // -------- For something like selling footwear ----------
        if (accessory.getQty() > 1) {
            accessory.decreaseQty();
        } else {
            this.accessories.remove(accessory);
        }
    }

    // ------------------------------------------ Consumable Item Methods ----------------------------------------------

    public void addConsumableItem(Consumable consumableItem) {
        if (consumableItems.contains(consumableItem)) {
            consumableItem.increaseQty();
        } else {
            this.consumableItems.add(consumableItem);
        }
    }

    public void disposeConsumableItem(Consumable consumableItem) {
        if (consumableItem.getQty() > 1) {
            consumableItem.decreaseQty();
        } else {
            this.consumableItems.remove(consumableItem);
        }
    }

    // ------------------------------------- Generic Getters and Setters -----------------------------------------------
    public void levelUp() {
        if (exp >= nextExp && level <= Level.values().length) {
            level++;
            exp = exp - nextExp;
            Level nextLevel = Level.valueOf(String.format("LEVEL%d", level));
            DisplayPanel.appendConsoleModel("------------------------------------------------------");
            DisplayPanel.appendConsoleModel("You've reached " + nextLevel + "!");
            nextExp += nextLevel.increaseNextExp;
            HP += nextLevel.increaseHP;
            maxHP += nextLevel.increaseHP;
            DisplayPanel.appendConsoleModel("Your Max HP increased by " + nextLevel.increaseHP + "!");
            MP += nextLevel.increaseMP;
            maxMP += nextLevel.increaseMP;
            DisplayPanel.appendConsoleModel("Your Max MP increased by " + nextLevel.increaseMP + "!");
            attack += nextLevel.increaseAttack;
            DisplayPanel.appendConsoleModel("Your Attack increased by " + nextLevel.increaseAttack + "!");
            defense += nextLevel.increaseDefense;
            DisplayPanel.appendConsoleModel("Your Defense increased by " + nextLevel.increaseDefense + "!");
            magicAttack += nextLevel.increaseMAttack;
            DisplayPanel.appendConsoleModel("Your Magic Attack increased by " + nextLevel.increaseMAttack + "!");
            magicDefense += nextLevel.increaseMDefense;
            DisplayPanel.appendConsoleModel("Your Magic Defense increased by " + nextLevel.increaseMDefense + "!");
            speed += nextLevel.increaseSpeed;
            DisplayPanel.appendConsoleModel("Your Speed increased by " + nextLevel.increaseSpeed + "!");
            DisplayPanel.appendConsoleModel("------------------------------------------------------");
        } else if (exp >= nextExp) {
            exp = nextExp;
        }
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

    // --------------------------------------- Equipment related getters -----------------------------------------------
    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public ArrayList<Head> getHeadGears() {
        return this.headGears;
    }

    public Head getHeadGear() {
        return this.headGear;
    }

    public ArrayList<Body> getArmors() {
        return this.armors;
    }

    public Body getArmor() {
        return this.armor;
    }

    public ArrayList<Arm> getArms() {
        return this.arms;
    }

    public Arm getArm() {
        return this.arm;
    }

    public ArrayList<Feet> getFootWears() {
        return this.footWears;
    }

    public Feet getFootwear() {
        return this.footwear;
    }

    public ArrayList<Accessory> getAccessories() {
        return this.accessories;
    }

    public Accessory getAccessory() {
        return this.accessory;
    }

    // --------------------------------------- Item related getters -----------------------------------------------
    public ArrayList<Consumable> getConsumableItems() {
        return consumableItems;
    }

}
