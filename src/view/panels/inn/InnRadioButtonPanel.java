package view.panels.inn;

import controller.InnController;
import model.inn.CrappyRoom;
import model.inn.GoodRoom;
import model.inn.MediocreRoom;
import view.frames.InnFrame;

import javax.swing.*;
import java.awt.*;

public class InnRadioButtonPanel extends JPanel {

    private final int PANEL_WIDTH = InnFrame.PANEL_WIDTH;
    private final int PANEL_HEIGHT = InnFrame.PANEL_HEIGHT / 2;

    private ButtonGroup buttonGroup = new ButtonGroup();

    private final JRadioButton crappyButton = new JRadioButton();
    private final JRadioButton mediocreButton = new JRadioButton();
    private final JRadioButton goodButton = new JRadioButton();

    private static final int JBUTTON_LEFT_INSET = 20;

    JRadioButton[] radioButtons = {crappyButton, mediocreButton, goodButton};

    public InnRadioButtonPanel(InnController ic) {
        super(new GridLayout(3, 1, 0, 0));

        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.PINK);

        crappyButton.setText("Crappy Room:   " + new CrappyRoom().getCost() + " Gold");
        mediocreButton.setText("Mediocre Room:   " + new MediocreRoom().getCost() + " Gold");
        goodButton.setText("Good Room:   " + new GoodRoom().getCost() + " Gold");

        // Add components to panel. Add margins and stuffs.
        for (JRadioButton button: radioButtons) {
            button.addActionListener(ic);
            button.setMargin(new Insets(0, JBUTTON_LEFT_INSET,0,0));
            button.setOpaque(false);
            button.setFocusable(false);
            buttonGroup.add(button);
            this.add(button);
        }

    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public JRadioButton getCrappyButton() {
        return crappyButton;
    }

    public JRadioButton getMediocreButton() {
        return mediocreButton;
    }

    public JRadioButton getGoodButton() {
        return goodButton;
    }

}
