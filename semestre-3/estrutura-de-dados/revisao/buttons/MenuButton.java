package buttons;

import javax.swing.*;
import java.awt.*;

public class MenuButton extends JButton {
    public MenuButton(String text, int x, int y) {
        setText(text);
        setFont(new Font("Arial", Font.BOLD, 25));
        setBounds(x, y, 300, 400);
        setBackground(new Color(70, 70, 70));
        setForeground(new Color(255, 255, 255));
    }
}
