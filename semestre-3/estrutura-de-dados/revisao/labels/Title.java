package labels;

import javax.swing.*;
import java.awt.*;

public class Title extends JLabel {
    public Title(String text, int x, int width) {
        setText(text);
        setForeground(new Color(210, 210, 210));
        setFont(new Font("", Font.BOLD, 70));
        setBounds(x, 80, width, 100);
    }
}