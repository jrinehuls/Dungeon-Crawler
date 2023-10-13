package view.panels.buy;

import collections.equipment.WeaponCollection;
import model.item.Item;
import model.item.equipment.*;
import view.frames.BuyFrame;
import view.panels.game.PlayerPanel;

import javax.swing.*;

import java.awt.*;

public class BuyListPanel extends JPanel {

    private DefaultListModel<Item> weaponsModel = new DefaultListModel<>();
    private DefaultListModel<Item> headGearsModel = new DefaultListModel<>();
    private DefaultListModel<Item> armorsModel = new DefaultListModel<>();
    private DefaultListModel<Item> armsModel = new DefaultListModel<>();
    private DefaultListModel<Item> footWearsModel = new DefaultListModel<>();
    private DefaultListModel<Item> accessoriesModel = new DefaultListModel<>();

    private final int PANEL_WIDTH = BuyFrame.RIGHT_PANEL_WIDTH;

    public JList<Item> equipmentJList;

    public JScrollPane equipmentJSP;

    public BuyListPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 0, 0));

        this.setPreferredSize(new Dimension(PANEL_WIDTH, BuyFrame.TABLE_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.ORANGE);

        loadWeaponsModel(); // Since defaults to weapons button, have to populate before adding.

        equipmentJList = new JList<>(weaponsModel); // equipmentJList.setModel(); to change DefaultListModel.
        equipmentJList.setVisibleRowCount(5);
        equipmentJList.setFixedCellWidth(PANEL_WIDTH - 100);
        equipmentJList.setFixedCellHeight(25);
        equipmentJList.setFocusable(false);
        //equipmentJList.addListSelectionListener(ec);

        equipmentJSP = new JScrollPane(equipmentJList);
        this.add(equipmentJSP);

    }


    // --------------------------------------------- Getters ---------------------------------------------
    public DefaultListModel<Item> getWeaponsModel() {
        return weaponsModel;
    }

    public DefaultListModel<Item> getHeadGearsModel() {
        return headGearsModel;
    }

    public DefaultListModel<Item> getArmorsModel() {
        return armorsModel;
    }

    public DefaultListModel<Item> getArmsModel() {
        return armsModel;
    }

    public DefaultListModel<Item> getFootWearsModel() {
        return footWearsModel;
    }

    public DefaultListModel<Item> getAccessoriesModel() {
        return accessoriesModel;
    }

    // --------------------------------------------- Setters ---------------------------------------------
    public void loadWeaponsModel() {
        weaponsModel.addElement(WeaponCollection.WOODEN_DAGGER);
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
