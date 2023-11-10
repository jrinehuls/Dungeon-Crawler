package view.panels.inn;

import controller.InnController;
import view.frames.InnFrame;

import javax.swing.*;
import java.awt.*;

public class InnButtonPanel extends JPanel {

    public InnButtonPanel(InnController ic) {

        this.setPreferredSize(new Dimension(InnFrame.PANEL_WIDTH, InnFrame.PANEL_HEIGHT / 2));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.CYAN);

    }

}
