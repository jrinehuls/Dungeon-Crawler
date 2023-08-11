package view.frames;

import view.panels.game.GamePanel;

import javax.swing.*;
import java.awt.*;

public class GameOverFrame extends JFrame {

    public GameOverFrame() {
        super("GET REKT");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(400, 300));
        this.setVisible(true);
        JLabel label = new JLabel("GET REKT!!");
        label.setForeground(Color.BLACK);
        label.setFont(new Font(null, Font.BOLD, 50));
        label.setBounds(100, 100, 100, 100);
        this.getContentPane().add(label);

    }



}
