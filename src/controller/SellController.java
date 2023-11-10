package controller;

import main.Main;
import model.entity.player.Player;
import model.item.Item;
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
            Item item = listPanel.getItemJList().getSelectedValue();
            int cost;
            if (radioPanel.getWeaponButton().isSelected()) {
                cost = item.getSalePrice();
                newStatsPanel.setNewGoldLabel(cost);
            } else if (radioPanel.getHeadButton().isSelected()) {
                cost = item.getSalePrice();
                newStatsPanel.setNewGoldLabel(cost);
            } else if (radioPanel.getBodyButton().isSelected()) {
                cost = item.getSalePrice();
                newStatsPanel.setNewGoldLabel(cost);
            } else if (radioPanel.getArmButton().isSelected()) {
                cost = item.getSalePrice();
                newStatsPanel.setNewGoldLabel(cost);
            } else if (radioPanel.getFeetButton().isSelected()) {
                cost = item.getSalePrice();
                newStatsPanel.setNewGoldLabel(cost);
            } else if (radioPanel.getAccessoryButton().isSelected()) {
                cost = item.getSalePrice();
                newStatsPanel.setNewGoldLabel(cost);
            } else if (radioPanel.getAttackButton().isSelected()) {
                cost = item.getSalePrice();
                newStatsPanel.setNewGoldLabel(cost);
            } else {
                cost = item.getSalePrice();
                newStatsPanel.setNewGoldLabel(cost);
            }
        }
    }

    /*
     * For things like Buy, Sell, and Exit
     */
    private void handleButtonEvents(ActionEvent e) {
        if (e.getSource() == listPanel.getSellButton() && !listPanel.getItemJList().isSelectionEmpty()) {
            Item item = listPanel.getItemJList().getSelectedValue();
            this.sellItem(item);
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
    private void sellItem(Item item) {
        player.setGold(player.getGold() + item.getSalePrice());
        if (item instanceof Weapon weapon) {
            System.out.println(weapon);
            player.disposeWeapon(weapon);
        } else if (item instanceof Head head) {
            System.out.println(head);
            player.disposeHeadgear(head);
        } else if (item instanceof Body armor) {
            System.out.println(armor);
            player.disposeArmor(armor);
        } else if (item instanceof Arm arm) {
            System.out.println(arm);
            player.disposeArm(arm);
        } else if (item instanceof Feet footwear) {
            System.out.println(footwear);
            player.disposeFootwear(footwear);
        } else if (item instanceof Accessory accessory) {
            System.out.println(accessory);
            player.disposeAccessory(accessory);
        } else if (item instanceof Consumable consumable) {
            System.out.println(consumable);
            player.disposeConsumableItem(consumable);
        }
        currentStatsPanel.updateLabels();
        this.resetNewStats();
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
