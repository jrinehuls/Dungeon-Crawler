package view.panels;

import collections.MonsterCollection;
import model.entity.monster.Monster;
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

	static String lastPosition = MapPanel.getPosition();
	static String currentPosition;

	// Initially null, but set by Monster Collection get monster in update method
	private static Monster monster;

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

	// Invoked by MonsterPanel and ActionButtonController
	public static Monster getMonster() {
		return monster;
	}

	// Invoked by MapPanel to only allow movement if null monster
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
			monster.giveExp();
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