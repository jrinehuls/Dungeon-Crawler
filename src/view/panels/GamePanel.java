package view.panels;

import collections.MonsterCollection;
import model.monster.Karen;
import model.monster.Monster;
import background.BackGroundImageManager;

import java.awt.*;

import javax.swing.*;


public class GamePanel extends JPanel{
	//Height and width of the main panel
	public final int SCREEN_WIDTH = 800;
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
		monsterLabel.setBounds((SCREEN_WIDTH - 200)/2, 50, 200, 200);
		this.add(monsterLabel);
		// Background Image
		backgroundLabel.setBounds((SCREEN_WIDTH - 300)/2, 0, 300, 300);
		this.add(backgroundLabel);

		lastPosition = MapPanel.getPosition();

	}

	public static void update() {
		currentPosition = MapPanel.getPosition();
		positionLabel.setText(currentPosition);
		backgroundImage = backGroundImageManager.getBackgroundImage(MapPanel.tileType, MapPanel.facing);
		backgroundLabel.setIcon(backgroundImage);
		if (!lastPosition.equals(currentPosition)) {
			monster = MonsterCollection.getMonster();
			lastPosition = currentPosition;
		}
		// Set the icon for the monster that shows up
		try {
			monsterLabel.setIcon(monster.getIcon());
		} catch (NullPointerException e) {
			monsterLabel.setIcon(null);
		}

	}

	// Invoked bo MonsterPanel
	public static Monster getMonster() {
		return monster;
	}

	// Invoked by MapPanel
	public static boolean isMonster() {
		if (monster != null) {
			return true;
		} else {
			return false;
		}
	}

}