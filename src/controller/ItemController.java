package controller;

import model.entity.player.Player;
import model.item.consumable.Consumable;
import model.item.consumable.HealingItem;
import view.frames.ItemFrame;
import view.panels.game.MonsterPanel;
import view.panels.game.PlayerPanel;
import view.panels.item.ItemButtonPanel;
import view.panels.item.ItemListPanel;
import view.panels.item.ItemRadioButtonPanel;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemController implements ActionListener, ListSelectionListener {

    Player player;
    ItemFrame itemFrame;
    ItemRadioButtonPanel itemRadioButtonPanel;
    ItemListPanel itemListPanel;
    ItemButtonPanel itemButtonPanel;
    static Consumable selectedItem = null;

    public ItemController() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player = PlayerPanel.getPlayer();
        itemFrame = ActionButtonController.itemFrame;
        itemRadioButtonPanel = itemFrame.itemRadioButtonPanel;
        itemListPanel = itemFrame.itemListPanel;
        itemButtonPanel = itemFrame.itemButtonPanel;
        // ------------------------- JButtons ------------------------------------
        if (e.getSource() == itemButtonPanel.getDoneButton()) {
            itemFrame.dispose();
        } if (e.getSource() == itemButtonPanel.getUseButton() && selectedItem != null) {
            player.useHealingItem((HealingItem) selectedItem);
            itemListPanel.loadHealingItemsModel();
            itemListPanel.itemJList.setModel(itemListPanel.getHealingItemsModel());
            selectedItem = null;
            if (MonsterPanel.isMonster()) {
                player.setProgress(0);
                itemFrame.dispose();
            }
        }
        // --------------------- Radio Buttons ------------------------------------
        if (e.getSource() == itemRadioButtonPanel.healingItemsButton) {
            itemListPanel.loadHealingItemsModel();
            itemListPanel.itemJList.setModel(itemListPanel.getHealingItemsModel());
        } if (e.getSource() == itemRadioButtonPanel.attackItemsButton) {
            itemListPanel.loadAttackItemsModel();
            itemListPanel.itemJList.setModel(itemListPanel.getAttackItemsModel());
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        itemFrame = ActionButtonController.itemFrame;
        itemRadioButtonPanel = itemFrame.itemRadioButtonPanel;
        itemListPanel = itemFrame.itemListPanel;

        if (e.getValueIsAdjusting()) {
            if (itemRadioButtonPanel.healingItemsButton.isSelected()) {
                selectedItem = itemListPanel.itemJList.getSelectedValue();
            }
        }
    }
}
