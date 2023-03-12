package panels;

import inputs.KeyController;
import tiles.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class MapPanel extends JPanel implements Runnable {
	
	static final int GRID_SIZE = 25;
	public static final int SCREEN_EDGE_LENGTH = GRID_SIZE * 10 +1;
	final Dimension SCREEN_SIZE = new Dimension(SCREEN_EDGE_LENGTH, SCREEN_EDGE_LENGTH);
	//Grid location to start at.
	int xCord = 4;
	int yCord = 4;
	//Pixel location to start at.
	int xLocation = 1 + xCord * GRID_SIZE;
	int yLocation = 1 + yCord * GRID_SIZE;
	//Initial direction arrow faces.
	char facing = 'D';
	JLabel locationLabel;
	public final double FPS = 60.0;
	//Collision check booleans
	boolean topCollision;
	boolean bottomCollision;
	boolean leftCollision;
	boolean rightCollision;

	KeyController keyC = new KeyController();
	Thread gameThread;
	GamePanel gamePanel;
	
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

	//adjust numbers in the grid to change map layout
	/*
	private final int[][] TILE_GRID = {{8, 1, 1, 9, 9, 9, 9, 9, 9, 5},
									   {4, 3, 6, 8, 9, 9, 9, 1, 14, 10},
									   {4, 1, 5, 10, 8, 9, 1, 6, 12, 2},
									   {11, 10, 7, 2, 10, 12, 3, 1, 14, 10},
									   {8, 0, 5, 11, 4, 5, 8, 2, 8, 2},
									   {4, 0, 0, 9, 3, 2, 10, 11, 4, 6},
									   {10, 7, 6, 8, 14, 10, 7, 5, 7, 5},
									   {7, 9, 1, 6, 12, 3, 5, 4, 5, 10},
									   {8, 14, 4, 1, 1, 1, 2, 4, 6, 10},
									   {7, 9, 3, 6, 7, 3, 3, 6, 12, 6}};

	 */

	private String position = MAP_GRID[yCord][xCord];
	TileManager tm = new TileManager(GRID_SIZE, GRID_SIZE);

	public MapPanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		this.setBackground(new Color(225, 225, 225));
		this.addKeyListener(keyC);
		this.setFocusable(true);
		this.setSize(SCREEN_EDGE_LENGTH, SCREEN_EDGE_LENGTH);
		this.setPreferredSize(SCREEN_SIZE);
		
		locationLabel = new JLabel("Position: " + position);
		locationLabel.setBounds(15, 250, 100, 50);

		gameThread = new Thread(this);
		gameThread.start();
	}

	public String getPosition() {
		return position;
	}

	public void checkCollision() {
		topCollision = tm.getTileTypes()[tm.getTileGrid()[yCord][xCord]].isTop();
		bottomCollision = tm.getTileTypes()[tm.getTileGrid()[yCord][xCord]].isBottom();
		leftCollision = tm.getTileTypes()[tm.getTileGrid()[yCord][xCord]].isLeft();
		rightCollision = tm.getTileTypes()[tm.getTileGrid()[yCord][xCord]].isRight();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		tm.drawTiles(g);
		drawArrow(g);
	}

	public void drawArrow(Graphics g) {
		//x array is array of 3 x-coordinate points of triangle. (3 dots in line)
		//y array is array of 3 y-coordinate points of triangle. (3 dots in stack)
		//Fill polygon pairs the x and y values as 3 points and fills it in.
		g.setColor(new Color(0, 255, 0));
		if(facing == 'U') {
			int[] x = {xLocation, xLocation + (GRID_SIZE-1)/2, xLocation + GRID_SIZE-1};
			int[] y = {yLocation + GRID_SIZE-1, yLocation, yLocation + GRID_SIZE-1};
			g.fillPolygon(x, y, 3);
		}
		if(facing == 'D') {
			int[] x = {xLocation, xLocation + (GRID_SIZE-1)/2, xLocation + GRID_SIZE-1};
			int[] y = {yLocation, yLocation + GRID_SIZE-1, yLocation};
			g.fillPolygon(x, y, 3);
		}
		if(facing == 'R') {
			int[] x = {xLocation, xLocation + GRID_SIZE-1, xLocation};
			int[] y = {yLocation, yLocation + (GRID_SIZE-1)/2, yLocation + GRID_SIZE-1};
			g.fillPolygon(x, y, 3);
		}
		if(facing == 'L') {
			int[] x = {xLocation + GRID_SIZE-1, xLocation, xLocation + GRID_SIZE-1};
			int[] y = {yLocation, yLocation + (GRID_SIZE-1)/2, yLocation + GRID_SIZE-1};
			g.fillPolygon(x, y, 3);
		}
	}

	public void updatePosition() {
		ImageIcon backgroundImage;
		int tileType = tm.getTileGrid()[yCord][xCord];
		checkCollision();

		if(keyC.upPressed) {
			//Check the direction facing, if not at top of screen, and not a wall above.
			if(facing == 'U' && yCord > 0 && !topCollision) {
				yCord--;
				position = MAP_GRID[yCord][xCord];
				yLocation -= GRID_SIZE;
			}
			else if(facing == 'D' && yCord < 9 && !bottomCollision) {
				yCord++;
				position = MAP_GRID[yCord][xCord];
				yLocation += GRID_SIZE;
			}
			else if(facing == 'L' && xCord > 0 && !leftCollision) {
				xCord--;
				position = MAP_GRID[yCord][xCord];
				xLocation -= GRID_SIZE;
			}
			else if(facing == 'R' && xCord < 9 && !rightCollision) {
				xCord++;
				position = MAP_GRID[yCord][xCord];
				xLocation += GRID_SIZE;
			}
		}

		if (keyC.downPressed) {
			switch (facing) {
				case 'U':
					facing = 'D';
					break;
				case 'D':
					facing = 'U';
					break;
				case 'L':
					facing = 'R';
					break;
				case 'R':
					facing = 'L';
					break;
			}
		}

		if (keyC.leftPressed) {
			switch (facing) {
				case 'U':
					facing = 'L';
					break;
				case 'D':
					facing = 'R';
					break;
				case 'L':
					facing = 'D';
					break;
				case 'R':
					facing = 'U';
					break;
			}
		}

		if (keyC.rightPressed) {
			switch (facing) {
				case 'U':
					facing = 'R';
					break;
				case 'D':
					facing = 'L';
					break;
				case 'L':
					facing = 'U';
					break;
				case 'R':
					facing = 'D';
					break;
			}
		}

		backgroundImage = tm.getBackgroundImage(tileType, facing);
		gamePanel.backgroundLabel.setIcon(backgroundImage);
	}

	@Override
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double timeUntilUpdate = 1_000_000_000 / FPS;
		double delta = 0.0;
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / timeUntilUpdate;
			lastTime = now;
			if(delta >= 1) {
				updatePosition();
				gamePanel.position = getPosition();
				gamePanel.positionLabel.setText(position);
				try {
					gameThread.sleep(150);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				repaint();
				delta = 0.0;
			}
		}
	}

}