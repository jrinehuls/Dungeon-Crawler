package view.frames;

import controller.SellController;
import view.panels.sell.*;

import javax.swing.*;
import java.awt.*;

public class SellFrame extends JFrame {

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT= 600;
    public static final int LEFT_PANEL_WIDTH = SCREEN_WIDTH / 2;
    public static final int RIGHT_PANEL_WIDTH = SCREEN_WIDTH - LEFT_PANEL_WIDTH;

    public static final int RADIO_PANEL_HEIGHT = 200;
    public static final int STATS_PANEL_HEIGHT = (SCREEN_HEIGHT - RADIO_PANEL_HEIGHT) / 2;

    public static final int TABLE_PANEL_HEIGHT = 400;
    public static final int BUTTON_PANEL_HEIGHT = SCREEN_HEIGHT - TABLE_PANEL_HEIGHT;

    private final SellRadioButtonPanel radioButtonPanel;
    private final SellCurrentStatsPanel currentStatsPanel = new SellCurrentStatsPanel();
    private final SellNewStatsPanel newStatsPanel = new SellNewStatsPanel();

    private final SellListPanel listPanel;
    private final SellButtonPanel buttonPanel;

    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();

    SellController sc;

    public SellFrame() {
        super("Sell Somethin', Will Ya?");

        sc = new SellController(this);
        radioButtonPanel = new SellRadioButtonPanel(sc);
        listPanel = new SellListPanel(sc);
        buttonPanel = new SellButtonPanel(sc);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        // ------------------------------------ Left Panel Stuff ------------------------------------
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setPreferredSize(new Dimension(LEFT_PANEL_WIDTH, SCREEN_HEIGHT));
        leftPanel.setBackground(Color.GREEN);
        leftPanel.add(radioButtonPanel);
        leftPanel.add(currentStatsPanel);
        leftPanel.add(newStatsPanel);
        this.add(leftPanel);
        // ------------------------------------ Right Panel Stuff ------------------------------------
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setPreferredSize(new Dimension(RIGHT_PANEL_WIDTH, SCREEN_HEIGHT));
        rightPanel.setBackground(Color.RED);
        rightPanel.add(listPanel);
        rightPanel.add(buttonPanel);
        this.add(rightPanel);

        // --------------------------------------- Frame Stuff ----------------------------------------
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setIconImage(new ImageIcon("res/icons/Icon.png").getImage());
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public SellRadioButtonPanel getRadioButtonPanel() {
        return this.radioButtonPanel;
    }

    public SellCurrentStatsPanel getCurrentStatsPanel() {
        return this.currentStatsPanel;
    }

    public SellNewStatsPanel getNewStatsPanel() {
        return this.newStatsPanel;
    }

    public SellListPanel getListPanel() {
        return this.listPanel;
    }

    public SellButtonPanel getButtonPanel() {
        return this.buttonPanel;
    }
}
