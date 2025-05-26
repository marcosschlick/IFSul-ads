package commons;

import javax.swing.*;
import java.awt.*;

public class Subtitle extends JLabel {
    public Subtitle(String text, int y) {
        setText(text);
        setForeground(new Color(0, 0, 0));
        setFont(new Font("", Font.BOLD, 30));
        setBounds(100, y, 600, 25);
        setVisible(true);
    }
}
