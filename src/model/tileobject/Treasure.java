package model.tileobject;

import model.item.Item;
import model.item.consumable.Consumable;
import model.item.equipment.*;
import util.SoundEffects;
import view.panels.game.DisplayPanel;
import view.panels.game.PlayerPanel;

public class Treasure extends InteractableTileObject implements Awardable {

    private Item item;
    SoundEffects se;

    public Treasure(Item item) {
        super("/icons/Treasure.png", "/backgrounds/Treasure.png");
        this.item = item;
        se = new SoundEffects();
    }

    @Override
    public void awardItem() {
        se.playSE(SoundEffects.OPEN_CHEST);
        DisplayPanel.appendConsoleModel("You received " + item.getName());
        if (item instanceof Weapon weapon) {
            PlayerPanel.getPlayer().addWeapon(weapon);
        } else if (item instanceof Head head) {
            PlayerPanel.getPlayer().addHeadgear(head);
        } else if (item instanceof Feet feet) {
            PlayerPanel.getPlayer().addFootwear(feet);
        } else if (item instanceof Body body) {
            PlayerPanel.getPlayer().addArmor(body);
        } else if (item instanceof Arm arm) {
            PlayerPanel.getPlayer().addArm(arm);
        } else if (item instanceof Accessory acc) {
            PlayerPanel.getPlayer().addAccessory(acc);
        } else if (item instanceof Consumable consumable) {
            PlayerPanel.getPlayer().addConsumableItem(consumable);
        }
    }

}
