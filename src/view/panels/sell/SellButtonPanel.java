package view.panels.sell;

import controller.SellController;
import view.frames.SellFrame;

import javax.swing.*;
import java.awt.*;

public class SellButtonPanel extends JPanel {
    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 50;

    private final JButton buyButton = new JButton("Buy");
    private final JButton exitButton = new JButton("Exit");

    JButton[] buttons = {buyButton, exitButton};

    private final int PANEL_WIDTH = SellFrame.RIGHT_PANEL_WIDTH;
    private final int PANEL_HEIGHT = SellFrame.BUTTON_PANEL_HEIGHT;

    public SellButtonPanel(SellController sc) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER,
                (PANEL_WIDTH - buttons.length * BUTTON_WIDTH) / (buttons.length + 1),
                (PANEL_HEIGHT - BUTTON_HEIGHT) / 2));

        for (JButton button: buttons) {
            button.addActionListener(sc);
            button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
            button.setFocusable(false);
            this.add(button);
        }

        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.CYAN);
    }

    public JButton getBuyButton() {
        return buyButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
