package panels;

import inputs.KeyController;
import tiles.TileManager;

import java.awt.*;
import javax.swing.*;

public class MapPanel extends JPanel implements Runnable {
	
	public static final int GRID_SIZE = 25;
	public static final int SCREEN_EDGE_LENGTH = GRID_SIZE * 10 + 1;
	//final Dimension SCREEN_SIZE = new Dimension(SCREEN_EDGE_LENGTH, SCREEN_EDGE_LENGTH);
	//Grid location to start at.
	static int xCord = 4;
	static int yCord = 4;
	//Pixel location to start at.
	int xLocation = 1 + xCord * GRID_SIZE;
	int yLocation = 1 + yCord * GRID_SIZE;
	//Initial direction arrow faces.
	public static char facing = 'D';
	//Collision check booleans
	boolean topCollision;
	boolean bottomCollision;
	boolean leftCollision;
	boolean rightCollision;

	KeyController keyC = new KeyController();
	Thread gameThread;
	
	private static final String[][] MAP_GRID = {{"A1","A2","A3","A4","A5","A6","A7","A8","A9","A10"},
								  {"B1","B2","B3","B4","B5","B6","B7","B8","B9","B10"},
								  {"C1","C2","C3","C4","C5","C6","C7","C8","C9","C10"},
								  {"D1","D2","D3","D4","D5","D6","D7","D8","D9","D10"},
						   		  {"E1","E2","E3","E4","E5","E6","E7","E8","E9","E10"},
						   		  {"F1","F2","F3","F4","F5","F6","F7","F8","F9","F10"},
								  {"G1","G2","G3","G4","G5","G6","G7","G8","G9","G10"},
						   		  {"H1","H2","H3","H4","H5","H6","H7","H8","H9","H10"},
						   		  {"I1","I2","I3","I4","I5","I6","I7","I8","I9","I10"},
						   		  {"J1","J2","J3","J4","J5","J6","J7","J8","J9","J10"}};


	private static String position = MAP_GRID[yCord][xCord];
	public static int tileType;

	public MapPanel() {
		this.setBackground(new Color(225, 225, 225));
		this.addKeyListener(keyC);
		this.setFocusable(true);
		this.setSize(SCREEN_EDGE_LENGTH, SCREEN_EDGE_LENGTH);

		tileType = TileManager.getTileGrid()[yCord][xCord];
		facing = 'D';

		gameThread = new Thread(this);
		gameThread.start();
	}

	public static String getPosition() {
		return position;
	}

	public void checkCollision() {
		topCollision = TileManager.getTileTypes()[TileManager.getTileGrid()[yCord][xCord]].isTop();
		bottomCollision = TileManager.getTileTypes()[TileManager.getTileGrid()[yCord][xCord]].isBottom();
		leftCollision = TileManager.getTileTypes()[TileManager.getTileGrid()[yCord][xCord]].isLeft();
		rightCollision = TileManager.getTileTypes()[TileManager.getTileGrid()[yCord][xCord]].isRight();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		TileManager.drawTiles(g2d);
		drawArrow(g2d);
	}

	public void drawArrow(Graphics2D g2d) {
		// x array is array of 3 x-coordinate points of triangle. (3 dots in line)
		// y array is array of 3 y-coordinate points of triangle. (3 dots in stack)
		// Fill polygon pairs the x and y values as 3 points and fills it in.
		g2d.setColor(new Color(0, 255, 0));
		if(facing == 'U') {
			int[] x = {xLocation, xLocation + (GRID_SIZE-1)/2, xLocation + GRID_SIZE-1};
			int[] y = {yLocation + GRID_SIZE-1, yLocation, yLocation + GRID_SIZE-1};
			g2d.fillPolygon(x, y, 3);
		}
		if(facing == 'D') {
			int[] x = {xLocation, xLocation + (GRID_SIZE-1)/2, xLocation + GRID_SIZE-1};
			int[] y = {yLocation, yLocation + GRID_SIZE-1, yLocation};
			g2d.fillPolygon(x, y, 3);
		}
		if(facing == 'R') {
			int[] x = {xLocation, xLocation + GRID_SIZE-1, xLocation};
			int[] y = {yLocation, yLocation + (GRID_SIZE-1)/2, yLocation + GRID_SIZE-1};
			g2d.fillPolygon(x, y, 3);
		}
		if(facing == 'L') {
			int[] x = {xLocation + GRID_SIZE-1, xLocation, xLocation + GRID_SIZE-1};
			int[] y = {yLocation, yLocation + (GRID_SIZE-1)/2, yLocation + GRID_SIZE-1};
			g2d.fillPolygon(x, y, 3);
		}
	}

	public void updatePosition() {
		tileType = TileManager.getTileGrid()[yCord][xCord];
		checkCollision();

		if (GamePanel.getMonster() == null || GamePanel.getMonster() != null) {
			if (keyC.upPressed) {
				//Check the direction facing, if not at top of screen, and not a wall above.
				if (facing == 'U' && yCord > 0 && !topCollision) {
					yCord--;
					position = MAP_GRID[yCord][xCord];
					yLocation -= GRID_SIZE;
				} else if (facing == 'D' && yCord < 9 && !bottomCollision) {
					yCord++;
					position = MAP_GRID[yCord][xCord];
					yLocation += GRID_SIZE;
				} else if (facing == 'L' && xCord > 0 && !leftCollision) {
					xCord--;
					position = MAP_GRID[yCord][xCord];
					xLocation -= GRID_SIZE;
				} else if (facing == 'R' && xCord < 9 && !rightCollision) {
					xCord++;
					position = MAP_GRID[yCord][xCord];
					xLocation += GRID_SIZE;
				}
			}

			if (keyC.downPressed) {
				switch (facing) {
					case 'U' -> facing = 'D';
					case 'D' -> facing = 'U';
					case 'L' -> facing = 'R';
					case 'R' -> facing = 'L';
				}
			}

			if (keyC.leftPressed) {
				switch (facing) {
					case 'U' -> facing = 'L';
					case 'D' -> facing = 'R';
					case 'L' -> facing = 'D';
					case 'R' -> facing = 'U';
				}
			}

			if (keyC.rightPressed) {
				switch (facing) {
					case 'U' -> facing = 'R';
					case 'D' -> facing = 'L';
					case 'L' -> facing = 'U';
					case 'R' -> facing = 'D';
				}
			}
		}
		GamePanel.update();
	}

	@Override
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		long currentTime;
		final double FPS = 6.0;
		final double drawInterval = 1_000_000_000 / FPS;
		double delta = 0;
		while(gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			if(delta >= 1) {
				updatePosition();

				repaint();
				delta = 0.0;
			}
			lastTime = currentTime;
		}
	}

}