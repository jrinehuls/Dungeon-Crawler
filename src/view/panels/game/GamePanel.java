package view.panels.game;

import background.BackGroundImageManager;

import java.awt.*;

import javax.swing.*;


public class GamePanel extends JPanel {
	//Height and width of the panel
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = MonsterPanel.SCREEN_HEIGHT;

	private static BackGroundImageManager backGroundImageManager = new BackGroundImageManager();
	// Position Label
	private static JLabel positionLabel = new JLabel();
	// Label to hold monster image
	private static JLabel monsterLabel = new JLabel();
	// Background Image for dungeon walls
	private static JLabel backgroundLabel = new JLabel();
	private static ImageIcon backgroundImage;

	// This class should only update to show bg, monster image, and location.
	public GamePanel(){

		// Game Panel
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(null);
		// Position Label
		positionLabel.setBounds(50, 50, 40, 20);
		this.add(positionLabel);
		// Monster Image Label
		monsterLabel.setBounds((SCREEN_WIDTH - 200)/2, 50, 200, 200);
		this.add(monsterLabel);
		// Background Image
		backgroundLabel.setBounds((SCREEN_WIDTH - 300)/2, 0, 300, 300);
		this.add(backgroundLabel);

	}



	public static void update() {
		positionLabel.setText(MapPanel.getPosition());
		backgroundImage = backGroundImageManager.getBackgroundImage(MapPanel.tileType, MapPanel.facing);
		backgroundLabel.setIcon(backgroundImage);
		try {
			monsterLabel.setIcon(MonsterPanel.getMonster().getIcon());
		} catch (NullPointerException e) {
			monsterLabel.setIcon(null);
		}

	}


}