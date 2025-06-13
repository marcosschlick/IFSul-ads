import views.HomeScreen;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gerenciador de Estruturas de Dados");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        CardLayout cardLayout = new CardLayout();
        JPanel cards = new JPanel(cardLayout);

        cards.add(new HomeScreen(cardLayout, cards), "HomeScreen");

        frame.add(cards);

        frame.setVisible(true);
    }
}