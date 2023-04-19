package panels;

import java.awt.*;

import javax.swing.*;


public class GamePanel extends JPanel{
	//Height and width of the main panel
	public final int SCREEN_WIDTH = 600;
	public final int SCREEN_HEIGHT = 600;

	public JLabel backgroundLabel = new JLabel();
	public JLabel monsterLabel = new JLabel();
	public JLabel positionLabel = new JLabel();

	public ImageIcon monsterImage = new ImageIcon("src/res/monsters/Spaghetti.png");

	public String position;


	public GamePanel(){

		monsterLabel.setBounds(SCREEN_WIDTH/4 + 50, 50, 200, 200);
		monsterLabel.setIcon(monsterImage);

		this.add(monsterLabel);

		backgroundLabel.setBounds(SCREEN_WIDTH/4, 0, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
		this.add(backgroundLabel);

		positionLabel.setBounds(50, 50, 40, 20);
		this.add(positionLabel);
		this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(null);

	}

}