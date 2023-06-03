package view.frames;

import view.panels.item.ButtonPanel;
import view.panels.item.ItemListPanel;
import view.panels.item.ItemRadioButtonPanel;

import javax.swing.*;
import java.awt.*;

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
    public ButtonPanel buttonPanel;


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
        buttonPanel = new ButtonPanel();
        itemPanel.add(buttonPanel);

        //------------------------Frame stuff---------------------------------------------
        this.add(itemPanel);
        // TODO: Clear list selection
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setIconImage(new ImageIcon("res/icons/Icon.png").getImage());
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        // this.setLocationRelativeTo(MainGameFrame.getFrames()[0]);
        // this.setVisible(false);
        this.setVisible(false);
    }
}
