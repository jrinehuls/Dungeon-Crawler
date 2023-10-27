package controller;

import controller.game.ActionButtonController;
import model.entity.player.Player;
import model.item.Item;
import model.item.consumable.AttackItem;
import model.item.consumable.Consumable;
import model.item.consumable.HealingItem;
import model.item.equipment.*;
import view.frames.BuyFrame;
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

    private void handleButtonEvents(ActionEvent e) {
        if (e.getSource() == listPanel.getBuyButton() && !listPanel.getItemJList().isSelectionEmpty()) {
            String key = listPanel.getItemJList().getSelectedValue();
            String actionCommand = radioPanel.getButtonGroup().getSelection().getActionCommand();
            this.buyItem(key, actionCommand);
            listPanel.getItemJList().clearSelection();
        } else if (e.getSource() == buttonPanel.getSellButton()) {
            System.out.println("You need to do something with this button.");
        } else if (e.getSource() == buttonPanel.getExitButton()) {
            System.out.println("You need to make it exit to somewhere.");
        }
    }

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

    private void buyItem(String key, String actionCommand) {
        this.resetNewStats();
        HashMap<String, Equipment> equipmentMap;
        HashMap<String, Consumable> itemMap;
        int cost;
        if (actionCommand.equals(radioPanel.getWeaponButton().getActionCommand())) {
            equipmentMap = listPanel.getShopCollection().getWeaponsMap();
            cost = equipmentMap.get(key).getCost();
            System.out.printf("You just bought %s which is a weapon! and costs %d gold%n", key, cost);
        } else if (actionCommand.equals(radioPanel.getHeadButton().getActionCommand())) {
            equipmentMap = listPanel.getShopCollection().getHeadGearsMap();
            cost = equipmentMap.get(key).getCost();
            System.out.printf("You just bought %s which is a headgear! and costs %d gold%n", key, cost);
        } else if (actionCommand.equals(radioPanel.getBodyButton().getActionCommand())) {
            equipmentMap = listPanel.getShopCollection().getArmorMap();
            cost = equipmentMap.get(key).getCost();
            System.out.printf("You just bought %s which is an armor! and costs %d gold%n", key, cost);
        } else if (actionCommand.equals(radioPanel.getArmButton().getActionCommand())) {
            equipmentMap = listPanel.getShopCollection().getArmMap();
            cost = equipmentMap.get(key).getCost();
            System.out.printf("You just bought %s which is an arm guard! and costs %d gold%n", key, cost);
        } else if (actionCommand.equals(radioPanel.getFeetButton().getActionCommand())) {
            equipmentMap = listPanel.getShopCollection().getFootWearsMap();
            cost = equipmentMap.get(key).getCost();
            System.out.printf("You just bought %s which is a footwear! and costs %d gold%n", key, cost);
        } else if (actionCommand.equals(radioPanel.getAccessoryButton().getActionCommand())) {
            equipmentMap = listPanel.getShopCollection().getAccessoriesMap();
            cost = equipmentMap.get(key).getCost();
            System.out.printf("You just bought %s which is an accessory! and costs %d gold%n", key, cost);
        } else if (actionCommand.equals(radioPanel.getAttackButton().getActionCommand())) {
            itemMap = listPanel.getShopCollection().getAttackItemsMap();
            cost = itemMap.get(key).getCost();
            System.out.printf("You just bought %s which is an attack item! and costs %d gold%n", key, cost);
        } else if (actionCommand.equals(radioPanel.getHealingButton().getActionCommand())) {
            itemMap = listPanel.getShopCollection().getHealingItemsMap();
            cost = itemMap.get(key).getCost();
            System.out.printf("You just bought %s which is a healing item! and costs %d gold%n", key, cost);
        }
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
