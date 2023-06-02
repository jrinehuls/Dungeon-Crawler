package view.panels.equipment;

import controller.EquipmentController;
import model.item.equipment.*;
import view.frames.EquipmentFrame;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import java.awt.*;

public class EquipListPanel extends JPanel {

    private DefaultListModel<Equipment> weaponsModel = new DefaultListModel<>();
    private DefaultListModel<Equipment> headGearsModel = new DefaultListModel<>();
    private DefaultListModel<Equipment> armorsModel = new DefaultListModel<>();
    private DefaultListModel<Equipment> armsModel = new DefaultListModel<>();
    private DefaultListModel<Equipment> footWearsModel = new DefaultListModel<>();
    private DefaultListModel<Equipment> accessoriesModel = new DefaultListModel<>();

    private final int PANEL_WIDTH = EquipmentFrame.SCREEN_WIDTH/2;

    public JList<Equipment> equipmentJList;

    public JScrollPane equipmentJSP;

    public JButton equipButton = new JButton("Equip");

    EquipmentController ec;

    public EquipListPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 0, 10));

        ec = new EquipmentController();

        this.setPreferredSize(new Dimension(PANEL_WIDTH, EquipmentFrame.SELECTION_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.YELLOW);

        loadWeaponsModel(); // Since defaults to weapons button, have to populate before adding.

        equipmentJList = new JList<>(weaponsModel); // equipmentJList.setModel(); to change DefaultListModel.
        equipmentJList.setVisibleRowCount(5);
        equipmentJList.setFixedCellWidth(PANEL_WIDTH - 100);
        equipmentJList.setFixedCellHeight(25);
        equipmentJList.setFocusable(false);
        equipmentJList.addListSelectionListener(ec);

        equipmentJSP = new JScrollPane(equipmentJList);
        this.add(equipmentJSP);

        equipButton.addActionListener(ec);
        equipButton.setPreferredSize(new Dimension(100, 30));
        equipButton.setFocusable(false);
        this.add(equipButton);
    }

    // --------------------------------------------- Getters ---------------------------------------------
    public DefaultListModel<Equipment> getWeaponsModel() {
        return weaponsModel;
    }

    public DefaultListModel<Equipment> getHeadGearsModel() {
        return headGearsModel;
    }

    public DefaultListModel<Equipment> getArmorsModel() {
        return armorsModel;
    }

    public DefaultListModel<Equipment> getArmsModel() {
        return armsModel;
    }

    public DefaultListModel<Equipment> getFootWearsModel() {
        return footWearsModel;
    }

    public DefaultListModel<Equipment> getAccessoriesModel() {
        return accessoriesModel;
    }

    // --------------------------------------------- Setters ---------------------------------------------
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
