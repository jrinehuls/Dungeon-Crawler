package view.panels.item;

import controller.ItemController;
import view.frames.ItemFrame;
import view.panels.game.MonsterPanel;

import javax.swing.*;
import java.awt.*;

public class ItemRadioButtonPanel extends JPanel {

    public ButtonGroup consumableButtonGroup = new ButtonGroup();

    public final JRadioButton healingItemsButton = new JRadioButton("Healing Items");
    public final JRadioButton attackItemsButton = new JRadioButton("Attack Items");

    private static final int JBUTTON_LEFT_INSET = 50;

    JRadioButton[] consumableButtons = {healingItemsButton, attackItemsButton};

    ItemController ic = new ItemController();

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
            button.addActionListener(ic);
            this.add(button);
        }

        if (MonsterPanel.isMonster()) {
            attackItemsButton.setEnabled(true);
        } else {
            attackItemsButton.setEnabled(false);
        }

        // Default to healing radio button being selected
        healingItemsButton.setSelected(true);


    }


}
