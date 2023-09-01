package view.frames;


import javax.swing.*;
import java.awt.*;

public class GameOverFrame extends JFrame {

    public GameOverFrame() {
        super("GET REKT!!");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(400, 300));
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        JLabel label = new JLabel("GET REKT!!");
        label.setForeground(Color.RED);
        label.setFont(new Font(null, Font.BOLD, 50));
        label.setBounds(50, 100, 300, 50);
        this.getContentPane().add(label);
        this.setResizable(false);
        this.setVisible(true);
    }



}
