package view.panels.buy;

import view.frames.BuyFrame;

import javax.swing.*;
import java.awt.*;

public class BuyRadioButtonPanel extends JPanel {

    public ButtonGroup equipButtons = new ButtonGroup();

    public final JRadioButton weaponButton = new JRadioButton("Weapons"); // If weaponButton.isSelected()
    public final JRadioButton headButton = new JRadioButton("Headgear");
    public final JRadioButton bodyButton = new JRadioButton("Armor");
    public final JRadioButton armButton = new JRadioButton("Arm Guards");
    public final JRadioButton feetButton = new JRadioButton("Feet Guards");
    public final JRadioButton accessoryButton = new JRadioButton("Accessories");
    public final JRadioButton attackButton = new JRadioButton("Attack Items");
    public final JRadioButton healingButton = new JRadioButton("Healing Items");

    private static final int JBUTTON_LEFT_INSET = 20;

    JRadioButton[] equipButtonComponents = {weaponButton, headButton, bodyButton, armButton, feetButton,
            accessoryButton, attackButton, healingButton};

    public BuyRadioButtonPanel() {
        super(new GridLayout(4, 2, 0, 0));

        this.setPreferredSize(new Dimension(BuyFrame.LEFT_PANEL_WIDTH, BuyFrame.RADIO_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.PINK);

        // Add components to panel. If component is a radio, add margins and stuffs.
        for (JRadioButton button: equipButtonComponents) {
            button.setMargin(new Insets(0, JBUTTON_LEFT_INSET,0,0));
            button.setOpaque(false);
            button.setFocusable(false);
            equipButtons.add(button);
            this.add(button);
        }

        // Default to weapon radio button being selected
        weaponButton.setSelected(true);
    }
}
