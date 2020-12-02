//import
import javax.swing.JPanel;
/**
 * TextPanel class to set up the text that is seen in the slot machine app
 */
public class TextPanel extends JPanel {
    String text;
    int size;
    /**
     * sets up the text panel
     */
    public TextPanel() {
        this("",12);
    }
    /**
     * sets up the text and size
     * @param text is the text in the text panel
     * @param size is the size of the text in the text panel
     */
    public TextPanel(String text, int size) {
        this.text = text;
        this.size = size;
    }
}
