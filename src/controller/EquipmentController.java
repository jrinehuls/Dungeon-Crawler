package controller;

import model.entity.player.Player;
import model.item.equipment.Weapon;
import view.frames.EquipmentFrame;
import view.panels.PlayerPanel;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipmentController implements ActionListener, ListSelectionListener {

    Player player;

    public EquipmentController() {
        System.out.println("I did stuff");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player = PlayerPanel.getPlayer();
        EquipmentFrame equipmentFrame = ActionButtonController.equipmentFrame;

        if (e.getSource() == equipmentFrame.buttonPanel.getSubmitButton()) {
            player.setWeapon((Weapon) player.getEquipment().get(0));
            System.out.println("You equipped a dagger.");
            equipmentFrame.dispose();
            equipmentFrame.equipRadioButtonPanel.equipButtons.clearSelection();
        } else if (e.getSource() == equipmentFrame.buttonPanel.getCancelButton()) {
            equipmentFrame.dispose();
            equipmentFrame.equipRadioButtonPanel.equipButtons.clearSelection();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
