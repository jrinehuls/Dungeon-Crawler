package view.panels.equipment;

import view.frames.EquipmentFrame;

import javax.swing.*;
import java.awt.*;

public class EquipListPanel extends JPanel {

    String[] weapons = {"Dagger", "Sword", "Dagger", "Sword", "Dagger", "Sword", "Dagger", "Sword", "Dagger", "Sword", "Dagger", "Sword"};
    JList<String> equipList = new JList<>(weapons);
    JScrollPane jsp = new JScrollPane(equipList);


    public EquipListPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 0, 25));

        this.setPreferredSize(new Dimension(EquipmentFrame.SCREEN_WIDTH/2, EquipmentFrame.SELECTION_PANEL_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.YELLOW);

        equipList.setVisibleRowCount(6);
        equipList.setFixedCellWidth(250);
        equipList.setFixedCellHeight(25);
        this.add(jsp);


    }
}
