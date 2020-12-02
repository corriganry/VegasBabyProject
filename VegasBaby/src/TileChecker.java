import java.util.ArrayList;
/**
 * this class checks the tiles to see if they have same shapes and colors
 */
public class TileChecker {
    private ArrayList<Tile> tiles;
    public String test = "";
    public String test2 = "";
    /**
     * checks to see if the tiles have the same shapes
     * @param tiles are the tiles from TilePanel
     * @return boolean value for if the shapes all match or not
     */
    public boolean tileCheckerShape(ArrayList<Tile> tiles) {
        if (tiles.get(0).getShape() == tiles.get(1).getShape() && tiles.get(1).getShape() == tiles.get(2).getShape() && tiles.get(2).getShape() == tiles.get(3).getShape()) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * checks to see if the tiles have the same colors
     * @param tiles are the tiles from TilePanel
     * @return boolean value for if the colors all match or not
     */
    public boolean tileCheckerColor(ArrayList<Tile> tiles) {
        if (tiles.get(0).getColor() == tiles.get(1).getColor() && tiles.get(1).getColor() == tiles.get(2).getColor() && tiles.get(2).getColor() == tiles.get(3).getColor()) {
             return true;
        } else {
            return false;
        }
    }
}
