package controller;

import controller.game.ActionButtonController;
import main.Main;
import model.entity.player.Player;
import model.item.Item;
import model.item.consumable.AttackItem;
import model.item.consumable.Consumable;
import model.item.consumable.HealingItem;
import model.item.equipment.*;
import view.frames.BuyFrame;
import view.frames.MenuFrame;
import view.frames.SellFrame;
import view.panels.buy.*;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class BuyController implements ActionListener, ListSelectionListener {

    Player player;
    BuyFrame buyFrame;
    BuyRadioButtonPanel radioPanel;
    BuyNewStatsPanel newStatsPanel;
    BuyCurrentStatsPanel currentStatsPanel;
    BuyListPanel listPanel;
    BuyButtonPanel buttonPanel;
    public BuyController(BuyFrame buyFrame) {
        this.buyFrame = buyFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.player = PlayerPanel.getPlayer();
        this.radioPanel = buyFrame.getRadioButtonPanel();
        this.newStatsPanel = buyFrame.getNewStatsPanel();
        this.currentStatsPanel = buyFrame.getCurrentStatsPanel();
        this.listPanel = buyFrame.getListPanel();
        this.buttonPanel = buyFrame.getButtonPanel();

        if (e.getSource() instanceof JButton) {
            this.handleButtonEvents(e);
        } else if (e.getSource() instanceof JRadioButton) {
            this.setJListModel(e);
        }

    }

    /*
     * This method gets invoked whenever the value of the list selection changes
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.player = PlayerPanel.getPlayer();
        this.radioPanel = buyFrame.getRadioButtonPanel();
        this.listPanel = buyFrame.getListPanel();
        this.newStatsPanel = buyFrame.getNewStatsPanel();

        // Without this if statement, event happens on both mouse click and un-click.
        // Disables buy button if selected item too expensive for player.
        if (e.getValueIsAdjusting()) {
            String key = listPanel.getItemJList().getSelectedValue();
            int cost;
            if (radioPanel.getWeaponButton().isSelected()) {
                cost = listPanel.getShopCollection().getWeaponsMap().get(key).getCost();
                updateNewStats(player.getWeapon());
            } else if (radioPanel.getHeadButton().isSelected()) {
                cost = listPanel.getShopCollection().getHeadGearsMap().get(key).getCost();
                updateNewStats(player.getHeadGear());
            } else if (radioPanel.getBodyButton().isSelected()) {
                cost = listPanel.getShopCollection().getArmorMap().get(key).getCost();
                updateNewStats(player.getArmor());
            } else if (radioPanel.getArmButton().isSelected()) {
                cost = listPanel.getShopCollection().getArmMap().get(key).getCost();
                updateNewStats(player.getArm());
            } else if (radioPanel.getFeetButton().isSelected()) {
                cost = listPanel.getShopCollection().getFootWearsMap().get(key).getCost();
                updateNewStats(player.getFootwear());
            } else if (radioPanel.getAccessoryButton().isSelected()) {
                cost = listPanel.getShopCollection().getAccessoriesMap().get(key).getCost();
                updateNewStats(player.getAccessory());
            } else if (radioPanel.getAttackButton().isSelected()) {
                cost = listPanel.getShopCollection().getAttackItemsMap().get(key).getCost();
                newStatsPanel.setNewGoldLabel(-cost);
            } else {
                cost = listPanel.getShopCollection().getHealingItemsMap().get(key).getCost();
                newStatsPanel.setNewGoldLabel(-cost);
            }
            listPanel.getBuyButton().setEnabled(player.getGold() >= cost);
        }
    }

    /*
     * For things like Buy, Sell, and Exit
     */
    private void handleButtonEvents(ActionEvent e) {
        if (e.getSource() == listPanel.getBuyButton() && !listPanel.getItemJList().isSelectionEmpty()) {
            String key = listPanel.getItemJList().getSelectedValue();
            String actionCommand = radioPanel.getButtonGroup().getSelection().getActionCommand();
            this.buyItem(key, actionCommand);
            listPanel.getItemJList().clearSelection();
        } else if (e.getSource() == buttonPanel.getSellButton()) {
            Main.getBuyFrame().dispose();
            Main.setSellFrame(new SellFrame());
        } else if (e.getSource() == buttonPanel.getExitButton()) {
            Main.getBuyFrame().dispose();
            Main.setMenuFrame(new MenuFrame());
        }
    }

    /*
     * Based on the radio button chosen, sets the JList with those types of items.
     */
    private void setJListModel(ActionEvent e) {
        this.resetNewStats();
        if (e.getSource() == radioPanel.getWeaponButton()) {
            listPanel.loadWeaponsModel();
        } else if (e.getSource() == radioPanel.getHeadButton()) {
            listPanel.loadHeadGearsModel();
        } else if (e.getSource() == radioPanel.getBodyButton()) {
            listPanel.loadArmorsModel();
        } else if (e.getSource() == radioPanel.getArmButton()) {
            listPanel.loadArmsModel();
        } else if (e.getSource() == radioPanel.getFeetButton()) {
            listPanel.loadFootWearsModel();
        } else if (e.getSource() == radioPanel.getAccessoryButton()) {
            listPanel.loadAccessoriesModel();
        } else if (e.getSource() == radioPanel.getAttackButton()) {
            listPanel.loadAttackItemsModel();
        } else if (e.getSource() == radioPanel.getHealingButton()) {
            listPanel.loadHealItemsModel();
        }
    }

    /*
     * Method for taking money and adding item to player inventory
     */
    private void buyItem(String key, String actionCommand) {
        if (actionCommand.equals(radioPanel.getWeaponButton().getActionCommand())) {
            this.buyWeapon(key);
        } else if (actionCommand.equals(radioPanel.getHeadButton().getActionCommand())) {
            this.buyHeadgear(key);
        } else if (actionCommand.equals(radioPanel.getBodyButton().getActionCommand())) {
            this.buyArmor(key);
        } else if (actionCommand.equals(radioPanel.getArmButton().getActionCommand())) {
            this.buyArm(key);
        } else if (actionCommand.equals(radioPanel.getFeetButton().getActionCommand())) {
            this.buyFootwear(key);
        } else if (actionCommand.equals(radioPanel.getAccessoryButton().getActionCommand())) {
            this.buyAccessory(key);
        } else if (actionCommand.equals(radioPanel.getAttackButton().getActionCommand())) {
            this.buyAttackItem(key);
        } else if (actionCommand.equals(radioPanel.getHealingButton().getActionCommand())) {
            this.buyHealingItem(key);
        }
        currentStatsPanel.updateLabels();
        this.resetNewStats();
    }

    /*
     * Take gold from player in exchange for a weapon.
     */
    private void buyWeapon(String key) {
        HashMap<String, Equipment> equipmentMap = listPanel.getShopCollection().getWeaponsMap();
        Weapon weapon = (Weapon) equipmentMap.get(key);
        int cost = weapon.getCost();
        player.setGold(player.getGold() - cost);
        player.addWeapon(weapon);
    }

    /*
     * Take gold from player in exchange for a headgear.
     */
    private void buyHeadgear(String key) {
        HashMap<String, Equipment> equipmentMap = listPanel.getShopCollection().getHeadGearsMap();
        Head headgear = (Head) equipmentMap.get(key);
        int cost = headgear.getCost();
        player.setGold(player.getGold() - cost);
        player.addHeadgear(headgear);
    }

    /*
     * Take gold from player in exchange for an armor.
     */
    private void buyArmor(String key) {
        HashMap<String, Equipment> equipmentMap = listPanel.getShopCollection().getArmorMap();
        Body armor = (Body) equipmentMap.get(key);
        int cost = armor.getCost();
        player.setGold(player.getGold() - cost);
        player.addArmor(armor);
    }

    /*
     * Take gold from player in exchange for an arm guard.
     */
    private void buyArm(String key) {
        HashMap<String, Equipment> equipmentMap = listPanel.getShopCollection().getArmMap();
        Arm arm = (Arm) equipmentMap.get(key);
        int cost = arm.getCost();
        player.setGold(player.getGold() - cost);
        player.addArm(arm);
    }

    /*
     * Take gold from player in exchange for a footwear.
     */
    private void buyFootwear(String key) {
        HashMap<String, Equipment> equipmentMap = listPanel.getShopCollection().getFootWearsMap();
        Feet footwear = (Feet) equipmentMap.get(key);
        int cost = footwear.getCost();
        player.setGold(player.getGold() - cost);
        player.addFootwear(footwear);
    }

    /*
     * Take gold from player in exchange for an accessory.
     */
    private void buyAccessory(String key) {
        HashMap<String, Equipment> equipmentMap = listPanel.getShopCollection().getAccessoriesMap();
        Accessory accessory = (Accessory) equipmentMap.get(key);
        int cost = accessory.getCost();
        player.setGold(player.getGold() - cost);
        player.addAccessory(accessory);
    }

    /*
     * Take gold from player in exchange for an attack item.
     */
    private void buyAttackItem(String key) {
        HashMap<String, Consumable> itemMap = listPanel.getShopCollection().getAttackItemsMap();
        Consumable item = itemMap.get(key);
        int cost = item.getCost();
        player.setGold(player.getGold() - cost);
        player.addConsumableItem(item);
    }

    /*
     * Take gold from player in exchange for a healing item.
     */
    private void buyHealingItem(String key) {
        HashMap<String, Consumable> itemMap = listPanel.getShopCollection().getHealingItemsMap();
        Consumable item = itemMap.get(key);
        int cost = item.getCost();
        player.setGold(player.getGold() - cost);
        player.addConsumableItem(item);
        currentStatsPanel.updateLabels();
    }

    // When a selection is highlighted, shows what the stats will be if that item is equipped
    private void updateNewStats(Equipment equipment) {
        String key = listPanel.getItemJList().getSelectedValue();
        HashMap<String, Equipment> equipmentMap;

        if (equipment instanceof Weapon) {
            equipmentMap = listPanel.getShopCollection().getWeaponsMap();
        } else if (equipment instanceof Head) {
            equipmentMap = listPanel.getShopCollection().getHeadGearsMap();
        } else if (equipment instanceof Body) {
            equipmentMap = listPanel.getShopCollection().getArmorMap();
        } else if (equipment instanceof Arm) {
            equipmentMap = listPanel.getShopCollection().getArmMap();
        } else if (equipment instanceof Feet) {
            equipmentMap = listPanel.getShopCollection().getFootWearsMap();
        } else {
            equipmentMap = listPanel.getShopCollection().getAccessoriesMap();
        }

        newStatsPanel.setNewMaxHPLabel(equipmentMap.get(key).getMaxHP() - equipment.getMaxHP());
        newStatsPanel.setNewMaxMPLabel(equipmentMap.get(key).getMaxMP() - equipment.getMaxMP());
        newStatsPanel.setNewAttackLabel(equipmentMap.get(key).getAttack() - equipment.getAttack());
        newStatsPanel.setNewDefenseLabel(equipmentMap.get(key).getDefense() - equipment.getDefense());
        newStatsPanel.setNewMagicAttackLabel(equipmentMap.get(key).getMagicAttack() - equipment.getMagicAttack());
        newStatsPanel.setNewMagicDefenseLabel(equipmentMap.get(key).getMagicDefense() - equipment.getMagicDefense());
        newStatsPanel.setNewSpeedLabel(equipmentMap.get(key).getSpeed() - equipment.getSpeed());
        newStatsPanel.setNewGoldLabel(-equipmentMap.get(key).getCost());
    }

    // If a selection is highlighted, then player clicks another radio or buys the selection,
    // set new stats to the same as player stats, also changes label colors back to black.
    private void resetNewStats() {
        newStatsPanel.setNewMaxHPLabel(0);
        newStatsPanel.setNewMaxMPLabel(0);
        newStatsPanel.setNewAttackLabel(0);
        newStatsPanel.setNewDefenseLabel(0);
        newStatsPanel.setNewMagicAttackLabel(0);
        newStatsPanel.setNewMagicDefenseLabel(0);
        newStatsPanel.setNewSpeedLabel(0);
        newStatsPanel.setNewGoldLabel(0);
    }


}
