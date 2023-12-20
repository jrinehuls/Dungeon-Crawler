package view.frames;

import controller.MenuController;
import view.panels.menu.OptionPanel;
import view.panels.menu.TitlePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

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

    private MenuController controller;

    public MenuFrame() {

        controller = new MenuController(this);

        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        // ------------------------------------- Top Panel Stuff ----------------------------------------
        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        topPanel.setPreferredSize(new Dimension(TitlePanel.PANEL_WIDTH + 2 * BORDER_THICKNESS, TitlePanel.PANEL_HEIGHT + 2 * BORDER_THICKNESS));
        topPanel.setBorder(new LineBorder(Color.BLACK, BORDER_THICKNESS));

        this.titlePanel = new TitlePanel(MENU_TITLE);
        topPanel.add(titlePanel);

        menuPanel.add(topPanel);

        // ------------------------------------ Bottom Panel Stuff --------------------------------------
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        bottomPanel.setPreferredSize(new Dimension(TitlePanel.PANEL_WIDTH + 2 * BORDER_THICKNESS, OptionPanel.PANEL_HEIGHT + 2 * BORDER_THICKNESS));
        bottomPanel.setBorder(new LineBorder(Color.BLACK, BORDER_THICKNESS));

        this.innPanel = new OptionPanel("INN", INN_ICON_FILE_NAME);
        this.innPanel.getButton().addActionListener(controller);
        bottomPanel.add(innPanel);

        this.shopPanel = new OptionPanel("SHOP",SHOP_ICON_FILE_NAME);
        this.shopPanel.getButton().addActionListener(controller);
        bottomPanel.add(shopPanel);

        this.dungeonPanel = new OptionPanel("DUNGEON",DUNGEON_ICON_FILE_NAME);
        this.dungeonPanel.getButton().addActionListener(controller);
        bottomPanel.add(dungeonPanel);

        menuPanel.add(bottomPanel);

        // ------------------------------------ Set Frame Up --------------------------------------
        this.add(menuPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        this.setVisible(true);

    }

    public OptionPanel getInnPanel() {
        return this.innPanel;
    }

    public OptionPanel getShopPanel() {
        return this.shopPanel;
    }

    public OptionPanel getDungeonPanel() {
        return this.dungeonPanel;
    }

}
