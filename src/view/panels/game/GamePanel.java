package view.panels.game;

import background.BackGroundImageManager;
import collections.floor.FloorCollection;
import model.tileobject.InteractableTileObject;
import model.tileobject.Treasure;
import tiles.Tile;
import tiles.TileManager;

import java.awt.*;
import java.util.Arrays;

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
	// Background Image for treasure chest and stairs
	private static JLabel objectLabel = new JLabel();
	// Background Image for dungeon walls
	private static JLabel backgroundLabel = new JLabel();
	private static ImageIcon backgroundImage;

	public static JButton treasureButton = new JButton("Treasure");

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
		// Object Image
		objectLabel.setBounds((SCREEN_WIDTH - 150)/2, 175, 150, 100);
		this.add(objectLabel);
		// Background Image
		backgroundLabel.setBounds((SCREEN_WIDTH - 300)/2, 0, 300, 300);
		this.add(backgroundLabel);

		treasureButton.setBounds(615, 20, 120, 30);
		treasureButton.addActionListener((e) -> {
			Tile tile = TileManager.getFloorPlan()[MapPanel.yCord][MapPanel.xCord];
			Treasure treasure = (Treasure) tile.getTileObject();
			treasure.awardItem();
			tile.removeTileObject();
		});
		treasureButton.setEnabled(false);
		treasureButton.setFocusable(false);
		this.add(treasureButton);

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
			if (tileObject instanceof Treasure && !MonsterPanel.isMonster()) {
				treasureButton.setEnabled(true);
			} else {
				treasureButton.setEnabled(false);
			}
			objectLabel.setIcon(tileObject.getBackgroundImage());
		} catch (NullPointerException e){
			objectLabel.setIcon(null);
		}
	}

}