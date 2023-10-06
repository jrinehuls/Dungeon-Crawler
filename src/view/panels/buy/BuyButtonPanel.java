package view.panels.buy;

import view.frames.BuyFrame;
import view.frames.SpellFrame;

import javax.swing.*;
import java.awt.*;

public class BuyButtonPanel extends JPanel {

    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 50;

    private final JButton buyButton = new JButton("Buy");
    private final JButton exitButton = new JButton("Exit");

    JButton[] buttons = {buyButton, exitButton};

    public BuyButtonPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 25, 15));

        for (JButton button: buttons) {
            button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
            button.setFocusable(false);
            this.add(button);
        }

        this.setPreferredSize(new Dimension(BuyFrame.RIGHT_PANEL_WIDTH, BuyFrame.BUTTON_PANEL_HEIGHT));
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
