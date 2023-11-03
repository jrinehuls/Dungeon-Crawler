package view.panels.game;

import background.BackGroundImageManager;
import collections.floor.FloorCollection;
import controller.game.GamePanelController;
import model.tileobject.*;
import tiles.Tile;
import tiles.TileManager;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;


public class GamePanel extends JPanel {
	// Height and width of the panel
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = MonsterPanel.SCREEN_HEIGHT;

	private static BackGroundImageManager backGroundImageManager = new BackGroundImageManager();
	// Position Label
	private static JLabel positionLabel = new JLabel();
	// Label to hold monster image
	private static JLabel monsterLabel = new JLabel();
	// Background Image for treasure chest and stairs
	private static JLabel objectLabel = new JLabel();
	// Background Image for dungeon walls
	private static JLabel backgroundLabel = new JLabel();
	private static ImageIcon backgroundImage;

	public static JButton treasureButton = new JButton("Open Treasure");
	public static JButton ascendButton = new JButton("Go Up Stairs");
	public static JButton descendButton = new JButton("Go Down Stairs");
	public static JButton exitButton = new JButton("Exit Dungeon");

	private static JButton[] buttons = {treasureButton, ascendButton, descendButton, exitButton};

	GamePanelController gpc = new GamePanelController();


	public GamePanel(){

		// Game Panel
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(null);

		// ----------------------------------- Left Side ----------------------------------
		positionLabel.setBounds(50, 50, 40, 20);
		this.add(positionLabel);

		// ----------------------------------- Middle ----------------------------------

		// Monster Image Label
		monsterLabel.setBounds((SCREEN_WIDTH - 200)/2, 50, 200, 200);
		this.add(monsterLabel);
		// Object Image
		// objectLabel.setBounds((SCREEN_WIDTH - 150)/2, 175, 150, 100);
		objectLabel.setBounds((SCREEN_WIDTH - 300)/2, 0, 300, 300);
		this.add(objectLabel);
		// Background Image
		backgroundLabel.setBounds((SCREEN_WIDTH - 300)/2, 0, 300, 300);
		this.add(backgroundLabel);

		// ----------------------------------- Right Side ----------------------------------

		int buttonY = 20;
		for (JButton button : buttons) {
			button.setBounds(600, buttonY, 150, 30);
			button.addActionListener(gpc);
			button.setEnabled(false);
			button.setFocusable(false);
			this.add(button);
			buttonY += 40;
		}

	}


	public static void update() {
		positionLabel.setText(MapPanel.getPosition());
		backgroundImage = backGroundImageManager.getBackgroundImage(Arrays.asList(FloorCollection.tileWalls).indexOf(MapPanel.tile.getTileWalls()), MapPanel.facing);
		backgroundLabel.setIcon(backgroundImage);
		setObjectIcon();
		setMonsterIcon();
	}

	private static void setMonsterIcon() {
		try {
			monsterLabel.setIcon(MonsterPanel.getMonster().getIcon());
		} catch (NullPointerException e) {
			monsterLabel.setIcon(null);
		}
	}

	private static void setObjectIcon() {
		try  {
			InteractableTileObject tileObject = TileManager.getFloorPlan()[MapPanel.yCord][MapPanel.xCord].getTileObject();
			objectLabel.setIcon(tileObject.getBackgroundImage()); // Null if no tile object
			treasureButton.setEnabled(tileObject instanceof Treasure && !MonsterPanel.isMonster());
			ascendButton.setEnabled(tileObject instanceof AscendingStaircase && !MonsterPanel.isMonster());
			descendButton.setEnabled(tileObject instanceof DescendingStaircase && !MonsterPanel.isMonster());
			exitButton.setEnabled(tileObject instanceof Exit && !MonsterPanel.isMonster());
		} catch (NullPointerException e){
			objectLabel.setIcon(null);
			for (JButton button : buttons) {
				button.setEnabled(false);
			}
		}
	}

}