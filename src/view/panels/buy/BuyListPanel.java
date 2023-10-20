package view.panels.buy;

import collections.equipment.WeaponCollection;
import collections.shop.ShopCollection;
import controller.BuyController;
import model.item.Item;
import model.item.consumable.AttackItem;
import model.item.consumable.HealingItem;
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
    private DefaultListModel<String> attackItemsModel = new DefaultListModel<>();
    private DefaultListModel<String> healItemsModel = new DefaultListModel<>();

    private JList<String> itemJList;
    private JScrollPane itemJSP;
    private JButton buyButton = new JButton("Buy");

    private ShopCollection shopCollection = new ShopCollection();

    public BuyListPanel(BuyController bc) {
        super(new FlowLayout(FlowLayout.CENTER, 0, 10));

        int PANEL_WIDTH = BuyFrame.RIGHT_PANEL_WIDTH;

        this.setPreferredSize(new Dimension(PANEL_WIDTH, BuyFrame.TABLE_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.GREEN);

        itemJList = new JList<>(weaponsModel); // itemJList.setModel(model); to change DefaultListModel.
        itemJList.setVisibleRowCount(8);
        itemJList.setFixedCellWidth(PANEL_WIDTH - 100);
        itemJList.setFixedCellHeight(25);
        itemJList.setFocusable(false);
        itemJList.addListSelectionListener(bc);

        itemJSP = new JScrollPane(itemJList);
        this.add(itemJSP);

        buyButton.addActionListener(bc);
        buyButton.setPreferredSize(new Dimension(PANEL_WIDTH - 100, 50));
        buyButton.setFocusable(false);
        this.add(buyButton);

        loadWeaponsModel(); // Since defaults to weapons radio button.
    }

    // --------------------------------------------- Getters ---------------------------------------------


    public ShopCollection getShopCollection() {
        return shopCollection;
    }

    public JList<String> getItemJList() {
        return itemJList;
    }

    public JButton getBuyButton() {
        return buyButton;
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
