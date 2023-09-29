package view.frames;

import view.panels.menu.OptionPanel;
import view.panels.menu.TitlePanel;

import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {

    private JPanel menuPanel;

    private JPanel topPanel;
    private TitlePanel titlePanel;

    private JPanel bottomPanel;
    private OptionPanel innPanel;
    private OptionPanel shopPanel;
    private OptionPanel dungeonPanel;

    public MenuFrame() {

        //this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        // ------------------------------------- Top Panel Stuff ----------------------------------------
        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        topPanel.setPreferredSize(new Dimension(TitlePanel.PANEL_WIDTH, TitlePanel.PANEL_HEIGHT));
        this.titlePanel = new TitlePanel("TITLE");
        topPanel.add(titlePanel);

        // ------------------------------------ Bottom Panel Stuff --------------------------------------
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        bottomPanel.setPreferredSize(new Dimension(TitlePanel.PANEL_WIDTH, OptionPanel.PANEL_HEIGHT));
        this.innPanel = new OptionPanel("INN","/button-images/Dungeon.png");
        bottomPanel.add(innPanel);
        this.shopPanel = new OptionPanel("SHOP","/button-images/Dungeon.png");
        bottomPanel.add(shopPanel);
        this.dungeonPanel = new OptionPanel("DUNGEON","/button-images/Dungeon.png");
        bottomPanel.add(dungeonPanel);

        // ------------------------------------ Set Frame Up --------------------------------------
        menuPanel.add(topPanel);
        menuPanel.add(bottomPanel);
        this.add(menuPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }


}
