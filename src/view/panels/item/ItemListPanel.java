package view.panels.item;

import model.item.consumable.Consumable;
import model.item.consumable.HealingItem;
import view.frames.ItemFrame;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import java.awt.*;

public class ItemListPanel extends JPanel {

    private DefaultListModel<Consumable> healingItemsModel = new DefaultListModel<>();
    public JList<Consumable> equipmentJList;

    private final int PANEL_WIDTH = ItemFrame.SCREEN_WIDTH/2;

    public JScrollPane itemJSP;

    public ItemListPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 0, 35));

        this.setPreferredSize(new Dimension(PANEL_WIDTH, ItemFrame.SELECTION_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.YELLOW);

        loadHealingItemsModel(); // Since defaults to healing items button, have to populate before adding.

        equipmentJList = new JList<>(healingItemsModel); // equipmentJList.setModel(); to change DefaultListModel.
        equipmentJList.setVisibleRowCount(5);
        equipmentJList.setFixedCellWidth(PANEL_WIDTH - 50);
        equipmentJList.setFixedCellHeight(25);
        equipmentJList.setFocusable(false);
        // equipmentJList.addListSelectionListener(list selection listener);

        itemJSP = new JScrollPane(equipmentJList);
        this.add(itemJSP);

    }

    // --------------------------------------------- Getters ---------------------------------------------
    public DefaultListModel<Consumable> getHealingItemsModel() {
        return healingItemsModel;
    }

    // --------------------------------------------- Setters ---------------------------------------------
    public void loadHealingItemsModel() {
        healingItemsModel.clear();
        for (Consumable item: PlayerPanel.getPlayer().getConsumableItems()) {
            if (item instanceof HealingItem) {
                healingItemsModel.addElement(item);
            }
        }
    }

}
