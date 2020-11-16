//imports
import java.io.Serializable;
import java.util.Random;
/**
 * Tile class that holds the color and shape of the tile
 */
public class Tile implements Serializable {
    private int shape;
    private int color;
    /**
     * get function for shape
     * @return the shape of the tile
     */
    public int getShape() {
        return shape;
    }
    /**
     * get function for color
     * @return the color of the tile
     */
    public int getColor() {
        return color;
    }
    /**
     * set function for shape
     * @param s is the shape that we want to set the tile to
     */
    public void setShape(int shape) {
        this.shape = shape;
    }
    /**
     * set function for color
     * @param c is the color that we want to set the tile to
     */
    public void setColor(int color) {
        this.color = color;
    }
    /**
     * sets the properties of the tile
     */
    public Tile() {
        color = 0;
        shape = 0;
        
    }
    /**
     * 
     * @param shape is a number that specifies what shape the tile should be
     * @param color is a number that specifies what color the tile should be
     */
    public Tile(int shape, int color) {
        setShape(shape);
        setColor(color);
    }
    /**
     * function to randomly set the color and shape of the tile
     */
    public void setRandomly() {
        Random rnd = new Random();
        int rand1 = rnd.nextInt(4);
        int rand2 = rnd.nextInt(2);
        setColor(rand1);
        setShape(rand2);
    }
    /**
     * to string function to write the shape and color to a string
     */
    public String toString() {
        return String.format("%d %d", shape, color);
    }
}
