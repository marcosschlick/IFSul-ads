package utils;

import javax.swing.*;
import java.awt.*;

public class BigButton extends JButton {
    public BigButton(String text, int x, int y) {
        setText(text);
        setFont(new Font("Arial", Font.BOLD, 56));
        setBounds(x, y, 340, 360);
        setBackground(new Color(70, 70, 70));
        setForeground(new Color(255, 255, 255));
    }
}
