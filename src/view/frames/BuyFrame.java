package view.frames;

import controller.BuyController;
import view.panels.buy.*;

import javax.swing.*;
import java.awt.*;

public class BuyFrame extends JFrame {

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT= 600;
    public static final int LEFT_PANEL_WIDTH = SCREEN_WIDTH / 2;
    public static final int RIGHT_PANEL_WIDTH = SCREEN_WIDTH - LEFT_PANEL_WIDTH;

    public static final int RADIO_PANEL_HEIGHT = 200;
    public static final int STATS_PANEL_HEIGHT = (SCREEN_HEIGHT - RADIO_PANEL_HEIGHT) / 2;

    public static final int TABLE_PANEL_HEIGHT = 400;
    public static final int BUTTON_PANEL_HEIGHT = SCREEN_HEIGHT - TABLE_PANEL_HEIGHT;

    private final BuyRadioButtonPanel radioButtonPanel;
    private final BuyCurrentStatsPanel currentStatsPanel = new BuyCurrentStatsPanel();
    private final BuyNewStatsPanel newStatsPanel = new BuyNewStatsPanel();

    private final BuyListPanel listPanel;
    private final BuyButtonPanel buttonPanel;

    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();

    BuyController bc;

    public BuyFrame() {
        super("Buy Somethin', Will Ya?");

        bc = new BuyController(this);
        radioButtonPanel = new BuyRadioButtonPanel(bc);
        listPanel = new BuyListPanel(bc);
        buttonPanel = new BuyButtonPanel(bc);

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

    public BuyRadioButtonPanel getRadioButtonPanel() {
        return this.radioButtonPanel;
    }

    public BuyCurrentStatsPanel getCurrentStatsPanel() {
        return this.currentStatsPanel;
    }

    public BuyNewStatsPanel getNewStatsPanel() {
        return this.newStatsPanel;
    }

    public BuyListPanel getListPanel() {
        return this.listPanel;
    }

    public BuyButtonPanel getButtonPanel() {
        return this.buttonPanel;
    }

}
