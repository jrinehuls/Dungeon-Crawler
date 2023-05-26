package view.panels.equipment;

import controller.EquipmentController;
import model.item.equipment.*;
import view.frames.EquipmentFrame;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import java.awt.*;

public class EquipListPanel extends JPanel {

    public DefaultListModel<Equipment> weaponsModel = new DefaultListModel<>();
    public DefaultListModel<Equipment> headGearsModel = new DefaultListModel<>();
    public DefaultListModel<Equipment> armorsModel = new DefaultListModel<>();
    public DefaultListModel<Equipment> armsModel = new DefaultListModel<>();
    public DefaultListModel<Equipment> footWearsModel = new DefaultListModel<>();
    public DefaultListModel<Equipment> accessoriesModel = new DefaultListModel<>();

    public JList<Equipment> equipmentJList;

    public JScrollPane equipmentJSP;

    public JButton equipButton = new JButton("Equip");

    EquipmentController ec;

    public EquipListPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 0, 10));

        ec = new EquipmentController();

        this.setPreferredSize(new Dimension(EquipmentFrame.SCREEN_WIDTH/2, EquipmentFrame.SELECTION_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.YELLOW);

        loadWeaponsModel(); // Since defaults to weapons button, have to populate before adding.

        equipmentJList = new JList<>(weaponsModel); // equipmentJList.setModel(); to change DefaultListModel.
        equipmentJList.setVisibleRowCount(5);
        equipmentJList.setFixedCellWidth(250);
        equipmentJList.setFixedCellHeight(25);
        equipmentJList.setFocusable(false);
        equipmentJList.addListSelectionListener(ec);

        equipmentJSP = new JScrollPane(equipmentJList);
        this.add(equipmentJSP);

        equipButton.setPreferredSize(new Dimension(100, 30));
        equipButton.addActionListener(ec);
        this.add(equipButton);
        // -------------------------- this.remove(equipmentJSP); --------------------------------------------
    }

    public void loadWeaponsModel() {
        weaponsModel.clear();
        for (Weapon weapon: PlayerPanel.getPlayer().getWeapons()) {
            weaponsModel.addElement(weapon);
        }
    }

    public void loadHeadGearsModel() {
        headGearsModel.clear();
        for (Head head: PlayerPanel.getPlayer().getHeadGears()) {
            headGearsModel.addElement(head);
        }
    }

    public void loadArmorsModel() {
        armorsModel.clear();
        for (Body body: PlayerPanel.getPlayer().getArmors()) {
            armorsModel.addElement(body);
        }
    }

    public void loadArmsModel() {
        armsModel.clear();
        for (Arm arm: PlayerPanel.getPlayer().getArms()) {
            armsModel.addElement(arm);
        }
    }

    public void loadFootWearsModel() {
        footWearsModel.clear();
        for (Feet foot: PlayerPanel.getPlayer().getFootWears()) {
            footWearsModel.addElement(foot);
        }
    }

    public void loadAccessoriesModel() {
        accessoriesModel.clear();
        for (Accessory accessory: PlayerPanel.getPlayer().getAccessories()) {
            accessoriesModel.addElement(accessory);
        }
    }





}
