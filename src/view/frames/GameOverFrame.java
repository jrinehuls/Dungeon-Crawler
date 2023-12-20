package view.frames;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class GameOverFrame extends JFrame {

    // TODO: Make panel and add panel to this. This is just a place holder for now.
    public GameOverFrame() {
        super("GET REKT!!");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            String iconName = "/icons/Icon.png";
            InputStream is = Objects.requireNonNull(getClass().getResourceAsStream(iconName));
            this.setIconImage(ImageIO.read(is));
        } catch (IOException e) {
            this.setIconImage(null);
        }
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
