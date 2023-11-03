package view.panels.sell;

import collections.shop.ShopCollection;
import controller.SellController;
import model.item.consumable.AttackItem;
import model.item.consumable.HealingItem;
import model.item.equipment.*;
import view.frames.SellFrame;

import javax.swing.*;
import java.awt.*;

public class SellListPanel extends JPanel {

    private DefaultListModel<String> weaponsModel = new DefaultListModel<>();
    private DefaultListModel<String> headGearsModel = new DefaultListModel<>();
    private DefaultListModel<String> armorsModel = new DefaultListModel<>();
    private DefaultListModel<String> armsModel = new DefaultListModel<>();
    private DefaultListModel<String> footWearsModel = new DefaultListModel<>();
    private DefaultListModel<String> accessoriesModel = new DefaultListModel<>();
    private DefaultListModel<String> attackItemsModel = new DefaultListModel<>();
    private DefaultListModel<String> healItemsModel = new DefaultListModel<>();

    private JList<String> itemJList;
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

    public JList<String> getItemJList() {
        return itemJList;
    }

    public JButton getSellButton() {
        return sellButton;
    }

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

    public DefaultListModel<String> getAttackItemsModel() {
        return attackItemsModel;
    }

    public DefaultListModel<String> getHealItemsModel() {
        return healItemsModel;
    }

    // --------------------------------------------- Setters ---------------------------------------------
    public void loadWeaponsModel() {
        this.getWeaponsModel().clear();
        for (Weapon weapon: shopCollection.getWeaponsArray()) {
            weaponsModel.addElement(shopCollection.generateKey(weapon));
        }
        itemJList.setModel(this.getWeaponsModel());
    }

    public void loadHeadGearsModel() {
        this.getHeadGearsModel().clear();
        for (Head head: shopCollection.getHeadGearsArray()) {
            headGearsModel.addElement(shopCollection.generateKey(head));
        }
        itemJList.setModel(this.getHeadGearsModel());
    }

    public void loadArmorsModel() {
        this.getArmorsModel().clear();
        for (Body armor: shopCollection.getArmorArray()) {
            armorsModel.addElement(shopCollection.generateKey(armor));
        }
        itemJList.setModel(this.getArmorsModel());
    }

    public void loadArmsModel() {
        this.getArmsModel().clear();
        for (Arm arm: shopCollection.getArmArray()) {
            armsModel.addElement(shopCollection.generateKey(arm));
        }
        itemJList.setModel(this.getArmsModel());
    }

    public void loadFootWearsModel() {
        this.getFootWearsModel().clear();
        for (Feet footWear: shopCollection.getFootWearsArray()) {
            footWearsModel.addElement(shopCollection.generateKey(footWear));
        }
        itemJList.setModel(this.getFootWearsModel());
    }

    public void loadAccessoriesModel() {
        this.getAccessoriesModel().clear();
        for (Accessory accessory: shopCollection.getAccessoriesArray()) {
            accessoriesModel.addElement(shopCollection.generateKey(accessory));
        }
        itemJList.setModel(this.getAccessoriesModel());
    }

    public void loadAttackItemsModel() {
        this.getAttackItemsModel().clear();
        for (AttackItem attackItem: shopCollection.getAttackItemsArray()) {
            attackItemsModel.addElement(shopCollection.generateKey(attackItem));
        }
        itemJList.setModel(this.getAttackItemsModel());
    }

    public void loadHealItemsModel() {
        this.getHealItemsModel().clear();
        for (HealingItem healingItem: shopCollection.getHealingItemsArray()) {
            healItemsModel.addElement(shopCollection.generateKey(healingItem));
        }
        itemJList.setModel(this.getHealItemsModel());
    }

}
