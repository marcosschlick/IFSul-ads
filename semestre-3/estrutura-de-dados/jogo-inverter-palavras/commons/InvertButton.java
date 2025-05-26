package commons;

import javax.swing.*;
import java.awt.*;

public class InvertButton extends JButton {
    public InvertButton() {
        setText("Inverter Frase");
        setFont(new Font("Arial", Font.BOLD, 30));
        setBounds(450, 600, 300, 100);
        setBackground(new Color(20, 60, 100));
        setForeground(new Color(255, 255, 255));
    }
}