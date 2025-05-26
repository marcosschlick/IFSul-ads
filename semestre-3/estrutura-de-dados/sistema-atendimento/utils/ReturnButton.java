package utils;

import javax.swing.*;
import java.awt.*;

public class ReturnButton extends JButton {
    public ReturnButton() {
        setText("Voltar");
        setFont(new Font("Arial", Font.BOLD, 20));
        setBounds(30, 20, 100, 50);
        setBackground(new Color(70, 70, 70));
        setForeground(new Color(255, 255, 255));
    }
}