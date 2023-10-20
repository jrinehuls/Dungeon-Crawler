package view.panels.buy;

import controller.BuyController;
import view.frames.BuyFrame;

import javax.swing.*;
import java.awt.*;

public class BuyRadioButtonPanel extends JPanel {

    public ButtonGroup equipButtons = new ButtonGroup();

    private final JRadioButton weaponButton = new JRadioButton("Weapons"); // If weaponButton.isSelected()
    private final JRadioButton headButton = new JRadioButton("Headgear");
    private final JRadioButton bodyButton = new JRadioButton("Armor");
    private final JRadioButton armButton = new JRadioButton("Arm Guards");
    private final JRadioButton feetButton = new JRadioButton("Feet Guards");
    private final JRadioButton accessoryButton = new JRadioButton("Accessories");
    private final JRadioButton attackButton = new JRadioButton("Attack Items");
    private final JRadioButton healingButton = new JRadioButton("Healing Items");

    private static final int JBUTTON_LEFT_INSET = 20;

    JRadioButton[] equipButtonComponents = {weaponButton, headButton, bodyButton, armButton, feetButton,
            accessoryButton, attackButton, healingButton};

    public BuyRadioButtonPanel(BuyController bc) {
        super(new GridLayout(4, 2, 0, 0));

        this.setPreferredSize(new Dimension(BuyFrame.LEFT_PANEL_WIDTH, BuyFrame.RADIO_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.PINK);

        // Add components to panel. If component is a radio, add margins and stuffs.
        for (JRadioButton button: equipButtonComponents) {
            button.addActionListener(bc);
            button.setMargin(new Insets(0, JBUTTON_LEFT_INSET,0,0));
            button.setOpaque(false);
            button.setFocusable(false);
            equipButtons.add(button);
            this.add(button);
        }

        // Default to weapon radio button being selected
        weaponButton.setSelected(true);
    }

    public JRadioButton getWeaponButton() {
        return weaponButton;
    }

    public JRadioButton getHeadButton() {
        return headButton;
    }

    public JRadioButton getBodyButton() {
        return bodyButton;
    }

    public JRadioButton getArmButton() {
        return armButton;
    }

    public JRadioButton getFeetButton() {
        return feetButton;
    }

    public JRadioButton getAccessoryButton() {
        return accessoryButton;
    }

    public JRadioButton getAttackButton() {
        return attackButton;
    }

    public JRadioButton getHealingButton() {
        return healingButton;
    }
}
