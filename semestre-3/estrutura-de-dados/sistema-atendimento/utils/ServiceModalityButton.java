package utils;

import entities.Client;
import entities.ServiceModality;
import views.ClientScreen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ServiceModalityButton extends JButton {
    public ServiceModalityButton(String text, int x, int y, CardLayout cardLayout, JPanel cards, ArrayList<Integer> numbers, ServiceModality serviceModality, PriorityQueue<Client> clientQueue) {
        setText(text);
        setFont(new Font("Arial", Font.BOLD, 22));
        setBounds(x, y, 300, 150);
        setBackground(new Color(70, 70, 70));
        setForeground(new Color(255, 255, 255));

        addActionListener(e -> {
            Client client = new Client(numbers, serviceModality);
            clientQueue.add(client);
            ClientScreen clientScreen = new ClientScreen(cardLayout, cards, client, numbers, clientQueue);
            cards.add(clientScreen, "ClientScreen");
            cardLayout.show(cards, "ClientScreen");
        });
    }
}
