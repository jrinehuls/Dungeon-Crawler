package view.panels.inn;

import controller.InnController;
import view.frames.InnFrame;

import javax.swing.*;
import java.awt.*;

public class InnRadioButtonPanel extends JPanel {

    private final int PANEL_WIDTH = InnFrame.PANEL_WIDTH;
    private final int PANEL_HEIGHT = InnFrame.PANEL_HEIGHT / 2;

    public static final int CRAPPY_COST = 40;
    public static final int GOOD_COST = 100;

    private ButtonGroup buttonGroup = new ButtonGroup();

    private final JRadioButton crappyButton = new JRadioButton();
    private final JRadioButton goodButton = new JRadioButton();

    private static final int JBUTTON_LEFT_INSET = 20;

    JRadioButton[] radioButtons = {crappyButton, goodButton};

    public InnRadioButtonPanel(InnController ic) {
        super(new GridLayout(2, 1, 0, 0));

        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.PINK);

        crappyButton.setText("Crappy Room: " + CRAPPY_COST + " Gold");
        goodButton.setText("Good Room: " + GOOD_COST + " Gold");

        // Add components to panel. Add margins and stuffs.
        for (JRadioButton button: radioButtons) {
            button.addActionListener(ic);
            button.setMargin(new Insets(0, JBUTTON_LEFT_INSET,0,0));
            button.setOpaque(false);
            button.setFocusable(false);
            buttonGroup.add(button);
            this.add(button);
        }

        // Default to weapon radio button being selected
        crappyButton.setSelected(true);
    }

    public JRadioButton getCrappyButton() {
        return crappyButton;
    }

    public JRadioButton getGoodButton() {
        return goodButton;
    }

}
