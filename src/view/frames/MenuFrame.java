package view.frames;

import view.panels.menu.OptionPanel;
import view.panels.menu.TitlePanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MenuFrame extends JFrame {

    private JPanel menuPanel;

    private JPanel topPanel;
    private TitlePanel titlePanel;

    private JPanel bottomPanel;
    private OptionPanel innPanel;
    private OptionPanel shopPanel;
    private OptionPanel dungeonPanel;

    private final String INN_ICON_FILE_NAME = "/button-images/Inn.png";
    private final String SHOP_ICON_FILE_NAME = "/button-images/Shop.png";
    private final String DUNGEON_ICON_FILE_NAME = "/button-images/Dungeon.png";

    private final String MENU_TITLE = "Where do you want to go next?";

    private final int BORDER_THICKNESS = 1;

    public MenuFrame() {

        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        // ------------------------------------- Top Panel Stuff ----------------------------------------
        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        topPanel.setPreferredSize(new Dimension(TitlePanel.PANEL_WIDTH + 2 * BORDER_THICKNESS, TitlePanel.PANEL_HEIGHT + 2 * BORDER_THICKNESS));
        this.titlePanel = new TitlePanel(MENU_TITLE);
        topPanel.add(titlePanel);
        topPanel.setBorder(new LineBorder(Color.BLACK, BORDER_THICKNESS));
        menuPanel.add(topPanel);

        // ------------------------------------ Bottom Panel Stuff --------------------------------------
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        bottomPanel.setPreferredSize(new Dimension(TitlePanel.PANEL_WIDTH + 2 * BORDER_THICKNESS, OptionPanel.PANEL_HEIGHT + 2 * BORDER_THICKNESS));
        this.innPanel = new OptionPanel("INN", INN_ICON_FILE_NAME);
        bottomPanel.add(innPanel);
        this.shopPanel = new OptionPanel("SHOP",SHOP_ICON_FILE_NAME);
        bottomPanel.add(shopPanel);
        this.dungeonPanel = new OptionPanel("DUNGEON",DUNGEON_ICON_FILE_NAME);
        bottomPanel.add(dungeonPanel);
        bottomPanel.setBorder(new LineBorder(Color.BLACK, BORDER_THICKNESS));
        menuPanel.add(bottomPanel);

        // ------------------------------------ Set Frame Up --------------------------------------
        this.add(menuPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("res/icons/Icon.png").getImage());
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

}
