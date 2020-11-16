//imports
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * class that reads the tiles from a file and implements them into the program
 */
public class TileReader {
    /**
     * reads the text from the file
     * @param fname is the name of the file
     * @return is the text read from the file
     */
    public ArrayList<Tile> readFromText(String fname) {
        File f = new File(fname);
        return readFromText(f);
    }
    /**
     * puts the text into an array list
     * @param f is the file once again
     * @return the text into an array list
     */
    public ArrayList<Tile> readFromText(File f) {
        try {
            Scanner fsc = new Scanner(f);
            ArrayList<Tile> result = new ArrayList<Tile>();
            String line;
            String[] parts;
            int shape, color;
            Tile tile;
            while (fsc.hasNextLine()) {
                line = fsc.nextLine().trim();
                if(line.length() > 0) {
                    parts = line.split(" ");
                    shape = Integer.parseInt(parts[0]);
                    color = Integer.parseInt(parts[1]);
                    tile = new Tile(shape,color);
                    result.add(tile);
                }
            }
            fsc.close();
            return result;
        } catch (Exception ex) {
            return null;
        }
    }
    public ArrayList<Tile> readFromBinary(String fname) {
        File f = new File(fname);
        return readFromBinary(f);
    }
    public ArrayList<Tile> readFromBinary(File f) {
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Tile> result = (ArrayList<Tile>)(ois.readObject());
            return result;
        } catch (Exception ex) {
            return null;
        }
    }
    public ArrayList<Tile> readFromXML(String fname) {
        File f = new File(fname);
        return readFromText(f);
    }
    public ArrayList<Tile> readFromXML(File f) {
        try {
            XMLDecoder dec = new XMLDecoder(
                    new BufferedInputStream(new FileInputStream(f)));
            ArrayList<Tile> result = (ArrayList<Tile>)(dec.readObject());
            dec.close();
            return result;
        } catch (Exception ex) {
            return null;
        }
    }
    public ArrayList<Tile> read(String fname) {
        File f = new File(fname);
        return read(f);
    }
    public ArrayList<Tile> read(File f) {
        String fname = f.getName().toUpperCase();
        if (fname.endsWith("BIN")) {
            return readFromBinary(f);
        } else if (fname.endsWith("TXT")) {
            return readFromText(f);
        } else if (fname.endsWith("XML")) {
            return readFromXML(f);
        } else {
            return null;
        }
    }
}
