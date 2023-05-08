package view.frames;

import model.entity.player.Player;
import view.panels.PlayerPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EquipmentFrame extends JFrame {

    Player player;

    JPanel currentWeaponPanel = new JPanel();
    private static final int RADIO_PANEL_WIDTH = 300;
    private static final int RADIO_PANEL_HEIGHT = 300;
    private static final int RADIO_PANEL_COLS = 3;

    JPanel buttonPanel = new JPanel();
    private static final int BUTTON_PANEL_WIDTH = RADIO_PANEL_WIDTH;
    private static final int BUTTON_PANEL_HEIGHT = 50;

    JButton submitButton = new JButton("Submit");
    JButton cancelButton = new JButton("Cancel");

    JPanel spellPanel;

    public EquipmentFrame() {

        player = PlayerPanel.getPlayer();

        //--------------------Stuff for main panel---------------------------------------
        spellPanel = new JPanel();
        spellPanel.setLayout(new BoxLayout(spellPanel, BoxLayout.Y_AXIS));
        spellPanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

        //------------------------Frame stuff---------------------------------------------
        this.add(spellPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //this.setLocationRelativeTo(MainGameFrame.getFrames()[0]);
        this.setVisible(false);
    }
}
