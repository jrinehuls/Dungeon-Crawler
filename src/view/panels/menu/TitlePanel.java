package view.panels.menu;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TitlePanel extends JPanel {

    public static final int PANEL_WIDTH = OptionPanel.PANEL_WIDTH * 3;
    public static final int PANEL_HEIGHT = 150;
    private static final int LABEL_WIDTH = PANEL_WIDTH;
    private static final int LABEL_HEIGHT = PANEL_HEIGHT;

    private JLabel titleLabel;

    public TitlePanel (String labelText) {
        super(new FlowLayout(FlowLayout.CENTER, 0, 0));

        titleLabel = new JLabel(labelText, SwingConstants.CENTER);
        titleLabel.setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
        titleLabel.setFont(new Font("Algerian", Font.BOLD, 36));
        titleLabel.setForeground(new Color(50,85,50));
        this.add(titleLabel);

    }
}
