package tiles;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tile {

    private boolean top, bottom, left, right;
    private boolean[] tileWalls;
    private BufferedImage image = null;
    private boolean visited;

    public Tile(boolean[] tileWalls) {
        this.top = tileWalls[0];
        this.bottom = tileWalls[1];
        this.left = tileWalls[2];
        this.right = tileWalls[3];
        this.tileWalls = tileWalls;
    }

    public Tile(boolean[] tileWalls, String filePath) {
        this.top = tileWalls[0];
        this.bottom = tileWalls[1];
        this.left = tileWalls[2];
        this.right = tileWalls[3];
        this.tileWalls = tileWalls;
        setImage(filePath);
    }

    public boolean isTop() {
        return top;
    }

    public boolean isBottom() {
        return bottom;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean[] getTileWalls() {
        return this.tileWalls;
    }

    private void setImage(String imagePath) {
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream(imagePath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            this.image = null;
        } catch (IllegalArgumentException e) {
            System.out.println("Bad file path");
        }
    }

    public BufferedImage getImage () {
        return image;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
