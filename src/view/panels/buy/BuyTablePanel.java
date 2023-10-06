package view.panels.buy;

import view.frames.BuyFrame;

import javax.swing.*;
import java.awt.*;

public class BuyTablePanel extends JPanel {

    public BuyTablePanel() {
        super(new FlowLayout(FlowLayout.CENTER, 0, 0));

        this.setPreferredSize(new Dimension(BuyFrame.RIGHT_PANEL_WIDTH, BuyFrame.TABLE_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.ORANGE);

    }

}
