package views;

import entities.Client;
import utils.ClientLabel;
import utils.ReturnButton;
import utils.Title;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ClientScreen extends JPanel {
    public ClientScreen(CardLayout cardLayout, JPanel cards, Client client, ArrayList<Integer> numbers, PriorityQueue<Client> clientQueue) {
        setLayout(null);
        setBackground(new Color(20, 20, 20));

        Title title = new Title("Atendimento solicitado", 180, 820);
        ClientLabel clientLabel = new ClientLabel(client);

        ReturnButton returnButton = new ReturnButton();
        returnButton.addActionListener(e -> {
            ClientMenuScreen clientMenuScreen = new ClientMenuScreen(cardLayout, cards, numbers, clientQueue);
            cards.add(clientMenuScreen, "ClientMenuScreen");
            cardLayout.show(cards, "ClientMenuScreen");
        });

        add(title);
        add(clientLabel);
        add(returnButton);
    }
}
