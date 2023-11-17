package controller;

import main.Main;
import model.entity.player.Player;
import model.inn.CrappyRoom;
import model.inn.GoodRoom;
import model.inn.Room;
import model.item.equipment.*;
import view.frames.InnFrame;
import view.frames.MenuFrame;
import view.panels.game.PlayerPanel;
import view.panels.inn.InnButtonPanel;
import view.panels.inn.InnCurrentStatsPanel;
import view.panels.inn.InnNewStatsPanel;
import view.panels.inn.InnRadioButtonPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class InnController implements ActionListener {

    Player player;
    InnFrame innFrame;
    InnCurrentStatsPanel currentStatsPanel;
    InnNewStatsPanel newStatsPanel;
    InnRadioButtonPanel radioPanel;
    InnButtonPanel buttonPanel;
    CrappyRoom crappyRoom;
    GoodRoom goodRoom;
    public InnController(InnFrame innFrame) {
        this.innFrame = innFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.player = PlayerPanel.getPlayer();
        this.currentStatsPanel = innFrame.getCurrentStatsPanel();
        this.newStatsPanel = innFrame.getNewStatsPanel();
        this.radioPanel = innFrame.getRadioButtonPanel();
        this.buttonPanel = innFrame.getButtonPanel();
        this.crappyRoom = new CrappyRoom();
        this.goodRoom = new GoodRoom();

        if (e.getSource() == buttonPanel.getBuyButton()) {
            this.getRoom();
        } if (e.getSource() == buttonPanel.getExitButton()) {
            this.exit();
        } if (e.getSource() == radioPanel.getCrappyButton()) {
            buttonPanel.getBuyButton().setEnabled(player.getGold() >= crappyRoom.getCost());
            updateNewStats(crappyRoom);
        } if (e.getSource() == radioPanel.getGoodButton()) {
            buttonPanel.getBuyButton().setEnabled(player.getGold() >= goodRoom.getCost());
            updateNewStats(goodRoom);
        }
    }

    private void getRoom() {
        if (radioPanel.getCrappyButton().isSelected()) {
            System.out.println(radioPanel.getCrappyButton().getText());
            player.setGold(player.getGold() - crappyRoom.getCost());
            currentStatsPanel.updateLabels();
        } if (radioPanel.getGoodButton().isSelected()) {
            System.out.println(radioPanel.getGoodButton().getText());
            player.setGold(player.getGold() - goodRoom.getCost());
            currentStatsPanel.updateLabels();
        }
        currentStatsPanel.updateLabels();
        resetNewStats();
        radioPanel.getButtonGroup().clearSelection();
    }

    private void exit() {
        Main.getInnFrame().dispose();
        Main.setMenuFrame(new MenuFrame());
    }

    private void updateNewStats(Room room) {
        newStatsPanel.setNewHPLabel((int) (player.getMaxHP() * room.getHpRate()));
        newStatsPanel.setNewMPLabel((int) (player.getMaxMP() * room.getMpRate()));
        newStatsPanel.setNewGoldLabel(-room.getCost());
    }

    // If a selection is highlighted, then player clicks another radio or buys the selection,
    // set new stats to the same as player stats, also changes label colors back to black.
    private void resetNewStats() {
        newStatsPanel.setNewHPLabel(0);
        newStatsPanel.setNewMPLabel(0);
        newStatsPanel.setNewGoldLabel(0);
    }
}
