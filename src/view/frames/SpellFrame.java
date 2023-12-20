package view.frames;

import model.entity.player.Player;
import model.spell.AttackSpell;
import model.spell.HealSpell;
import model.spell.Spell;
import model.spell.StealSpell;
import view.panels.game.MonsterPanel;
import view.panels.game.PlayerPanel;
import view.panels.item.ItemButtonPanel;
import view.panels.item.ItemListPanel;
import view.panels.item.ItemRadioButtonPanel;
import view.panels.spell.SpellButtonPanel;
import view.panels.spell.SpellListPanel;
import view.panels.spell.SpellRadioButtonPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

// public class SpellFrame extends JFrame implements ActionListener {
public class SpellFrame extends JFrame {

    public static final int SCREEN_WIDTH = 500;
    JPanel spellPanel;

    //------------- TOP ------------------------------------------
    JPanel selectionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    public static final int SELECTION_PANEL_HEIGHT = 200;
    public SpellRadioButtonPanel spellRadioButtonPanel;
    public SpellListPanel spellListPanel;

    //------------- BOTTOM ---------------------------------------
    public static final int BUTTON_PANEL_HEIGHT = 80;
    public SpellButtonPanel spellButtonPanel;


    public SpellFrame() {

        // --------------------Stuff for main panel---------------------------------------
        spellPanel = new JPanel();
        spellPanel.setLayout(new BoxLayout(spellPanel, BoxLayout.Y_AXIS));

        // --------------------Stuff for selection panel (TOP)---------------------------------------
        selectionPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, SELECTION_PANEL_HEIGHT));

        spellRadioButtonPanel = new SpellRadioButtonPanel();
        spellListPanel = new SpellListPanel();

        selectionPanel.add(spellRadioButtonPanel);
        selectionPanel.add(spellListPanel);
        spellPanel.add(selectionPanel);

        //--------------------Stuff for button panel (BOTTOM)---------------------------------------
        spellButtonPanel = new SpellButtonPanel();
        spellPanel.add(spellButtonPanel);

        //------------------------Frame stuff---------------------------------------------
        this.add(spellPanel);
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
