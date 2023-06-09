package view.panels.item;

import controller.ItemController;
import model.item.consumable.AttackItem;
import model.item.consumable.Consumable;
import model.item.consumable.HealingItem;
import view.frames.ItemFrame;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import java.awt.*;

public class ItemListPanel extends JPanel {

    private DefaultListModel<Consumable> healingItemsModel = new DefaultListModel<>();
    private DefaultListModel<Consumable> attackItemsModel = new DefaultListModel<>();
    public JList<Consumable> itemJList;

    private final int PANEL_WIDTH = ItemFrame.SCREEN_WIDTH/2;

    public JScrollPane itemJSP;

    ItemController ic;

    public ItemListPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 0, 35));

        ic = new ItemController();

        this.setPreferredSize(new Dimension(PANEL_WIDTH, ItemFrame.SELECTION_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.YELLOW);

        loadHealingItemsModel(); // Since defaults to healing items button, have to populate before adding.

        itemJList = new JList<>(healingItemsModel); // itemJList.setModel(); to change DefaultListModel.
        itemJList.setVisibleRowCount(5);
        itemJList.setFixedCellWidth(PANEL_WIDTH - 50);
        itemJList.setFixedCellHeight(25);
        itemJList.setFocusable(false);
        itemJList.addListSelectionListener(ic);

        itemJSP = new JScrollPane(itemJList);
        this.add(itemJSP);

    }

    // --------------------------------------------- Getters ---------------------------------------------
    public DefaultListModel<Consumable> getHealingItemsModel() {
        return healingItemsModel;
    }
    public DefaultListModel<Consumable> getAttackItemsModel() {
        return attackItemsModel;
    }

    // --------------------------------------------- Setters ---------------------------------------------
    public void loadHealingItemsModel() {
        healingItemsModel.clear();
        // Add healing items in player's consumable items list to the model
        for (Consumable item: PlayerPanel.getPlayer().getConsumableItems()) {
            if (item instanceof HealingItem) {
                healingItemsModel.addElement(item);
            }
        }
    }

    public void loadAttackItemsModel() {
        attackItemsModel.clear();
        // Add healing items in player's consumable items list to the model
        for (Consumable item: PlayerPanel.getPlayer().getConsumableItems()) {
            if (item instanceof AttackItem) {
                attackItemsModel.addElement(item);
            }
        }
    }

}
