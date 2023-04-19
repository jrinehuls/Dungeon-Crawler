package panels;

import model.monster.Karen;
import tiles.BackGroundImageManager;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;


public class GamePanel extends JPanel{
	//Height and width of the main panel
	public final int SCREEN_WIDTH = 600;
	public final int SCREEN_HEIGHT = 600;

	private static JLabel backgroundLabel = new JLabel();
	private JLabel monsterLabel = new JLabel();
	private static JLabel positionLabel = new JLabel();

	private ImageIcon monsterImage = new Karen().getIcon();
	private static ImageIcon backgroundImage;

	private static BackGroundImageManager bgim = new BackGroundImageManager();

	public GamePanel(){

		monsterLabel.setBounds(SCREEN_WIDTH/4 + 50, 50, 200, 200);
		monsterLabel.setIcon(monsterImage);
		this.add(monsterLabel);

		backgroundLabel.setBounds(SCREEN_WIDTH/4, 0, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
		this.add(backgroundLabel);

		positionLabel.setBounds(50, 50, 40, 20);
		this.add(positionLabel);
		this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(null);

	}

	public static void update() {
		positionLabel.setText(MapPanel.getPosition());
		backgroundImage = bgim.getBackgroundImage(MapPanel.tileType, MapPanel.facing);
		backgroundLabel.setIcon(backgroundImage);
	}

}