package view.panels.equipment;

import controller.ActionButtonController;
import controller.EquipmentController;
import view.frames.EquipmentFrame;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 50;

    JButton submitButton = new JButton("Completed");

    EquipmentController ec;

    public ButtonPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 100, 15));

        ec = new EquipmentController();

        this.setPreferredSize(new Dimension(EquipmentFrame.SCREEN_WIDTH, EquipmentFrame.BUTTON_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.CYAN);

        submitButton.addActionListener(ec);
        submitButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        submitButton.setFocusable(false);
        this.add(submitButton);

    }

    public JButton getSubmitButton() {
        return submitButton;
    }
}
