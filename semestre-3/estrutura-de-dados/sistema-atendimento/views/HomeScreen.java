package views;

import entities.Client;
import utils.BigButton;
import utils.Title;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class HomeScreen extends JPanel {
    public HomeScreen(CardLayout cardLayout, JPanel cards, ArrayList<Integer> numbers, PriorityQueue<Client> clientQueue) {
        setLayout(null);
        setBackground(new Color(20, 20, 20));

        Title title = new Title("Você é", 480, 240);

        BigButton ClientButton = new BigButton("Cliente", 250, 300);
        ClientButton.addActionListener(e -> {
            ClientMenuScreen clientMenuScreen = new ClientMenuScreen(cardLayout, cards, numbers, clientQueue);
            cards.add(clientMenuScreen, "ClientMenuScreen");
            cardLayout.show(cards, "ClientMenuScreen");
        });
        BigButton AttendantButton = new BigButton("Atendente", 610, 300);
        AttendantButton.addActionListener(e -> {
            AttendantScreen attendantScreen = new AttendantScreen(cardLayout, cards, clientQueue);
            cards.add(attendantScreen, "AttendantScreen");
            cardLayout.show(cards, "AttendantScreen");
        });

        add(title);
        add(ClientButton);
        add(AttendantButton);
    }
}
