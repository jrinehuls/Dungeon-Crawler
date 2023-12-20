package view.frames;

import view.panels.item.ItemButtonPanel;
import view.panels.item.ItemListPanel;
import view.panels.item.ItemRadioButtonPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class ItemFrame extends JFrame {

    public static final int SCREEN_WIDTH = 500;
    JPanel itemPanel;

    //------------- TOP ------------------------------------------
    JPanel selectionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    public static final int SELECTION_PANEL_HEIGHT = 200;
    public ItemRadioButtonPanel itemRadioButtonPanel;
    public ItemListPanel itemListPanel;

    //------------- BOTTOM ---------------------------------------
    public static final int BUTTON_PANEL_HEIGHT = 80;
    public ItemButtonPanel itemButtonPanel;


    public ItemFrame() {

        // --------------------Stuff for main panel---------------------------------------
        itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));

        // --------------------Stuff for selection panel (TOP)---------------------------------------
        selectionPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, SELECTION_PANEL_HEIGHT));

        itemRadioButtonPanel = new ItemRadioButtonPanel();
        itemListPanel = new ItemListPanel();

        selectionPanel.add(itemRadioButtonPanel);
        selectionPanel.add(itemListPanel);
        itemPanel.add(selectionPanel);

        //--------------------Stuff for button panel (BOTTOM)---------------------------------------
        itemButtonPanel = new ItemButtonPanel();
        itemPanel.add(itemButtonPanel);

        //------------------------Frame stuff---------------------------------------------
        this.add(itemPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            String iconName = "/icons/Icon.png";
            InputStream is = Objects.requireNonNull(getClass().getResourceAsStream(iconName));
            this.setIconImage(ImageIO.read(is));
        } catch (IOException e) {
            this.setIconImage(null);
        }
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        // this.setLocationRelativeTo(MainGameFrame.getFrames()[0]);
        // this.setVisible(false);
        this.setVisible(false);
    }
}
