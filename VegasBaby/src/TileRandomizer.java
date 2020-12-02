import java.util.ArrayList;
/**
 * class for randomizing the tiles
 */
public class TileRandomizer {
    /**
     * This Object takes the tiles and randomizes them
     * @param tiles are the tiles that are taken from TilePanel
     */
    public void tileRandomizer(ArrayList<Tile> tiles) {
        for (Tile tile : tiles){
            tile.setRandomly();
        }
    }
}
