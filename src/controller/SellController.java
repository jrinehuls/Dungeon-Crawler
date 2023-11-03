package controller;

import main.Main;
import model.entity.player.Player;
import model.item.consumable.Consumable;
import model.item.equipment.*;
import view.frames.BuyFrame;
import view.frames.MenuFrame;
import view.frames.SellFrame;
import view.panels.game.PlayerPanel;
import view.panels.sell.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class SellController implements ActionListener, ListSelectionListener {

    Player player;
    SellFrame sellFrame;
    SellRadioButtonPanel radioPanel;
    SellNewStatsPanel newStatsPanel;
    SellCurrentStatsPanel currentStatsPanel;
    SellListPanel listPanel;
    SellButtonPanel buttonPanel;
    public SellController(SellFrame sellFrame) {
        this.sellFrame = sellFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.player = PlayerPanel.getPlayer();
        this.radioPanel = sellFrame.getRadioButtonPanel();
        this.newStatsPanel = sellFrame.getNewStatsPanel();
        this.currentStatsPanel = sellFrame.getCurrentStatsPanel();
        this.listPanel = sellFrame.getListPanel();
        this.buttonPanel = sellFrame.getButtonPanel();

        if (e.getSource() instanceof JButton) {
            this.handleButtonEvents(e);
        } else if (e.getSource() instanceof JRadioButton) {
            this.setJListModel(e);
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.player = PlayerPanel.getPlayer();
        this.radioPanel = sellFrame.getRadioButtonPanel();
        this.listPanel = sellFrame.getListPanel();
        this.newStatsPanel = sellFrame.getNewStatsPanel();

        // Without this if statement, event happens on both mouse click and un-click.
        // Disables sell button if selected item too expensive for player.
        if (e.getValueIsAdjusting()) {
            String key = listPanel.getItemJList().getSelectedValue();
            int cost;
            if (radioPanel.getWeaponButton().isSelected()) {
                cost = listPanel.getShopCollection().getWeaponsMap().get(key).getCost();
                newStatsPanel.setNewGoldLabel(-cost);
            } else if (radioPanel.getHeadButton().isSelected()) {
                cost = listPanel.getShopCollection().getHeadGearsMap().get(key).getCost();
                newStatsPanel.setNewGoldLabel(-cost);
            } else if (radioPanel.getBodyButton().isSelected()) {
                cost = listPanel.getShopCollection().getArmorMap().get(key).getCost();
                newStatsPanel.setNewGoldLabel(-cost);
            } else if (radioPanel.getArmButton().isSelected()) {
                cost = listPanel.getShopCollection().getArmMap().get(key).getCost();
                newStatsPanel.setNewGoldLabel(-cost);
            } else if (radioPanel.getFeetButton().isSelected()) {
                cost = listPanel.getShopCollection().getFootWearsMap().get(key).getCost();
                newStatsPanel.setNewGoldLabel(-cost);
            } else if (radioPanel.getAccessoryButton().isSelected()) {
                cost = listPanel.getShopCollection().getAccessoriesMap().get(key).getCost();
                newStatsPanel.setNewGoldLabel(-cost);
            } else if (radioPanel.getAttackButton().isSelected()) {
                cost = listPanel.getShopCollection().getAttackItemsMap().get(key).getCost();
                newStatsPanel.setNewGoldLabel(-cost);
            } else {
                cost = listPanel.getShopCollection().getHealingItemsMap().get(key).getCost();
                newStatsPanel.setNewGoldLabel(-cost);
            }
            // listPanel.getSellButton().setEnabled(player.getGold() >= cost);
        }
    }

    /*
     * For things like Buy, Sell, and Exit
     */
    private void handleButtonEvents(ActionEvent e) {
        if (e.getSource() == listPanel.getSellButton() && !listPanel.getItemJList().isSelectionEmpty()) {
            String key = listPanel.getItemJList().getSelectedValue();
            String actionCommand = radioPanel.getButtonGroup().getSelection().getActionCommand();
            this.sellItem(key, actionCommand);
            listPanel.getItemJList().clearSelection();
        } else if (e.getSource() == buttonPanel.getBuyButton()) {
            Main.getSellFrame().dispose();
            Main.setBuyFrame(new BuyFrame());
        } else if (e.getSource() == buttonPanel.getExitButton()) {
            Main.getSellFrame().dispose();
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
    private void sellItem(String key, String actionCommand) {
        if (actionCommand.equals(radioPanel.getWeaponButton().getActionCommand())) {
            this.sellWeapon(key);
        } else if (actionCommand.equals(radioPanel.getHeadButton().getActionCommand())) {
            this.sellHeadgear(key);
        } else if (actionCommand.equals(radioPanel.getBodyButton().getActionCommand())) {
            this.sellArmor(key);
        } else if (actionCommand.equals(radioPanel.getArmButton().getActionCommand())) {
            this.sellArm(key);
        } else if (actionCommand.equals(radioPanel.getFeetButton().getActionCommand())) {
            this.sellFootwear(key);
        } else if (actionCommand.equals(radioPanel.getAccessoryButton().getActionCommand())) {
            this.sellAccessory(key);
        } else if (actionCommand.equals(radioPanel.getAttackButton().getActionCommand())) {
            this.sellAttackItem(key);
        } else if (actionCommand.equals(radioPanel.getHealingButton().getActionCommand())) {
            this.sellHealingItem(key);
        }
        currentStatsPanel.updateLabels();
        this.resetNewStats();
    }


    /*
     * Give gold to player in exchange for a weapon.
     */
    private void sellWeapon(String key) {
        System.out.println(key);
    }

    /*
     * Give gold to player in exchange for a headgear.
     */
    private void sellHeadgear(String key) {
        System.out.println(key);
    }

    /*
     * Give gold to player in exchange for an armor.
     */
    private void sellArmor(String key) {
        System.out.println(key);
    }

    /*
     * Give gold to player in exchange for an arm guard.
     */
    private void sellArm(String key) {
        System.out.println(key);
    }

    /*
     * Give gold to player in exchange for a footwear.
     */
    private void sellFootwear(String key) {
        System.out.println(key);
    }

    /*
     * Give gold to player in exchange for an accessory.
     */
    private void sellAccessory(String key) {
        System.out.println(key);
    }

    /*
     * Give gold to player in exchange for an attack item.
     */
    private void sellAttackItem(String key) {
        System.out.println(key);
    }

    /*
     * Give gold to player in exchange for a healing item.
     */
    private void sellHealingItem(String key) {
        System.out.println(key);
    }

    // If a selection is highlighted, then player clicks another radio or sells the selection,
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
