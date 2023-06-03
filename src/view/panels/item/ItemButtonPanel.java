package view.panels.item;

import view.frames.ItemFrame;

import javax.swing.*;
import java.awt.*;

public class ItemButtonPanel extends JPanel {

    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 50;

    JButton useButton = new JButton("Use Item");

    public ItemButtonPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 100, 15));

        this.setPreferredSize(new Dimension(ItemFrame.SCREEN_WIDTH, ItemFrame.BUTTON_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.CYAN);

        // useButton.addActionListener(action listener);
        useButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        useButton.setFocusable(false);
        this.add(useButton);

    }

    public JButton getUseButton() {
        return useButton;
    }
}
