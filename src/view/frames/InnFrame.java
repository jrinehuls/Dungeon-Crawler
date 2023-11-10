package view.frames;

import controller.InnController;
import view.panels.inn.InnButtonPanel;
import view.panels.inn.InnCurrentStatsPanel;
import view.panels.inn.InnNewStatsPanel;
import view.panels.inn.InnRadioButtonPanel;

import javax.swing.*;
import java.awt.*;

public class InnFrame extends JFrame {

    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT= 400;
    public static final int PANEL_WIDTH = SCREEN_WIDTH / 2;
    public static final int PANEL_HEIGHT = SCREEN_HEIGHT;

    private final InnCurrentStatsPanel currentStatsPanel = new InnCurrentStatsPanel();
    private final InnNewStatsPanel newStatsPanel = new InnNewStatsPanel();

    private final InnRadioButtonPanel radioButtonPanel;
    private final InnButtonPanel buttonPanel;

    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();

    InnController ic;

    public InnFrame() {
        super("Stay Here, Will Ya?");

        ic = new InnController(this);
        radioButtonPanel = new InnRadioButtonPanel(ic);
        buttonPanel = new InnButtonPanel(ic);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        // ------------------------------------ Left Panel Stuff ------------------------------------
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setPreferredSize(new Dimension(PANEL_WIDTH, SCREEN_HEIGHT));
        leftPanel.setBackground(Color.GREEN);
        leftPanel.add(currentStatsPanel);
        leftPanel.add(newStatsPanel);
        this.add(leftPanel);
        // ------------------------------------ Right Panel Stuff ------------------------------------
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setPreferredSize(new Dimension(PANEL_WIDTH, SCREEN_HEIGHT));
        rightPanel.setBackground(Color.RED);
        rightPanel.add(radioButtonPanel);
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


    public InnCurrentStatsPanel getCurrentStatsPanel() {
        return this.currentStatsPanel;
    }

    public InnNewStatsPanel getNewStatsPanel() {
        return this.newStatsPanel;
    }

    public InnRadioButtonPanel getRadioButtonPanel() {
        return this.radioButtonPanel;
    }

    public InnButtonPanel getButtonPanel() {
        return this.buttonPanel;
    }

}
