package buttons;

import javax.swing.*;
import java.awt.*;

public class ReturnButton extends JButton {
    public ReturnButton(CardLayout cardLayout, JPanel cards) {
        setText("voltar");
        setFont(new Font("Arial", Font.BOLD, 20));
        setBounds(30, 20, 100, 50);
        setBackground(new Color(150, 150, 150));
        setForeground(new Color(255, 255, 255));
        addActionListener(e -> { cardLayout.show(cards, "HomeScreen");});
    }
}