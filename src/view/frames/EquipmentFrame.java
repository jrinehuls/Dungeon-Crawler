package view.frames;

import model.entity.player.Player;
import view.panels.PlayerPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipmentFrame extends JFrame implements ActionListener {

    Player player;

    JPanel currentPanel = new JPanel();
    private static final int CURRENT_PANEL_WIDTH = 300;
    private static final int CURRENT_PANEL_HEIGHT = 300;
    private static final int CURRENT_PANEL_COLS = 1;

    JPanel selectionPanel = new JPanel();
    private static final int SELECTION_PANEL_WIDTH = 300;
    private static final int SELECTION_PANEL_HEIGHT = 300;
    private static final int SELECTION_PANEL_COLS = 3;

    JPanel buttonPanel = new JPanel();
    private static final int BUTTON_PANEL_WIDTH = CURRENT_PANEL_WIDTH + SELECTION_PANEL_WIDTH;
    private static final int BUTTON_PANEL_HEIGHT = 50;

    JButton submitButton = new JButton("Submit");
    JButton cancelButton = new JButton("Cancel");

    JPanel equipmentPanel;

    public EquipmentFrame() {

        player = PlayerPanel.getPlayer();

        //--------------------Stuff for main panel---------------------------------------
        equipmentPanel = new JPanel();
        equipmentPanel.setLayout(new BoxLayout(equipmentPanel, BoxLayout.Y_AXIS));
        equipmentPanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

        //--------------------Stuff for left panel---------------------------------------

        //--------------------Stuff for right panel---------------------------------------

        //--------------------Stuff for bottom panel---------------------------------------

        //------------------------Frame stuff---------------------------------------------
        this.add(equipmentPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //this.setLocationRelativeTo(MainGameFrame.getFrames()[0]);
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
