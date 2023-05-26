package controller;

import collections.equipment.WeaponCollection;
import model.entity.player.Player;
import view.frames.EquipmentFrame;
import view.panels.equipment.ButtonPanel;
import view.panels.equipment.EquipListPanel;
import view.panels.equipment.EquipRadioButtonPanel;
import view.panels.equipment.NewStatsPanel;
import view.panels.game.PlayerPanel;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipmentController implements ActionListener, ListSelectionListener {

    Player player;
    EquipmentFrame equipmentFrame;
    EquipRadioButtonPanel radioPanel;
    ButtonPanel buttonPanel;
    EquipListPanel listPanel;
    NewStatsPanel newStatsPanel;

    public EquipmentController() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // TODO: Add functions for other radio buttons

        player = PlayerPanel.getPlayer();
        equipmentFrame = ActionButtonController.equipmentFrame;
        radioPanel = equipmentFrame.equipRadioButtonPanel;
        buttonPanel = equipmentFrame.buttonPanel;
        listPanel = equipmentFrame.equipListPanel;

        // ------------------------- JButtons ------------------------------------
        if (e.getSource() == buttonPanel.getSubmitButton()) {
            equipmentFrame.dispose();
            listPanel.equipmentJList.clearSelection();
        // TODO: Maybe don't need cancel button
        } else if (e.getSource() == buttonPanel.getCancelButton()) {
            equipmentFrame.dispose();
            radioPanel.equipButtons.clearSelection();
        } else if (e.getSource() == listPanel.equipButton) {
            System.out.println("You clicked");
            // TODO: set current stats and equip item
            // TODO: refresh the list with non-equipped items
        // --------------------- Radio Buttons ------------------------------------
        } if (radioPanel.weaponButton.isSelected()) {
            listPanel.loadWeaponsModel();
            listPanel.equipmentJList.setModel(listPanel.weaponsModel);
            /*
            System.out.println("Weapon Picked!!");
            player.equipWeapon(player.getWeapons().get(player.getWeapons().indexOf(WeaponCollection.DAGGER)));
            System.out.println("You equipped a dagger.");
            */
        } if (radioPanel.headButton.isSelected()) {
            listPanel.loadHeadGearsModel();
            listPanel.equipmentJList.setModel(listPanel.headGearsModel);
        } if (radioPanel.bodyButton.isSelected()) {
            listPanel.loadArmorsModel();
            listPanel.equipmentJList.setModel(listPanel.armorsModel);
        } if (radioPanel.armButton.isSelected()) {
            listPanel.loadArmsModel();
            listPanel.equipmentJList.setModel(listPanel.armsModel);
        } if (radioPanel.feetButton.isSelected()) {
            listPanel.loadFootWearsModel();
            listPanel.equipmentJList.setModel(listPanel.footWearsModel);
        } if (radioPanel.accessoryButton.isSelected()) {
            listPanel.loadAccessoriesModel();
            listPanel.equipmentJList.setModel(listPanel.accessoriesModel);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        player = PlayerPanel.getPlayer();
        radioPanel = ActionButtonController.equipmentFrame.equipRadioButtonPanel;
        listPanel = ActionButtonController.equipmentFrame.equipListPanel;
        newStatsPanel = ActionButtonController.equipmentFrame.newStatsPanel;

        if (e.getValueIsAdjusting()) {
            System.out.println(listPanel.equipmentJList.getSelectedValue());
            // TODO: Set stats for new stats panel
            newStatsPanel.setNewMaxHPLabel();
        }

    }
}
