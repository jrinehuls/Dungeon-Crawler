package view.panels;

import collections.MonsterCollection;
import model.monster.Monster;
import background.BackGroundImageManager;

import java.awt.*;

import javax.swing.*;


public class GamePanel extends JPanel {
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

	static String lastPosition;
	static String currentPosition;

	// set by Monster Collection get monster
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
		// The position on the map before moving
		lastPosition = MapPanel.getPosition();


	}

	// Invoked by MonsterPanel and ActionButtonController
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

	public static void handleMonster() {
		monsterLabel.setIcon(monster.getIcon());
		if (monster.getHP() <= 0) {
			monster.dropGold();
			monster = null;
		}
		monster.takeAction();
	}

	public static void update() {
		currentPosition = MapPanel.getPosition();
		positionLabel.setText(currentPosition);
		backgroundImage = backGroundImageManager.getBackgroundImage(MapPanel.tileType, MapPanel.facing);
		backgroundLabel.setIcon(backgroundImage);
		if (!lastPosition.equals(currentPosition)) {
			monster = new MonsterCollection().getMonster();
			lastPosition = currentPosition;
		}
		// Handle monster related attributes and activities
		try {
			handleMonster();
		} catch (NullPointerException e) {
			monsterLabel.setIcon(null);
		}

	}


}