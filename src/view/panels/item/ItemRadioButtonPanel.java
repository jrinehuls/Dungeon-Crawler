package view.panels.item;

import view.frames.ItemFrame;

import javax.swing.*;
import java.awt.*;

public class ItemRadioButtonPanel extends JPanel {

    public ButtonGroup consumableButtonGroup = new ButtonGroup();

    public final JRadioButton healingItemsButton = new JRadioButton("Healing Items");

    private static final int JBUTTON_LEFT_INSET = 50;

    JRadioButton[] consumableButtons = {healingItemsButton};

    public ItemRadioButtonPanel() {
        super(new GridLayout(6, 1, 0, 0));

        this.setPreferredSize(new Dimension(ItemFrame.SCREEN_WIDTH /2, ItemFrame.SELECTION_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.RED);

        // Add components to panel. Add margins and stuffs.
        for (JRadioButton button: consumableButtons) {
            button.setMargin(new Insets(0, JBUTTON_LEFT_INSET,0,0));
            button.setOpaque(false);
            button.setFocusable(false);
            consumableButtonGroup.add(button);
            // button.addActionListener(action listener);
            this.add(button);
        }

        // Default to weapon radio button being selected
        healingItemsButton.setSelected(true);


    }


}
