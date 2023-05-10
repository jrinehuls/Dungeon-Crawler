package view.frames;

import model.entity.player.Player;
import view.panels.PlayerPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EquipmentFrame extends JFrame {

    // Player player; Instantiate in constructor

    private static final int SCREEN_WIDTH = 700;
    JPanel equipmentPanel;
    String[] weapons = {"Dagger", "Sword", "Dagger", "Sword", "Dagger", "Sword", "Dagger", "Sword", "Dagger", "Sword", "Dagger", "Sword"};

    //------------- TOP ------------------------------------------
    JPanel selectionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    private static final int SELECTION_PANEL_HEIGHT = 200;

    JPanel equipButtonPanel = new JPanel(new GridLayout(6, 2, 0, 0));

    ButtonGroup equipButtons = new ButtonGroup();
    JRadioButton weaponButton = new JRadioButton("Weapon: ");
    JRadioButton headButton = new JRadioButton("Head: ");
    JRadioButton bodyButton = new JRadioButton("Body: ");
    JRadioButton armButton = new JRadioButton("Arm: ");
    JRadioButton feetButton = new JRadioButton("Feet: ");
    JRadioButton accessoryButton = new JRadioButton("Accessory: ");
    private static final int JBUTTON_LEFT_INSET = 50;

    JLabel weaponLabel = new JLabel("None", JLabel.LEFT);
    JLabel headLabel = new JLabel("None", JLabel.LEFT);
    JLabel bodyLabel = new JLabel("None", JLabel.LEFT);
    JLabel armLabel = new JLabel("None", JLabel.LEFT);
    JLabel feetLabel = new JLabel("None", JLabel.LEFT);
    JLabel accessoryLabel = new JLabel("None", JLabel.LEFT);

    Component[] equipButtonComponents = {weaponButton, weaponLabel, headButton, headLabel, bodyButton, bodyLabel,
    armButton, armLabel, feetButton, feetLabel, accessoryButton, accessoryLabel};

    JPanel equipListPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25));
    JList<String> equipList = new JList<>(weapons);
    JScrollPane jsp = new JScrollPane(equipList);

    //------------- MIDDLE ---------------------------------------
    JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    private static final int STATS_PANEL_HEIGHT = 150;

    JPanel currentStatsPanel = new JPanel(new GridLayout(5, 2, 0, 0));

    JLabel currentStatsLabel = new JLabel("Current Stats: ");
    JLabel currentBlankLabel = new JLabel("");
    JLabel currentMaxHPLabel = new JLabel("Max HP: ");
    JLabel currentMaxMPLabel = new JLabel("Max MP: ");
    JLabel currentAttackLabel = new JLabel("Attack: ");
    JLabel currentDefenseLabel = new JLabel("Defense: ");
    JLabel currentMagicAttackLabel = new JLabel("Magic Attack: ");
    JLabel currentMagicDefenseLabel = new JLabel("Magic Defense: ");
    JLabel currentSpeedLabel = new JLabel("Speed: ");

    JLabel[] currentStatsLabels = {currentStatsLabel, currentBlankLabel, currentMaxHPLabel, currentMaxMPLabel,
            currentAttackLabel, currentDefenseLabel, currentMagicAttackLabel, currentMagicDefenseLabel, currentSpeedLabel};

    JPanel newStatsPanel = new JPanel(new GridLayout(5, 2, 0, 0));

    JLabel newStatsLabel = new JLabel("Current Stats: ");
    JLabel newBlankLabel = new JLabel("");
    JLabel newMaxHPLabel = new JLabel("Max HP: ");
    JLabel newMaxMPLabel = new JLabel("Max MP: ");
    JLabel newAttackLabel = new JLabel("Attack: ");
    JLabel newDefenseLabel = new JLabel("Defense: ");
    JLabel newMagicAttackLabel = new JLabel("Magic Attack: ");
    JLabel newMagicDefenseLabel = new JLabel("Magic Defense: ");
    JLabel newSpeedLabel = new JLabel("Speed: ");

    JLabel[] mewStatsLabels = {newStatsLabel, newBlankLabel, newMaxHPLabel, newMaxMPLabel, newAttackLabel,
            newDefenseLabel, newMagicAttackLabel, newMagicDefenseLabel, newSpeedLabel};


    //------------- BOTTOM ---------------------------------------
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 15));
    private static final int BUTTON_PANEL_HEIGHT = 80;
    private static final int BUTTON_WIDTH = 100;
    private static final int BUTTON_HEIGHT = 50;

    JButton submitButton = new JButton("Submit");
    JButton cancelButton = new JButton("Cancel");

    // -------------Finally constructor time
    public EquipmentFrame() {

        // --------------------Stuff for main panel---------------------------------------
        equipmentPanel = new JPanel();
        equipmentPanel.setLayout(new BoxLayout(equipmentPanel, BoxLayout.Y_AXIS));
        // equipmentPanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

        // --------------------Stuff for selection panel (TOP)---------------------------------------
        selectionPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, SELECTION_PANEL_HEIGHT));
        equipButtonPanel.setPreferredSize(new Dimension(SCREEN_WIDTH/2, SELECTION_PANEL_HEIGHT));
        equipListPanel.setPreferredSize(new Dimension(SCREEN_WIDTH/2, SELECTION_PANEL_HEIGHT));
        equipButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        equipListPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        equipButtonPanel.setBackground(Color.RED);
        equipListPanel.setBackground(Color.YELLOW);

        // ------------------Add stuff to equip button panel----------------------------------------
        for (Component component: equipButtonComponents) {
            if (component instanceof JRadioButton button) {
                button.setMargin(new Insets(0, JBUTTON_LEFT_INSET,0,0));
                button.setOpaque(false);
                button.setFocusable(false);
                equipButtons.add(button);
            }
            equipButtonPanel.add(component);
        }

        // -----------------Add stuff to equip list panel------------------------------------------
        equipList.setVisibleRowCount(6);
        equipList.setFixedCellWidth(250);
        equipList.setFixedCellHeight(25);
        equipListPanel.add(jsp);

        selectionPanel.add(equipButtonPanel);
        selectionPanel.add(equipListPanel);
        equipmentPanel.add(selectionPanel);

        //--------------------Stuff for stats panel (MIDDLE)---------------------------------------
        statsPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, STATS_PANEL_HEIGHT));
        currentStatsPanel.setPreferredSize(new Dimension(SCREEN_WIDTH/2, STATS_PANEL_HEIGHT));
        newStatsPanel.setPreferredSize(new Dimension(SCREEN_WIDTH/2, STATS_PANEL_HEIGHT));
        currentStatsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        newStatsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        currentStatsPanel.setBackground(Color.GREEN);
        newStatsPanel.setBackground(Color.ORANGE);

        // TODO: add stuff to current stats panel
        int currentStatsCounter = 0;
        for (JLabel label: currentStatsLabels) {
            if (currentStatsCounter % 2 ==0) {
                label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
            }
            currentStatsPanel.add(label);
            currentStatsCounter++;
        }

        // TODO: add stuff to new stats panel
        int newStatsCounter = 0;
        for (JLabel label: mewStatsLabels) {
            if (newStatsCounter % 2 ==0) {
                label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
            }
            newStatsPanel.add(label);
            newStatsCounter++;
        }

        statsPanel.add(currentStatsPanel);
        statsPanel.add(newStatsPanel);
        equipmentPanel.add(statsPanel);

        //--------------------Stuff for button panel---------------------------------------
        buttonPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, BUTTON_PANEL_HEIGHT));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        buttonPanel.setBackground(Color.CYAN);
        submitButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        cancelButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);
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
