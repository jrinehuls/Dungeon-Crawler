package view.panels.equipment;

import model.item.equipment.Equipment;
import model.item.equipment.Weapon;
import view.frames.EquipmentFrame;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import java.awt.*;

public class EquipListPanel extends JPanel {

    public DefaultListModel<Equipment> emptyModel = new DefaultListModel<>();
    public DefaultListModel<Equipment> weaponsModel = new DefaultListModel<>();

    public JList<Equipment> equipmentJList;

    public JScrollPane equipmentJSP;

    public EquipListPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 0, 25));

        this.setPreferredSize(new Dimension(EquipmentFrame.SCREEN_WIDTH/2, EquipmentFrame.SELECTION_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.YELLOW);

        for (Weapon weapon: PlayerPanel.getPlayer().getWeapons()) {
            weaponsModel.addElement(weapon);
        }

        equipmentJList = new JList<>(emptyModel); // equipmentJList.setModel(); to change DefaultListModel.
        equipmentJList.setVisibleRowCount(6);
        equipmentJList.setFixedCellWidth(250);
        equipmentJList.setFixedCellHeight(25);
        equipmentJList.setFocusable(false);

        equipmentJSP = new JScrollPane(equipmentJList);
        this.add(equipmentJSP);
        // -------------------------- this.remove(jsp); --------------------------------------------


    }
}
