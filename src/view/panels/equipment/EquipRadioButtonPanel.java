package view.panels.equipment;

import controller.EquipmentController;
import view.frames.EquipmentFrame;
import view.panels.game.GamePanel;
import view.panels.game.PlayerPanel;

import javax.swing.*;
import java.awt.*;

public class EquipRadioButtonPanel extends JPanel {

    public ButtonGroup equipButtons = new ButtonGroup();

    public final JRadioButton weaponButton = new JRadioButton("Weapon: "); // If weaponButton.isSelected()
    public final JRadioButton headButton = new JRadioButton("Head: ");
    public final JRadioButton bodyButton = new JRadioButton("Body: ");
    public final JRadioButton armButton = new JRadioButton("Arm: ");
    public final JRadioButton feetButton = new JRadioButton("Feet: ");
    public final JRadioButton accessoryButton = new JRadioButton("Accessory: ");

    public JLabel weaponLabel = new JLabel("", JLabel.LEFT);
    public JLabel headLabel = new JLabel("", JLabel.LEFT);
    public JLabel bodyLabel = new JLabel("", JLabel.LEFT);
    public JLabel armLabel = new JLabel("", JLabel.LEFT);
    public JLabel feetLabel = new JLabel("", JLabel.LEFT);
    public JLabel accessoryLabel = new JLabel("", JLabel.LEFT);

    private static final int JBUTTON_LEFT_INSET = 50;

    Component[] equipButtonComponents = {weaponButton, weaponLabel, headButton, headLabel, bodyButton, bodyLabel,
            armButton, armLabel, feetButton, feetLabel, accessoryButton, accessoryLabel};

    EquipmentController ec = new EquipmentController();

    public EquipRadioButtonPanel() {
        super(new GridLayout(6, 2, 0, 0));

        this.setPreferredSize(new Dimension(EquipmentFrame.SCREEN_WIDTH /2, EquipmentFrame.SELECTION_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.RED);

        // Add components to panel. If component is a radio, add margins and stuffs.
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

        // Default to weapon radio button being selected
        weaponButton.setSelected(true);

        weaponLabel.setText(PlayerPanel.getPlayer().getWeapon().getName());
        headLabel.setText(PlayerPanel.getPlayer().getHeadGear().getName());
        bodyLabel.setText(PlayerPanel.getPlayer().getArmor().getName());
        armLabel.setText(PlayerPanel.getPlayer().getArm().getName());
        feetLabel.setText(PlayerPanel.getPlayer().getFootwear().getName());
        accessoryLabel.setText(PlayerPanel.getPlayer().getAccessory().getName());

    }
}
