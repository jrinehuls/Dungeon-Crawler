package controller;

import model.entity.player.Player;
import view.frames.EquipmentFrame;
import view.panels.equipment.ButtonPanel;
import view.panels.equipment.EquipListPanel;
import view.panels.equipment.EquipRadioButtonPanel;
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

    public EquipmentController() {
        System.out.println("I did stuff");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player = PlayerPanel.getPlayer();
        equipmentFrame = ActionButtonController.equipmentFrame;
        radioPanel = equipmentFrame.equipRadioButtonPanel;
        buttonPanel = equipmentFrame.buttonPanel;
        listPanel = equipmentFrame.equipListPanel;

        if (e.getSource() == buttonPanel.getSubmitButton()) {
            equipmentFrame.dispose();
            radioPanel.equipButtons.clearSelection();
        } else if (e.getSource() == buttonPanel.getCancelButton()) {
            equipmentFrame.dispose();
            radioPanel.equipButtons.clearSelection();
        } else if (radioPanel.weaponButton.isSelected()) {
            listPanel.equipmentJList.setModel(listPanel.weaponsModel);
            /*
            System.out.println("Weapon Picked!!");
            player.setWeapon(player.getWeapons().get(player.getWeapons().indexOf(WeaponCollection.DAGGER)));
            System.out.println("You equipped a dagger.");
             */
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
