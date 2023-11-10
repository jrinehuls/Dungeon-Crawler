package view.panels.sell;

import collections.shop.ShopCollection;
import controller.SellController;
import model.item.Item;
import model.item.consumable.AttackItem;
import model.item.consumable.Consumable;
import model.item.consumable.HealingItem;
import model.item.equipment.*;
import view.frames.SellFrame;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import java.awt.*;

public class SellListPanel extends JPanel {

    private DefaultListModel<Item> weaponsModel = new DefaultListModel<>();
    private DefaultListModel<Item> headGearsModel = new DefaultListModel<>();
    private DefaultListModel<Item> armorsModel = new DefaultListModel<>();
    private DefaultListModel<Item> armsModel = new DefaultListModel<>();
    private DefaultListModel<Item> footWearsModel = new DefaultListModel<>();
    private DefaultListModel<Item> accessoriesModel = new DefaultListModel<>();
    private DefaultListModel<Item> attackItemsModel = new DefaultListModel<>();
    private DefaultListModel<Item> healItemsModel = new DefaultListModel<>();

    private JList<Item> itemJList;
    private JScrollPane itemJSP;
    private JButton sellButton = new JButton("Sell");

    private ShopCollection shopCollection = new ShopCollection();

    public SellListPanel(SellController sc) {
        super(new FlowLayout(FlowLayout.CENTER, 0, 10));

        int PANEL_WIDTH = SellFrame.RIGHT_PANEL_WIDTH;

        this.setPreferredSize(new Dimension(PANEL_WIDTH, SellFrame.TABLE_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.GREEN);

        itemJList = new JList<>(weaponsModel); // itemJList.setModel(model); to change DefaultListModel.
        itemJList.setVisibleRowCount(8);
        itemJList.setFixedCellWidth(PANEL_WIDTH - 100);
        itemJList.setFixedCellHeight(25);
        itemJList.setFocusable(false);
        itemJList.addListSelectionListener(sc);

        itemJSP = new JScrollPane(itemJList);
        this.add(itemJSP);

        sellButton.addActionListener(sc);
        sellButton.setPreferredSize(new Dimension(PANEL_WIDTH - 100, 50));
        sellButton.setFocusable(false);
        this.add(sellButton);

        loadWeaponsModel(); // Since defaults to weapons radio button.
    }

    // --------------------------------------------- Getters ---------------------------------------------


    public ShopCollection getShopCollection() {
        return shopCollection;
    }

    public JList<Item> getItemJList() {
        return itemJList;
    }

    public JButton getSellButton() {
        return sellButton;
    }

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

    public DefaultListModel<Item> getAttackItemsModel() {
        return attackItemsModel;
    }

    public DefaultListModel<Item> getHealItemsModel() {
        return healItemsModel;
    }

    // --------------------------------------------- Setters ---------------------------------------------
    public void loadWeaponsModel() {
        this.getWeaponsModel().clear();
        for (Weapon weapon: PlayerPanel.getPlayer().getWeapons()) {
            weaponsModel.addElement(weapon);
        }
        itemJList.setModel(this.getWeaponsModel());
    }

    public void loadHeadGearsModel() {
        this.getHeadGearsModel().clear();
        for (Head head: PlayerPanel.getPlayer().getHeadGears()) {
            headGearsModel.addElement(head);
        }
        itemJList.setModel(this.getHeadGearsModel());
    }

    public void loadArmorsModel() {
        this.getArmorsModel().clear();
        for (Body armor: PlayerPanel.getPlayer().getArmors()) {
            armorsModel.addElement(armor);
        }
        itemJList.setModel(this.getArmorsModel());
    }

    public void loadArmsModel() {
        this.getArmsModel().clear();
        for (Arm arm: PlayerPanel.getPlayer().getArms()) {
            armsModel.addElement(arm);
        }
        itemJList.setModel(this.getArmsModel());
    }

    public void loadFootWearsModel() {
        this.getFootWearsModel().clear();
        for (Feet footWear: PlayerPanel.getPlayer().getFootWears()) {
            footWearsModel.addElement(footWear);
        }
        itemJList.setModel(this.getFootWearsModel());
    }

    public void loadAccessoriesModel() {
        this.getAccessoriesModel().clear();
        for (Accessory accessory: PlayerPanel.getPlayer().getAccessories()) {
            accessoriesModel.addElement(accessory);
        }
        itemJList.setModel(this.getAccessoriesModel());
    }

    public void loadAttackItemsModel() {
        this.getAttackItemsModel().clear();
        for (Consumable consumable: PlayerPanel.getPlayer().getConsumableItems()) {
            if (consumable instanceof AttackItem attackItem) {
                attackItemsModel.addElement(attackItem);
            }
        }
        itemJList.setModel(this.getAttackItemsModel());
    }

    public void loadHealItemsModel() {
        this.getHealItemsModel().clear();
        for (Consumable consumable: PlayerPanel.getPlayer().getConsumableItems()) {
            if (consumable instanceof HealingItem healingItem) {
                healItemsModel.addElement(healingItem);
            }
        }
        itemJList.setModel(this.getHealItemsModel());
    }

}
