package controller;

import controller.game.ActionButtonController;
import model.entity.player.Player;
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

        if (e.getSource() == listPanel.getBuyButton() && !listPanel.getItemJList().isSelectionEmpty()) {
            String actionCommand = radioPanel.getButtonGroup().getSelection().getActionCommand();
            String key = listPanel.getItemJList().getSelectedValue();
            this.resetNewStats();
            this.buyItem(key, actionCommand);
            listPanel.getItemJList().clearSelection();
        } else if (e.getSource() instanceof JRadioButton) {
            this.resetNewStats();
            this.setJListModel(e);
        } else if (e.getSource() == buttonPanel.getSellButton()) {
            System.out.println("You need to do something with this button.");
        } else if (e.getSource() == buttonPanel.getExitButton()) {
            System.out.println("You need to make it exit to somewhere.");
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.player = PlayerPanel.getPlayer();
        this.radioPanel = buyFrame.getRadioButtonPanel();
        this.listPanel = buyFrame.getListPanel();
        this.newStatsPanel = buyFrame.getNewStatsPanel();

        if (e.getValueIsAdjusting()) {
            if (radioPanel.getWeaponButton().isSelected()) {
                updateNewStats(player.getWeapon());
            } else if (radioPanel.getHeadButton().isSelected()) {
                updateNewStats(player.getHeadGear());
            } else if (radioPanel.getBodyButton().isSelected()) {
                updateNewStats(player.getArmor());
            } else if (radioPanel.getArmButton().isSelected()) {
                updateNewStats(player.getArm());
            } else if (radioPanel.getFeetButton().isSelected()) {
                updateNewStats(player.getFootwear());
            } else if (radioPanel.getAccessoryButton().isSelected()) {
                updateNewStats(player.getAccessory());
            }
        }
    }

    private void buyItem(String key, String actionCommand) {
        if (actionCommand.equals(radioPanel.getWeaponButton().getActionCommand())) {
            System.out.printf("You just bought %s which is a weapon!%n", key);
        } else if (actionCommand.equals(radioPanel.getHeadButton().getActionCommand())) {
            System.out.printf("You just bought %s which is a headgear!%n", key);
        } else if (actionCommand.equals(radioPanel.getBodyButton().getActionCommand())) {
            System.out.printf("You just bought %s which is an armor!%n", key);
        } else if (actionCommand.equals(radioPanel.getArmButton().getActionCommand())) {
            System.out.printf("You just bought %s which is an arm guard!%n", key);
        } else if (actionCommand.equals(radioPanel.getFeetButton().getActionCommand())) {
            System.out.printf("You just bought %s which is a footwear!%n", key);
        } else if (actionCommand.equals(radioPanel.getAccessoryButton().getActionCommand())) {
            System.out.printf("You just bought %s which is an accessory!%n", key);
        } else if (actionCommand.equals(radioPanel.getAttackButton().getActionCommand())) {
            System.out.printf("You just bought %s which is an attack item!%n", key);
        } else if (actionCommand.equals(radioPanel.getHealingButton().getActionCommand())) {
            System.out.printf("You just bought %s which is a healing item!%n", key);
        }
    }

    private void setJListModel(ActionEvent e) {
        if (e.getSource() == radioPanel.getWeaponButton()) {
            listPanel.loadWeaponsModel();
        }
        if (e.getSource() == radioPanel.getHeadButton()) {
            listPanel.loadHeadGearsModel();
        }
        if (e.getSource() == radioPanel.getBodyButton()) {
            listPanel.loadArmorsModel();
        }
        if (e.getSource() == radioPanel.getArmButton()) {
            listPanel.loadArmsModel();
        }
        if (e.getSource() == radioPanel.getFeetButton()) {
            listPanel.loadFootWearsModel();
        }
        if (e.getSource() == radioPanel.getAccessoryButton()) {
            listPanel.loadAccessoriesModel();
        }
        if (e.getSource() == radioPanel.getAttackButton()) {
            listPanel.loadAttackItemsModel();
        }
        if (e.getSource() == radioPanel.getHealingButton()) {
            listPanel.loadHealItemsModel();
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

    }

    // If a selection is highlighted, then player clicks another radio without equipping, set new stats to the same as player stats
    // Also changes label colors back to black when an item is equipped or another radio button is picked
    private void resetNewStats() {
        newStatsPanel.setNewMaxHPLabel(0);
        newStatsPanel.setNewMaxMPLabel(0);
        newStatsPanel.setNewAttackLabel(0);
        newStatsPanel.setNewDefenseLabel(0);
        newStatsPanel.setNewMagicAttackLabel(0);
        newStatsPanel.setNewMagicDefenseLabel(0);
        newStatsPanel.setNewSpeedLabel(0);
    }


}
