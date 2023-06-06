package view.frames;

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
    public EquipRadioButtonPanel equipRadioButtonPanel;
    public EquipListPanel equipListPanel;

    //------------- MIDDLE ---------------------------------------
    JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    public static final int STATS_PANEL_HEIGHT = 150;
    public CurrentStatsPanel currentStatsPanel;
    public NewStatsPanel newStatsPanel;

    //------------- BOTTOM ---------------------------------------
    public static final int BUTTON_PANEL_HEIGHT = 80;
    public EquipButtonPanel equipButtonPanel;


    public EquipmentFrame() {

        // EquipmentController ec = new EquipmentController(this);

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
        equipButtonPanel = new EquipButtonPanel();
        equipmentPanel.add(equipButtonPanel);

        //------------------------Frame stuff---------------------------------------------
        this.add(equipmentPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setIconImage(new ImageIcon("res/icons/Icon.png").getImage());
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        // this.setLocationRelativeTo(MainGameFrame.getFrames()[0]);
        // this.setVisible(false);
        this.setVisible(false);
    }



}
