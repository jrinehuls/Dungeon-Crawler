package view.panels.equipment;

import controller.EquipmentController;
import view.frames.EquipmentFrame;

import javax.swing.*;
import java.awt.*;

public class EquipRadioButtonPanel extends JPanel {

    public ButtonGroup equipButtons = new ButtonGroup();

    public final JRadioButton weaponButton = new JRadioButton("Weapon: "); // If weaponButton.isSelected()
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

    EquipmentController ec = new EquipmentController();

    public EquipRadioButtonPanel() {
        super(new GridLayout(6, 2, 0, 0));

        this.setPreferredSize(new Dimension(EquipmentFrame.SCREEN_WIDTH /2, EquipmentFrame.SELECTION_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.RED);

        for (Component component: equipButtonComponents) {
            if (component instanceof JRadioButton button) {
                button.setMargin(new Insets(0, JBUTTON_LEFT_INSET,0,0));
                button.setOpaque(false);
                button.setFocusable(false);
                equipButtons.add(button);
                button.addActionListener(ec);
            }
            this.add(component);
        }
    }
}