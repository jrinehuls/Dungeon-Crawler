package view.panels.inn;

import view.frames.InnFrame;

import javax.swing.*;
import java.awt.*;

public class InnCurrentStatsPanel extends JPanel {

    public InnCurrentStatsPanel() {

        this.setPreferredSize(new Dimension(InnFrame.PANEL_WIDTH, InnFrame.PANEL_HEIGHT / 2));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.MAGENTA);

    }

}
