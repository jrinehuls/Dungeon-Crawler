package view.panels.sell;

import controller.SellController;
import view.frames.SellFrame;

import javax.swing.*;
import java.awt.*;

public class SellRadioButtonPanel extends JPanel {


    private ButtonGroup buttonGroup = new ButtonGroup();

    private final JRadioButton weaponButton = new JRadioButton("Weapons"); // If weaponButton.isSelected()
    private final JRadioButton headButton = new JRadioButton("Headgear");
    private final JRadioButton bodyButton = new JRadioButton("Armor");
    private final JRadioButton armButton = new JRadioButton("Arm Guards");
    private final JRadioButton feetButton = new JRadioButton("Feet Guards");
    private final JRadioButton accessoryButton = new JRadioButton("Accessories");
    private final JRadioButton attackButton = new JRadioButton("Attack Items");
    private final JRadioButton healingButton = new JRadioButton("Healing Items");

    private static final int JBUTTON_LEFT_INSET = 20;

    JRadioButton[] radioButtons = {weaponButton, headButton, bodyButton, armButton, feetButton,
            accessoryButton, attackButton, healingButton};

    public SellRadioButtonPanel(SellController bc) {
        super(new GridLayout(4, 2, 0, 0));

        this.setPreferredSize(new Dimension(SellFrame.LEFT_PANEL_WIDTH, SellFrame.RADIO_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.PINK);

        // Add components to panel. Add margins and stuffs.
        for (JRadioButton button: radioButtons) {
            button.addActionListener(bc);
            button.setMargin(new Insets(0, JBUTTON_LEFT_INSET,0,0));
            button.setOpaque(false);
            button.setFocusable(false);
            buttonGroup.add(button);
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
