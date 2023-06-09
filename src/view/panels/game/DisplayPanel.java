package view.panels.game;

import model.item.consumable.Consumable;
import model.item.consumable.HealingItem;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {

    public static int SCREEN_WIDTH = GamePanel.SCREEN_WIDTH;
    public static int SCREEN_HEIGHT = MapPanel.SCREEN_HEIGHT;

    private static DefaultListModel<String> consoleModel = new DefaultListModel<>();
    public static JList<String> consoleJList;
    public static JScrollPane consoleJSP;


    public DisplayPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 0, 3));

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        consoleJList = new JList<>(consoleModel); // itemJList.setModel(); to change DefaultListModel.
        consoleJList.setVisibleRowCount(15);
        consoleJList.setFixedCellWidth(SCREEN_WIDTH - 25);
        // consoleJList.setFixedCellHeight(16);
        consoleJList.setFocusable(false);
        consoleJList.ensureIndexIsVisible(consoleJList.getModel().getSize() - 1);

        consoleJSP = new JScrollPane(consoleJList);
        this.add(consoleJSP);

    }

    public DefaultListModel<String> getConsoleModel() {
        return consoleModel;
    }

    public static void appendConsoleModel(String text) {
        consoleModel.addElement(text);
        int index = consoleModel.getSize() - 1;
        consoleJList.ensureIndexIsVisible(index);

    }

}
