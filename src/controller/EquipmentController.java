package controller;

import collections.equipment.WeaponCollection;
import model.entity.player.Player;
import model.item.equipment.*;
import view.frames.EquipmentFrame;
import view.panels.equipment.*;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipmentController implements ActionListener, ListSelectionListener {

    Player player;
    EquipmentFrame equipmentFrame;
    EquipRadioButtonPanel radioPanel;
    EquipListPanel listPanel;
    CurrentStatsPanel currentStatsPanel;
    NewStatsPanel newStatsPanel;
    ButtonPanel buttonPanel;

    public EquipmentController() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Add functions for other radio buttons
        player = PlayerPanel.getPlayer();
        equipmentFrame = ActionButtonController.equipmentFrame;
        radioPanel = equipmentFrame.equipRadioButtonPanel;
        listPanel = equipmentFrame.equipListPanel;
        currentStatsPanel = equipmentFrame.currentStatsPanel;
        newStatsPanel = ActionButtonController.equipmentFrame.newStatsPanel;
        buttonPanel = equipmentFrame.buttonPanel;
        // ------------------------- JButtons ------------------------------------
        if (e.getSource() == buttonPanel.getSubmitButton()) {
            equipmentFrame.dispose();
        } else if (!listPanel.equipmentJList.isSelectionEmpty() && e.getSource() == listPanel.equipButton) {
            equipSelection();
        }
        // --------------------- Radio Buttons ------------------------------------
        if (e.getSource() instanceof JRadioButton) {
            System.out.println("hello");
            resetNewStats();
        }
        populateJList();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        player = PlayerPanel.getPlayer();
        radioPanel = ActionButtonController.equipmentFrame.equipRadioButtonPanel;
        listPanel = ActionButtonController.equipmentFrame.equipListPanel;
        newStatsPanel = ActionButtonController.equipmentFrame.newStatsPanel;

        if (e.getValueIsAdjusting()) {
            if (radioPanel.weaponButton.isSelected()) {
                updateNewStats(player.getWeapon());
            } else if (radioPanel.headButton.isSelected()) {
                updateNewStats(player.getHeadGear());
            } else if (radioPanel.bodyButton.isSelected()) {
                updateNewStats(player.getArmor());
            } else if (radioPanel.armButton.isSelected()) {
                updateNewStats(player.getArm());
            } else if (radioPanel.feetButton.isSelected()) {
                updateNewStats(player.getFootwear());
            } else if (radioPanel.accessoryButton.isSelected()) {
                updateNewStats(player.getAccessory());
            }
        }
    }

    private void equipSelection() {
        if (radioPanel.weaponButton.isSelected()) {
            radioPanel.weaponLabel.setText(listPanel.equipmentJList.getSelectedValue().toString());
            player.equipWeapon((Weapon) listPanel.equipmentJList.getSelectedValue());
            currentStatsPanel.updateLabels();
        } else if (radioPanel.headButton.isSelected()) {
            radioPanel.headLabel.setText(listPanel.equipmentJList.getSelectedValue().toString());
            player.equipHeadgear((Head) listPanel.equipmentJList.getSelectedValue());
            currentStatsPanel.updateLabels();
        } else if (radioPanel.bodyButton.isSelected()) {
            radioPanel.bodyLabel.setText(listPanel.equipmentJList.getSelectedValue().toString());
            player.equipArmor((Body) listPanel.equipmentJList.getSelectedValue());
            currentStatsPanel.updateLabels();
        } else if (radioPanel.armButton.isSelected()) {
            radioPanel.armLabel.setText(listPanel.equipmentJList.getSelectedValue().toString());
            player.equipArm((Arm) listPanel.equipmentJList.getSelectedValue());
            currentStatsPanel.updateLabels();
        } else if (radioPanel.feetButton.isSelected()) {
            radioPanel.feetLabel.setText(listPanel.equipmentJList.getSelectedValue().toString());
            player.equipFootwear((Feet) listPanel.equipmentJList.getSelectedValue());
            currentStatsPanel.updateLabels();
        } else if (radioPanel.accessoryButton.isSelected()) {
            radioPanel.accessoryLabel.setText(listPanel.equipmentJList.getSelectedValue().toString());
            player.equipAccessory((Accessory) listPanel.equipmentJList.getSelectedValue());
            currentStatsPanel.updateLabels();
        }
    }

    private void populateJList() {
        if (radioPanel.weaponButton.isSelected()) {
            listPanel.loadWeaponsModel();
            listPanel.equipmentJList.setModel(listPanel.getWeaponsModel());
        } else if (radioPanel.headButton.isSelected()) {
            listPanel.loadHeadGearsModel();
            listPanel.equipmentJList.setModel(listPanel.getHeadGearsModel());
        } else if (radioPanel.bodyButton.isSelected()) {
            listPanel.loadArmorsModel();
            listPanel.equipmentJList.setModel(listPanel.getArmorsModel());
        } else if (radioPanel.armButton.isSelected()) {
            listPanel.loadArmsModel();
            listPanel.equipmentJList.setModel(listPanel.getArmsModel());
        } else if (radioPanel.feetButton.isSelected()) {
            listPanel.loadFootWearsModel();
            listPanel.equipmentJList.setModel(listPanel.getFootWearsModel());
        } else if (radioPanel.accessoryButton.isSelected()) {
            listPanel.loadAccessoriesModel();
            listPanel.equipmentJList.setModel(listPanel.getAccessoriesModel());
        }
    }

    private void updateNewStats(Equipment equipment) {
        newStatsPanel.setNewMaxHPLabel(listPanel.equipmentJList.getSelectedValue().getMaxHP() - equipment.getMaxHP());
        newStatsPanel.setNewMaxMPLabel(listPanel.equipmentJList.getSelectedValue().getMaxMP() - equipment.getMaxMP());
        newStatsPanel.setNewAttackLabel(listPanel.equipmentJList.getSelectedValue().getAttack() - equipment.getAttack());
        newStatsPanel.setNewDefenseLabel(listPanel.equipmentJList.getSelectedValue().getDefense() - equipment.getDefense());
        newStatsPanel.setNewMagicAttackLabel(listPanel.equipmentJList.getSelectedValue().getMagicAttack() - equipment.getMagicAttack());
        newStatsPanel.setNewMagicDefenseLabel(listPanel.equipmentJList.getSelectedValue().getMagicDefense() - equipment.getMagicDefense());
        newStatsPanel.setNewSpeedLabel(listPanel.equipmentJList.getSelectedValue().getSpeed() - equipment.getSpeed());
    }

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
