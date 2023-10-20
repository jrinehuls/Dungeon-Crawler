package view.panels.buy;

import controller.BuyController;
import view.frames.BuyFrame;
import view.frames.SpellFrame;

import javax.swing.*;
import java.awt.*;

public class BuyButtonPanel extends JPanel {

    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 50;

    private final JButton sellButton = new JButton("Sell");
    private final JButton exitButton = new JButton("Exit");

    JButton[] buttons = {sellButton, exitButton};

    private final int PANEL_WIDTH = BuyFrame.RIGHT_PANEL_WIDTH;
    private final int PANEL_HEIGHT = BuyFrame.BUTTON_PANEL_HEIGHT;

    public BuyButtonPanel(BuyController bc) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER,
                (PANEL_WIDTH - buttons.length * BUTTON_WIDTH) / (buttons.length + 1),
                (PANEL_HEIGHT - BUTTON_HEIGHT) / 2));

        for (JButton button: buttons) {
            button.addActionListener(bc);
            button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
            button.setFocusable(false);
            this.add(button);
        }

        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.CYAN);
    }

    public JButton getBuyButton() {
        return sellButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

}
