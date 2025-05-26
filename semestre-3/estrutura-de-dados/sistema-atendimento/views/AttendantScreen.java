package views;

import entities.Client;
import utils.AttendentPanel;
import utils.ReturnButton;
import utils.Title;

import javax.swing.*;
import java.awt.*;
import java.util.PriorityQueue;

public class AttendantScreen extends JPanel {
    public AttendantScreen(CardLayout cardLayout, JPanel cards, PriorityQueue<Client> clientQueue) {
        setLayout(null);
        setBackground(new Color(20, 20, 20));

        Title title = new Title("Tela de atendimento", 230, 740);

        JScrollPane jscrollPane = new JScrollPane();
        jscrollPane.setBounds(200, 200, 800, 500);

        AttendentPanel panel = new AttendentPanel(clientQueue);

        jscrollPane.setViewportView(panel);

        ReturnButton returnButton = new ReturnButton();
        returnButton.addActionListener(e -> { cardLayout.show(cards, "HomeScreen");});

        add(title);
        add(jscrollPane);
        add(returnButton);
    }
}
