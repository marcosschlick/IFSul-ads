package commons;

import javax.swing.*;
import java.awt.*;

public class ReturnButton extends JButton {
    public ReturnButton() {
        setText("Voltar");
        setFont(new Font("Arial", Font.BOLD, 20));
        setBounds(1000, 650, 100, 50);
        setBackground(new Color(20, 60, 100));
        setForeground(new Color(255, 255, 255));
    }
}