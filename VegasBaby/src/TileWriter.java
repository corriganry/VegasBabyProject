//imports
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * This class writes the color and shapes of the tiles into a text file
 */
public class TileWriter {
    /**
     * writes the color and shapes to a text file
     * @param fname
     * @param tiles
     * @return is the call to the function to write the color and shape to text
     */
    public boolean writeToText(String fname, ArrayList<Tile> tiles) {
        File f = new File(fname);
        return writeToText(f, tiles);
    }
    /**
     * function that actually writes the text into the file
     * @param f is the file name
     * @param tiles are the tiles that are found in the program
     * @return is the indicator if the file save was successful or not
     */
    public boolean writeToText(File f, ArrayList<Tile> tiles) {
        try{
            PrintWriter pw = new PrintWriter(new
                    BufferedWriter(new FileWriter(f)));
            for (Tile tile: tiles) {
                pw.println(tile);
            }
            pw.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    /**
     * writes the color and shapes to a binary file
     * @param fname is the name of the file
     * @param tiles are the tiles that are found in the program
     * @return is the call to the function to write the color and shape to file
     */
    public boolean writeToBinary(String fname, ArrayList<Tile> tiles) {
        File f = new File(fname);
        return writeToBinary(f,tiles);
    }
    /**
     * function that actually writes the binary into the file
     * @param f is the file name
     * @param tiles are the tiles that are found in the program
     * @return is the indicator if the file save was successful or not
     */
    public boolean writeToBinary(File f, ArrayList<Tile> tiles) {
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tiles);
            oos.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    /**
     * writes the color and shapes to a XML file
     * @param fname is the name of the file
     * @param tiles are the tiles that are found in the program
     * @return is the call to the function to write the color and shape to the file
     */
    public boolean writeToXML(String fname, ArrayList<Tile> tiles) {
        File f = new File(fname);
        return writeToXML(f, tiles);
    }
    /**
     * function that actually writes the XML into the file
     * @param f is the name of the file
     * @param tiles are the tiles that are found in the program
     * @return is the indicator if the file save was successful or not
     */
    public boolean writeToXML(File f, ArrayList<Tile> tiles) {
        try {
            XMLEncoder enc = new XMLEncoder(new
                    BufferedOutputStream(new FileOutputStream(f)));
            enc.writeObject(tiles);
            enc.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    /**
     * function that finds the type of file
     * @param fname is the name of the file
     * @param tiles are the tiles that are found in the program
     * @return is the type of file
     */
    public boolean write(String fname, ArrayList<Tile> tiles) {
        File f = new File(fname);
        return write(f, tiles);
    }
    /**
     * function that determines what type of file it is
     * @param f is the name of the file
     * @param tiles are the tiles that are found in the program
     * @return is the type of file
     */
    public boolean write(File f, ArrayList<Tile> tiles) {
        String fname = f.getName().toUpperCase();
        if (fname.endsWith("BIN")) {
            return writeToBinary(f, tiles);
        } else if (fname.endsWith("TXT")) {
            return writeToText(f, tiles);
        } else if (fname.endsWith("XML")) {
            return writeToXML(f, tiles);
        } else {
            return false;
        }
    }
}
