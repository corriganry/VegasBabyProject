//imports
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import javax.swing.JPanel;
/**
 * Class for the TilePanel that displays the tiles and allows me click on each tile and change that tile randomly
 */
public class TilePanel extends JPanel implements MouseListener {
    private ArrayList<Tile> tiles;
    private int shape;
    private int color;
    private int x, y;
    
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
    public void setShape(int s) {
        shape = s;
    }
    /**
     * set function for color
     * @param c is the color that we want to set the tile to
     */
    public void setColor(int c) {
        color = c;
    }
    /**
     * function to get the tiles from an array list
     * @return the tiles found in the array list
     */
    public ArrayList<Tile> getTiles() {
        return tiles;
    }
    /**
     * function to set the tiles to certain tiles in the array list
     * @param tiles are the tiles that are found in the program
     */
    public void setTiles(ArrayList<Tile> tiles) {
        this.tiles = tiles;
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
     * calls the tiles that are required into existence and gives them base colors and shapes
     * also adds the mouse listener to the tile panel
     */
    public TilePanel() {
        tiles = new ArrayList<Tile>();
        Tile tile1 = new Tile(0,0);
        tiles.add(tile1);
        Tile tile2 = new Tile(1,4);
        tiles.add(tile2);
        Tile tile3 = new Tile(1,3);
        tiles.add(tile3);
        Tile tile4 = new Tile(1,3);
        tiles.add(tile4);
        addMouseListener(this);
    }
    /**
     * paints the tiles that were previously created
     * also paints the tiles after they are randomly changed
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int counter = 50;
        for (Tile tile : tiles) {
            if (tile.getColor() == 0) {
                g.setColor(Color.YELLOW);
            }
            else if (tile.getColor() == 1) {
                g.setColor(Color.GREEN);
            }
            else if (tile.getColor() == 2) {
                g.setColor(Color.ORANGE);
            }
            else if (tile.getColor() == 3) {
                g.setColor(Color.RED);
            }
            else if (tile.getColor() == 4) {
                g.setColor(Color.BLUE);
            }
            if (tile.getShape() == 0) {
                g.fillOval(counter, 50, 175, 175);
            }
            else if (tile.getShape() == 1) {
                g.fillRect(counter, 50, 175, 175);
            }
            counter += 220;
        }       
    } 
    /**
     * mouse event when a user clicks on one of the tiles to change it
     * was unsure if you wanted the user to be able to get the same tile after the randomization so I made it
     * that the user was unable to get the same color and shape after clicking on the tile
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        if (x >= 50 & x <= 225 & y >= 50 & y <= 225) {
            int shape1 = tiles.get(0).getShape();
            int color1 = tiles.get(0).getColor();
            tiles.get(0).setRandomly();
            while (shape1 == tiles.get(0).getShape() && color1 == tiles.get(0).getColor()) {
                tiles.get(0).setRandomly();
            }
            repaint();
        }
        if (x >= 270 & x <= 445 & y >= 50 & y <= 225) {
            int shape1 = tiles.get(1).getShape();
            int color1 = tiles.get(1).getColor();
            tiles.get(1).setRandomly();
            while (shape1 == tiles.get(1).getShape() && color1 == tiles.get(1).getColor()) {
                tiles.get(1).setRandomly();
            }
            repaint();
        }
        if (x >= 490 & x <= 665 & y >= 50 & y <= 225) {
            int shape1 = tiles.get(2).getShape();
            int color1 = tiles.get(2).getColor();
            tiles.get(2).setRandomly();
            while (shape1 == tiles.get(2).getShape() && color1 == tiles.get(2).getColor()) {
                tiles.get(2).setRandomly();
            }
            repaint();
        }
        if (x >= 710 & x <= 885 & y >= 50 & y <= 225) {
            int shape1 = tiles.get(3).getShape();
            int color1 = tiles.get(3).getColor();
            tiles.get(3).setRandomly();
            while (shape1 == tiles.get(2).getShape() && color1 == tiles.get(3).getColor()) {
                tiles.get(3).setRandomly();
            }
            repaint();
        }
    }
    /**
     * Other mouse events that are required when implementing MouseListener into TilePanel
     */
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
