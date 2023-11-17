package view.panels.inn;

import controller.InnController;
import view.frames.InnFrame;

import javax.swing.*;
import java.awt.*;

public class InnButtonPanel extends JPanel {

    private final int PANEL_WIDTH = InnFrame.PANEL_WIDTH;
    private final int PANEL_HEIGHT = InnFrame.PANEL_HEIGHT / 2;

    private final int BUTTON_WIDTH = 200;
    private final int BUTTON_HEIGHT = 70;

    private final JButton buyButton = new JButton("Buy");
    private final JButton exitButton = new JButton("Exit");

    JButton[] buttons = {buyButton, exitButton};

    public InnButtonPanel(InnController ic) {

        final int HGAP = (PANEL_WIDTH - BUTTON_WIDTH) / 2;
        final int VGAP = (PANEL_HEIGHT - BUTTON_HEIGHT * buttons.length) / (buttons.length + 1);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, HGAP, VGAP));

        for (JButton button: buttons) {
            button.addActionListener(ic);
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
