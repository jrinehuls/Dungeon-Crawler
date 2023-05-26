package view.panels.equipment;

import controller.ActionButtonController;
import controller.EquipmentController;
import view.frames.EquipmentFrame;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private static final int BUTTON_WIDTH = 100;
    private static final int BUTTON_HEIGHT = 50;

    JButton submitButton = new JButton("Submit");
    JButton cancelButton = new JButton("Cancel"); // Might not need cancel button

    JButton[] buttons = {submitButton, cancelButton};

    EquipmentController ec;

    public ButtonPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 100, 15));

        ec = new EquipmentController();

        this.setPreferredSize(new Dimension(EquipmentFrame.SCREEN_WIDTH, EquipmentFrame.BUTTON_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.CYAN);

        for (JButton button: buttons) {
            button.addActionListener(ec);
            button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
            this.add(button);
        }

    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}
