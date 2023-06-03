package controller;

import model.entity.player.Player;
import view.frames.ItemFrame;
import view.panels.item.ItemButtonPanel;
import view.panels.item.ItemListPanel;
import view.panels.item.ItemRadioButtonPanel;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemController implements ActionListener, ListSelectionListener {

    Player player;
    ItemFrame itemFrame;
    ItemButtonPanel itemButtonPanel;
    ItemListPanel itemListPanel;
    ItemRadioButtonPanel itemRadioButtonPanel;

    public ItemController() {

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
