package controller;

import model.entity.player.Player;
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
    ItemButtonPanel itemButtonPanel;
    ItemListPanel itemListPanel;
    ItemRadioButtonPanel itemRadioButtonPanel;
    boolean itemUsed;

    public ItemController() {
        // TODO: maybe make itemUsed false here.
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
            if (MonsterPanel.isMonster() && itemUsed) {
                player.setProgress(0);
            }
            itemFrame.dispose();
        } if (e.getSource() == itemButtonPanel.getUseButton()) {
            // TODO: if clicked and something used, set itemUsed to true.
            System.out.println("Item used");
        }
        // --------------------- Radio Buttons ------------------------------------

        if (e.getSource() == itemRadioButtonPanel.healingItemsButton) {
            
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        itemFrame = ActionButtonController.itemFrame;
        itemRadioButtonPanel = itemFrame.itemRadioButtonPanel;
        itemListPanel = itemFrame.itemListPanel;

        if (e.getValueIsAdjusting()) {
            if (itemRadioButtonPanel.healingItemsButton.isSelected()) {

            }
        }
    }
}
