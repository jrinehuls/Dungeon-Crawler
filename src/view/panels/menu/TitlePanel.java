package view.panels.menu;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {

    public static final int PANEL_WIDTH = 600;
    public static final int PANEL_HEIGHT = 150;
    private static final int LABEL_WIDTH = PANEL_WIDTH;
    private static final int LABEL_HEIGHT = PANEL_HEIGHT;

    private JLabel titleLabel;

    public TitlePanel (String labelText) {
        super(new FlowLayout(FlowLayout.CENTER, 0, 0));

        titleLabel = new JLabel(labelText, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Algerian", Font.BOLD, 36));
        this.add(titleLabel);

    }
}
