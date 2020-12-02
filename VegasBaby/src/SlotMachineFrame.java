//imports
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Class that set ups the frame of the Vegas Game
 */
public class SlotMachineFrame extends JFrame {
    private TileChecker tileChecker;
    private TileRandomizer tileRandomizer;
    private TilePanel pan;
    private String balance = "";
    private String haveMoney = "true";
    /**
     * sets the look of the frame and gui that is display for the game
     * also sets up the menu bar that contains file and help menus. File contains Load Tiles, Save Tiles, Print, Restart, Exit. Help contains About.
     * @param title is the title of the frame
     * @param left is how far the frame is from the left
     * @param top is how far the frame is from the top
     * @param width is how wide the frame is
     * @param height is how high the frame is
     */
    public void setLook(String title, int left, int top, int width, int height) {
        setTitle(title);
        setBounds(left, top, width, height);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        pan = new TilePanel();
        c.add(pan,BorderLayout.CENTER);
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        JButton btnMax = new JButton("Max");
        panSouth.add(btnMax);
        JButton btnMid = new JButton("Mid");
        panSouth.add(btnMid);
        JButton btnMin = new JButton("Min");
        panSouth.add(btnMin);
        panSouth.add(new JLabel("$"));
        JTextField txtMoney = new JTextField(5);
        txtMoney.setText("5.00");
        /**
         * Action for pressing the max button
         */
        btnMax.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e) {
                if (txtMoney.getText().equalsIgnoreCase("0.00") || txtMoney.getText().equalsIgnoreCase("0.0") || txtMoney.getText().equalsIgnoreCase("0")) {
                        haveMoney = "false";
                    } else {
                        haveMoney = "true";
                    }
                    if (haveMoney.equalsIgnoreCase("true")) {
                    boolean test;
                    boolean test2;
                    double mult;
                    ArrayList<Tile> tiles = pan.getTiles();
                    tileRandomizer = new TileRandomizer();
                    tileRandomizer.tileRandomizer(tiles);
                    repaint();
                    tileChecker = new TileChecker();
                    test = tileChecker.tileCheckerShape(tiles);
                    test2 = tileChecker.tileCheckerColor(tiles);
                    balance = txtMoney.getText();
                    double balance2 = Double.parseDouble(balance);
                    if (test && test2) {
                        mult = 100;
                    }
                    else if (test2 && !test){
                        mult = 25;
                    } else {
                        mult = 0;
                    }
                    balance2 = balance2 * mult;
                    String balance = String.valueOf(balance2);
                    txtMoney.setText(balance);
                    }
                    else {}
            }
        });
        /**
         * Action for pressing the mid button
         */
        btnMid.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e) {
                if (txtMoney.getText().equalsIgnoreCase("0.00") || txtMoney.getText().equalsIgnoreCase("0.0") || txtMoney.getText().equalsIgnoreCase("0")) {
                    haveMoney = "false";
                } else {
                    haveMoney = "true";
                }
                if (haveMoney.equalsIgnoreCase("true")) {
                boolean test;
                boolean test2;
                double mult;
                ArrayList<Tile> tiles = pan.getTiles();
                tileRandomizer = new TileRandomizer();
                tileRandomizer.tileRandomizer(tiles);
                repaint();
                tileChecker = new TileChecker();
                test = tileChecker.tileCheckerShape(tiles);
                test2 = tileChecker.tileCheckerColor(tiles);
                balance = txtMoney.getText();
                double balance2 = Double.parseDouble(balance);
                double wager = balance2/2;
                balance2 = balance2 - wager;
                if (test && test2) {
                    mult = 50;
                }
                else if (test2 && !test){
                    mult = 10;
                } else {
                    mult = 0;
                }
                balance2 = balance2 + wager * mult;
                String balance = String.valueOf(balance2);
                txtMoney.setText(balance);
                }
                else {}
            }
        });
        /**
         * Action for pressing the min button
         */
        btnMin.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e) {
                if (txtMoney.getText().equalsIgnoreCase("0.00") || txtMoney.getText().equalsIgnoreCase("0.0") || txtMoney.getText().equalsIgnoreCase("0")) {
                    haveMoney = "false";
                } else {
                    haveMoney = "true";
                }
                if (haveMoney.equalsIgnoreCase("true")) {
                boolean test;
                boolean test2;
                double mult;
                ArrayList<Tile> tiles = pan.getTiles();
                tileRandomizer = new TileRandomizer();
                tileRandomizer.tileRandomizer(tiles);
                repaint();
                tileChecker = new TileChecker();
                test = tileChecker.tileCheckerShape(tiles);
                test2 = tileChecker.tileCheckerColor(tiles);
                balance = txtMoney.getText();
                double balance2 = Double.parseDouble(balance);
                double wager = balance2 * .1;
                balance2 = balance2 - wager;
                if (test && test2) {
                    mult = 10;
                }
                else if (test2 && !test){
                    mult = 5;
                } else {
                    mult = 0;
                }
                balance2 = balance2 + wager * mult;
                String balance = String.valueOf(balance2);
                txtMoney.setText(balance);
                }
                else {}
            }
        });
        panSouth.add(txtMoney);
        c.add(panSouth,BorderLayout.SOUTH);
        JMenuBar mbar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenuItem miLoad = new JMenuItem("Load Tiles");
        miLoad.addActionListener(new ActionListener() {
            /**
             * Action for pressing on the load item
             */
            public void actionPerformed(ActionEvent e) {
                File f;
                ArrayList<Tile> tiles;
                JFileChooser jfc = new JFileChooser();
                TileReader tr = new TileReader();
                String extension;
                if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    tiles = tr.read(jfc.getSelectedFile());
                    if (tiles != null) {
                        pan.setTiles(tiles);
                    } else {
                        JOptionPane.showMessageDialog(null, "Could not read tiles.");
                    }
                    repaint();
                }
            }
        });
        mnuFile.add(miLoad);
        JMenuItem miSave = new JMenuItem("Save Tiles");
        /**
         * Action for pressing on the save item
         */
        miSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TileWriter tw = new TileWriter();
                JFileChooser jfc = new JFileChooser();
                File f;
                if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                        if (tw.write(jfc.getSelectedFile(),pan.getTiles())) {
                            JOptionPane.showMessageDialog(null, "Wrote tiles information");
                    } else {
                        JOptionPane.showMessageDialog(null,"Could not write tiles information");
                    }
                }  
            }
        });
        mnuFile.add(miSave);
        JMenuItem miPrint = new JMenuItem("Print");
        /**
         * Action for pressing the print item
         */
        miPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Tile> tiles = pan.getTiles();
                for (Tile tile : tiles) {
                    System.out.println(tile);
                }
            }
        });
        mnuFile.add(miPrint);
        JMenuItem miRestart = new JMenuItem("Restart");
        /**
         * Action for pressing the restart item
         */
        miRestart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtMoney.setText("5.00");
                haveMoney = "true";
            }
        });
        mnuFile.add(miRestart);
        JMenuItem miExit = new JMenuItem("Exit");
        /**
         * Action for pressing on the exit item
         */
        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnuFile.add(miExit);
        mbar.add(mnuFile);
        JMenu mnuHelp = new JMenu("Help");
        JMenuItem miAbout = new JMenuItem("About");
        /**
         * Action for pressing on the about item
         */
        miAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Ryan Corrigan\nhttps://github.com/corriganry/corrigan_ryan_cpsc24500");
            }
        });
        mnuHelp.add(miAbout);
        mbar.add(mnuHelp);
        setJMenuBar(mbar);

    }
    /**
     * setting up and calling the frame into existence
     */
    public SlotMachineFrame() {
        setLook("Vegas Baby Vegas Slot Machine", 485, 365, 950, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
