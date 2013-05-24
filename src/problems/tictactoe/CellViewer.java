package problems.tictactoe;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

class CellViewer extends JPanel {

    private JLabel text;

    public CellViewer() {
        text = new JLabel();
        add(text);
        setPreferredSize(new Dimension(30, 30));
        setBorder(new LineBorder(Color.black));
    }

    public String getText() {
        return text.getText();
    }

    public void setText(String string) {
        text.setText(string);
    }
}
