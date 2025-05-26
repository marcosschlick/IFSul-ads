package views;

import entities.Client;
import entities.ServiceModality;
import utils.ReturnButton;
import utils.ServiceModalityButton;
import utils.Title;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ClientMenuScreen extends JPanel {
    public ClientMenuScreen(CardLayout cardLayout, JPanel cards, ArrayList<Integer> numbers, PriorityQueue<Client> clientQueue) {
        setLayout(null);
        setBackground(new Color(20, 20, 20));

        Title title = new Title("Selecione a sua modalidade", 110, 980);

        ServiceModalityButton generalButton = new ServiceModalityButton("Geral", 275, 300, cardLayout, cards, numbers, ServiceModality.GENERAL, clientQueue);

        ServiceModalityButton elderlyButton = new ServiceModalityButton("Idosos", 625, 300, cardLayout, cards, numbers, ServiceModality.ELDERLY, clientQueue);

        ServiceModalityButton maternityButton = new ServiceModalityButton("Gestantes", 275, 500, cardLayout, cards, numbers, ServiceModality.MATERNITY, clientQueue);

        ServiceModalityButton accessibilityButton = new ServiceModalityButton("Pessoas com Deficiência", 625, 500, cardLayout, cards, numbers, ServiceModality.ACCESSIBILITY, clientQueue);

        ReturnButton returnButton = new ReturnButton();
        returnButton.addActionListener(e -> { cardLayout.show(cards, "HomeScreen");});

        add(title);
        add(generalButton);
        add(elderlyButton);
        add(maternityButton);
        add(accessibilityButton);

        add(returnButton);
    }
}
