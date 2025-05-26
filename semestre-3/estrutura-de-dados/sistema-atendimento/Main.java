import entities.Client;
import views.HomeScreen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de atendimento");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        CardLayout cardLayout = new CardLayout();
        JPanel cards = new JPanel(cardLayout);

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(0);

        PriorityQueue<Client> clientQueue = new PriorityQueue<>();

        cards.add(new HomeScreen(cardLayout, cards, numbers, clientQueue), "HomeScreen");

        frame.add(cards);

        frame.setVisible(true);
    }
}