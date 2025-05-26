package commons;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class NavigationButton extends JButton {
    public NavigationButton(String buttonText, int x, int y, int w, int h) {
        setText(buttonText);
        setFont(new Font("Arial", Font.BOLD, 20));
        setBounds(x, y, w, h);
        setBackground(new Color(20, 60, 100));
        setForeground(new Color(255, 255, 255));
    }
}