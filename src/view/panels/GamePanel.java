package view.panels;

import collections.MonsterCollection;
import model.monster.Karen;
import model.monster.Monster;
import background.BackGroundImageManager;

import java.awt.*;

import javax.swing.*;


public class GamePanel extends JPanel implements Runnable {
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

	MonsterCollection monsterCollection = new MonsterCollection();

	// set by Monster Collection get monster
	private static Monster monster;

	Thread gameThread;

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

		gameThread = new Thread(this);
		gameThread.start();

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

	public void update() {
		currentPosition = MapPanel.getPosition();
		positionLabel.setText(currentPosition);
		backgroundImage = backGroundImageManager.getBackgroundImage(MapPanel.tileType, MapPanel.facing);
		backgroundLabel.setIcon(backgroundImage);
		if (!lastPosition.equals(currentPosition)) {
			monster = monsterCollection.getMonster();
			lastPosition = currentPosition;
		}
		// Set the icon for the monster that shows up
		try {
			monsterLabel.setIcon(monster.getIcon());
		} catch (NullPointerException e) {
			monsterLabel.setIcon(null);
		}

	}

	@Override
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		long currentTime;
		final double FPS = 30.0;
		final double drawInterval = 1_000_000_000 / FPS;
		double delta = 0;
		while (gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			if (delta >= 1) {
				update();
				delta = 0.0;
			}
			lastTime = currentTime;
		}
	}
}