package controller;

import controller.game.ActionButtonController;
import model.entity.player.Player;
import model.item.equipment.*;
import view.frames.BuyFrame;
import view.panels.buy.*;
import view.panels.game.PlayerPanel;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class BuyController implements ActionListener, ListSelectionListener {

    Player player;
    BuyFrame buyFrame;
    BuyRadioButtonPanel radioPanel;
    BuyCurrentStatsPanel currentStatsPanel;
    BuyNewStatsPanel newStatsPanel;
    BuyListPanel listPanel;
    BuyButtonPanel buttonPanel;
    public BuyController(BuyFrame buyFrame) {
        this.buyFrame = buyFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.player = PlayerPanel.getPlayer();
        this.radioPanel = buyFrame.getRadioButtonPanel();
        this.currentStatsPanel = buyFrame.getCurrentStatsPanel();
        this.newStatsPanel = buyFrame.getNewStatsPanel();
        this.listPanel = buyFrame.getListPanel();
        this.buttonPanel = buyFrame.getButtonPanel();

        this.setJListModel(e);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        player = PlayerPanel.getPlayer();
        radioPanel = buyFrame.getRadioButtonPanel();
        listPanel = buyFrame.getListPanel();
        newStatsPanel = buyFrame.getNewStatsPanel();

        if (e.getValueIsAdjusting()) {
            if (radioPanel.getWeaponButton().isSelected()) {
                updateNewStats(player.getWeapon());
            } else if (radioPanel.getHeadButton().isSelected()) {
                updateNewStats(player.getHeadGear());
            } else if (radioPanel.getBodyButton().isSelected()) {
                updateNewStats(player.getArmor());
            } else if (radioPanel.getArmButton().isSelected()) {
                updateNewStats(player.getArm());
            } else if (radioPanel.getFeetButton().isSelected()) {
                updateNewStats(player.getFootwear());
            } else if (radioPanel.getAccessoryButton().isSelected()) {
                updateNewStats(player.getAccessory());
            }
        }
    }

    private void setJListModel(ActionEvent e) {
        if (e.getSource() == radioPanel.getWeaponButton()) {
            listPanel.loadWeaponsModel();
        }
        if (e.getSource() == radioPanel.getHeadButton()) {
            listPanel.loadHeadGearsModel();
        }
        if (e.getSource() == radioPanel.getBodyButton()) {
            listPanel.loadArmorsModel();
        }
        if (e.getSource() == radioPanel.getArmButton()) {
            listPanel.loadArmsModel();
        }
        if (e.getSource() == radioPanel.getFeetButton()) {
            listPanel.loadFootWearsModel();
        }
        if (e.getSource() == radioPanel.getAccessoryButton()) {
            listPanel.loadAccessoriesModel();
        }
        if (e.getSource() == radioPanel.getAttackButton()) {
            listPanel.loadAttackItemsModel();
        }
        if (e.getSource() == radioPanel.getHealingButton()) {
            listPanel.loadHealItemsModel();
        }
    }

    // When a selection is highlighted, shows what the stats will be if that item is equipped
    private void updateNewStats(Equipment equipment) {
        String key = listPanel.getItemJList().getSelectedValue();
        HashMap<String, Equipment> equipmentMap;
        
        if (equipment instanceof Weapon) {
            equipmentMap = listPanel.getShopCollection().getWeaponsMap();
        } else if (equipment instanceof Head) {
            equipmentMap = listPanel.getShopCollection().getHeadGearsMap();
        } else if (equipment instanceof Body) {
            equipmentMap = listPanel.getShopCollection().getArmorMap();
        } else if (equipment instanceof Arm) {
            equipmentMap = listPanel.getShopCollection().getArmMap();
        } else if (equipment instanceof Feet) {
            equipmentMap = listPanel.getShopCollection().getFootWearsMap();
        } else {
            equipmentMap = listPanel.getShopCollection().getAccessoriesMap();
        }

        newStatsPanel.setNewMaxHPLabel(equipmentMap.get(key).getMaxHP() - equipment.getMaxHP());
        newStatsPanel.setNewMaxMPLabel(equipmentMap.get(key).getMaxMP() - equipment.getMaxMP());
        newStatsPanel.setNewAttackLabel(equipmentMap.get(key).getAttack() - equipment.getAttack());
        newStatsPanel.setNewDefenseLabel(equipmentMap.get(key).getDefense() - equipment.getDefense());
        newStatsPanel.setNewMagicAttackLabel(equipmentMap.get(key).getMagicAttack() - equipment.getMagicAttack());
        newStatsPanel.setNewMagicDefenseLabel(equipmentMap.get(key).getMagicDefense() - equipment.getMagicDefense());
        newStatsPanel.setNewSpeedLabel(equipmentMap.get(key).getSpeed() - equipment.getSpeed());

    }


}
