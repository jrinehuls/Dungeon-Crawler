package view.panels;

import model.monster.Karen;
import model.monster.Monster;
import background.BackGroundImageManager;

import java.awt.*;

import javax.swing.*;


public class GamePanel extends JPanel{
	//Height and width of the main panel
	public final int SCREEN_WIDTH = 600;
	public final int SCREEN_HEIGHT = 600;

	private static BackGroundImageManager backGroundImageManager = new BackGroundImageManager();
	// Position Label
	private static JLabel positionLabel = new JLabel();
	// Monster Image Label
	private static JLabel monsterLabel = new JLabel();
	// Background Image
	private static JLabel backgroundLabel = new JLabel();
	private static ImageIcon backgroundImage;

	static String lastPosition, currentPosition;
	static double randomNumber = 1.0;

	private static Monster monster;

	public GamePanel(){

		// Game Panel
		this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(null);
		// Position Label
		positionLabel.setBounds(50, 50, 40, 20);
		this.add(positionLabel);

		// Monster Image Label
		monsterLabel.setBounds(SCREEN_WIDTH/4 + 50, 50, 200, 200);
		this.add(monsterLabel);
		// Background Image
		backgroundLabel.setBounds(SCREEN_WIDTH/4, 0, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
		this.add(backgroundLabel);

		lastPosition = MapPanel.getPosition();

	}

	public static void update() {
		currentPosition = MapPanel.getPosition();
		positionLabel.setText(currentPosition);
		if (!lastPosition.equals(currentPosition)) {
			randomNumber = Math.random();
			lastPosition = currentPosition;
		}
		System.out.println(randomNumber);

		monster = getMonster();

		try {
			monsterLabel.setIcon(monster.getIcon());
		} catch (NullPointerException e) {
			monsterLabel.setIcon(null);
		}

		backgroundImage = backGroundImageManager.getBackgroundImage(MapPanel.tileType, MapPanel.facing);
		backgroundLabel.setIcon(backgroundImage);
	}

	static Monster getMonster() {
		if (randomNumber >= 0.0 && randomNumber < 0.5) {
			return new Karen();
		}
		else return null;
	}

}