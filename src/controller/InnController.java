package controller;

import model.entity.player.Player;
import view.frames.InnFrame;
import view.frames.SellFrame;
import view.panels.inn.InnButtonPanel;
import view.panels.inn.InnCurrentStatsPanel;
import view.panels.inn.InnNewStatsPanel;
import view.panels.inn.InnRadioButtonPanel;
import view.panels.sell.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnController implements ActionListener {

    Player player;
    InnFrame innFrame;
    InnCurrentStatsPanel currentStatsPanel;
    InnNewStatsPanel newStatsPanel;
    InnRadioButtonPanel radioPanel;
    InnButtonPanel buttonPanel;
    public InnController(InnFrame innFrame) {
        this.innFrame = innFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
