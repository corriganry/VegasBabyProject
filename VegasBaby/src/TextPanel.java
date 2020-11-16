//import
import javax.swing.JPanel;
/**
 * TextPanel class to set up the text that is seen in the slot machine app
 */
public class TextPanel extends JPanel {
    String text;
    int size;
    public TextPanel() {
        this("",12);
    }
    public TextPanel(String text, int size) {
        this.text = text;
        this.size = size;
    }
}
