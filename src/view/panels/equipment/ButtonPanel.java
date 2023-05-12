package view.panels.equipment;

import view.frames.EquipmentFrame;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private static final int BUTTON_WIDTH = 100;
    private static final int BUTTON_HEIGHT = 50;

    JButton submitButton = new JButton("Submit");
    JButton cancelButton = new JButton("Cancel");

    JButton[] buttons = {submitButton, cancelButton};

    public ButtonPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 100, 15));

        this.setPreferredSize(new Dimension(EquipmentFrame.SCREEN_WIDTH, EquipmentFrame.BUTTON_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.CYAN);

        for (JButton button: buttons) {
            button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
            this.add(button);
        }

    }
}
