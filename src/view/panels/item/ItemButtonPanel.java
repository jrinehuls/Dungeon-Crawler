package view.panels.item;

import controller.ItemController;
import view.frames.ItemFrame;

import javax.swing.*;
import java.awt.*;

public class ItemButtonPanel extends JPanel {

    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 50;

    private JButton doneButton = new JButton("Done");
    private JButton useButton = new JButton("Use Item");

    private JButton buttons[] = {doneButton, useButton};

    ItemController ic;

    public ItemButtonPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 50, 15));

        ic = new ItemController();

        this.setPreferredSize(new Dimension(ItemFrame.SCREEN_WIDTH, ItemFrame.BUTTON_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.CYAN);

        for (JButton button: buttons) {
            button.addActionListener(ic);
            button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
            button.setFocusable(false);
            this.add(button);
        }

    }

    public JButton getDoneButton() {
        return doneButton;
    }

    public JButton getUseButton() {
        return useButton;
    }
}
