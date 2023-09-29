package view.panels.menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class OptionPanel extends JPanel {

    public static final int PANEL_WIDTH = 200;
    public static final int PANEL_HEIGHT = 250;
    private static final int BUTTON_WIDTH = PANEL_WIDTH;
    private static final int BUTTON_HEIGHT = 200;
    private static final int LABEL_WIDTH = PANEL_WIDTH;
    private static final int LABEL_HEIGHT = PANEL_HEIGHT - BUTTON_HEIGHT;

    private Icon icon;

    private JButton button;
    private JLabel label;

    public OptionPanel(String labelText, String iconFileName) {

        super(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        label = new JLabel(labelText, SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
        label.setFont(new Font("Algerian", Font.BOLD, 36));
        this.add(label);

        icon = this.setIcon(iconFileName);
        button = new JButton(icon);
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.addActionListener(null);
        button.setFocusable(false);
        this.add(button);

    }

    private Icon setIcon(String filename) {
        try {
            return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(filename))));
        } catch (IOException | NullPointerException e) {
            System.out.println(this.getClass().getSimpleName() + " " + e.getMessage());
            return null;
        }
    }





}
