package controller;

import main.Main;
import model.entity.player.Player;
import model.inn.CrappyRoom;
import model.inn.GoodRoom;
import model.inn.MediocreRoom;
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
    MediocreRoom mediocreRoom;
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
        this.mediocreRoom = new MediocreRoom();
        this.goodRoom = new GoodRoom();

        if (e.getSource() == buttonPanel.getBuyButton()) {
            this.getRoomByRadioButton();
        } if (e.getSource() == buttonPanel.getExitButton()) {
            this.exit();
        } if (e.getSource() == radioPanel.getCrappyButton()) {
            buttonPanel.getBuyButton().setEnabled(player.getGold() >= crappyRoom.getCost());
            updateNewStats(crappyRoom);
        } if (e.getSource() == radioPanel.getMediocreButton()) {
            buttonPanel.getBuyButton().setEnabled(player.getGold() >= mediocreRoom.getCost());
            updateNewStats(mediocreRoom);
        } if (e.getSource() == radioPanel.getGoodButton()) {
            buttonPanel.getBuyButton().setEnabled(player.getGold() >= goodRoom.getCost());
            updateNewStats(goodRoom);
        }
    }

    private void getRoomByRadioButton() {
        if (radioPanel.getCrappyButton().isSelected()) {
            getRoom(crappyRoom);
        } if (radioPanel.getMediocreButton().isSelected()) {
            getRoom(mediocreRoom);
        } if (radioPanel.getGoodButton().isSelected()) {
            getRoom(goodRoom);
        }
    }

    private void getRoom(Room room) {
        player.setGold(player.getGold() - room.getCost());
        player.setHP(player.getHP() + (int) (player.getMaxHP() * room.getHpRate()));
        player.setMP(player.getMP() + (int) (player.getMaxMP() * room.getMpRate()));
        radioPanel.getButtonGroup().clearSelection();
        currentStatsPanel.updateLabels();
        this.resetNewStats();
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
