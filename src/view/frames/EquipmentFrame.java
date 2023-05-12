package view.frames;

import model.entity.player.Player;
import view.panels.PlayerPanel;
import view.panels.equipment.*;

import javax.swing.*;
import java.awt.*;

public class EquipmentFrame extends JFrame {

    // Player player; Instantiate in constructor

    public static final int SCREEN_WIDTH = 700;
    JPanel equipmentPanel;

    //------------- TOP ------------------------------------------
    JPanel selectionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    public static final int SELECTION_PANEL_HEIGHT = 200;
    EquipRadioButtonPanel equipRadioButtonPanel;
    EquipListPanel equipListPanel;

    //------------- MIDDLE ---------------------------------------
    JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    public static final int STATS_PANEL_HEIGHT = 150;
    CurrentStatsPanel currentStatsPanel;
    NewStatsPanel newStatsPanel;

    //------------- BOTTOM ---------------------------------------
    public static final int BUTTON_PANEL_HEIGHT = 80;
    ButtonPanel buttonPanel;


    public EquipmentFrame() {

        // --------------------Stuff for main panel---------------------------------------
        equipmentPanel = new JPanel();
        equipmentPanel.setLayout(new BoxLayout(equipmentPanel, BoxLayout.Y_AXIS));

        // --------------------Stuff for selection panel (TOP)---------------------------------------
        selectionPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, SELECTION_PANEL_HEIGHT));

        equipRadioButtonPanel = new EquipRadioButtonPanel();
        equipListPanel = new EquipListPanel();

        selectionPanel.add(equipRadioButtonPanel);
        selectionPanel.add(equipListPanel);
        equipmentPanel.add(selectionPanel);

        //--------------------Stuff for stats panel (MIDDLE)---------------------------------------
        statsPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, STATS_PANEL_HEIGHT));

        currentStatsPanel = new CurrentStatsPanel();
        newStatsPanel = new NewStatsPanel();

        statsPanel.add(currentStatsPanel);
        statsPanel.add(newStatsPanel);
        equipmentPanel.add(statsPanel);

        //--------------------Stuff for button panel (BOTTOM)---------------------------------------
        buttonPanel = new ButtonPanel();
        equipmentPanel.add(buttonPanel);

        //------------------------Frame stuff---------------------------------------------
        this.add(equipmentPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        // this.setLocationRelativeTo(MainGameFrame.getFrames()[0]);
        // this.setVisible(false);
        this.setVisible(true);
    }

}
