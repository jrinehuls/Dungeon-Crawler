package view.panels.buy;

import collections.equipment.WeaponCollection;
import collections.shop.ShopCollection;
import model.item.Item;
import model.item.equipment.*;
import model.spell.HealSpell;
import model.spell.Spell;
import view.frames.BuyFrame;
import view.panels.game.PlayerPanel;

import javax.swing.*;

import java.awt.*;
import java.util.Map;

public class BuyListPanel extends JPanel {

    private DefaultListModel<String> weaponsModel = new DefaultListModel<>();
    private DefaultListModel<String> headGearsModel = new DefaultListModel<>();
    private DefaultListModel<String> armorsModel = new DefaultListModel<>();
    private DefaultListModel<String> armsModel = new DefaultListModel<>();
    private DefaultListModel<String> footWearsModel = new DefaultListModel<>();
    private DefaultListModel<String> accessoriesModel = new DefaultListModel<>();
    private DefaultListModel<String> attackModel = new DefaultListModel<>();
    private DefaultListModel<String> healModel = new DefaultListModel<>();

    public JList<String> itemJList;
    public JScrollPane itemJSP;

    private ShopCollection shopCollection = new ShopCollection();

    public BuyListPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 0, 0));

        int PANEL_WIDTH = BuyFrame.RIGHT_PANEL_WIDTH;

        this.setPreferredSize(new Dimension(PANEL_WIDTH, BuyFrame.TABLE_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.ORANGE);

        loadWeaponsModel(); // Since defaults to weapons button, have to populate before adding.

        itemJList = new JList<>(weaponsModel); // equipmentJList.setModel(); to change DefaultListModel.
        itemJList.setVisibleRowCount(5);
        itemJList.setFixedCellWidth(PANEL_WIDTH - 100);
        itemJList.setFixedCellHeight(25);
        itemJList.setFocusable(false);
        //equipmentJList.addListSelectionListener(ec);

        itemJSP = new JScrollPane(itemJList);
        this.add(itemJSP);

    }


    // --------------------------------------------- Getters ---------------------------------------------
    public DefaultListModel<String> getWeaponsModel() {
        return weaponsModel;
    }

    public DefaultListModel<String> getHeadGearsModel() {
        return headGearsModel;
    }

    public DefaultListModel<String> getArmorsModel() {
        return armorsModel;
    }

    public DefaultListModel<String> getArmsModel() {
        return armsModel;
    }

    public DefaultListModel<String> getFootWearsModel() {
        return footWearsModel;
    }

    public DefaultListModel<String> getAccessoriesModel() {
        return accessoriesModel;
    }

    // --------------------------------------------- Setters ---------------------------------------------
    public void loadWeaponsModel() {
        for (Item weapon: shopCollection.getWeaponsArray()) {
            weaponsModel.addElement(shopCollection.generateKey(weapon));
        }
    }

    public void loadHeadGearsModel() {

    }

    public void loadArmorsModel() {

    }

    public void loadArmsModel() {

    }

    public void loadFootWearsModel() {

    }

    public void loadAccessoriesModel() {

    }


}
