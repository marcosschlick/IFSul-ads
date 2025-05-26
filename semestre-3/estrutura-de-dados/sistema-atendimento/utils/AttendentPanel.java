package utils;

import entities.Client;
import javax.swing.*;
import java.awt.*;
import java.util.PriorityQueue;

public class AttendentPanel extends JPanel {
    private final PriorityQueue<Client> clientQueue;
    private final JPanel clientsPanel;

    public AttendentPanel(PriorityQueue<Client> clientQueue) {
        this.clientQueue = clientQueue;
        setLayout(new BorderLayout());

        clientsPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        clientsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(new JScrollPane(clientsPanel), BorderLayout.CENTER);
        refreshClientList();
    }

    private void refreshClientList() {
        clientsPanel.removeAll();
        clientQueue.forEach(client -> clientsPanel.add(createClientPanel(client)));
        clientsPanel.revalidate();
        clientsPanel.repaint();
    }

    private JPanel createClientPanel(Client client) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JLabel nameLabel = new JLabel(client.getName());
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(nameLabel, BorderLayout.CENTER);

        JButton attendButton = new JButton("Atender");
        attendButton.setPreferredSize(new Dimension(100, 25));
        attendButton.setBackground(new Color(200, 200, 200));

        attendButton.addActionListener(e -> {
            clientQueue.forEach(Client::incrementScore);
            clientQueue.forEach(Client::incrementTime);
            clientQueue.remove(client);
            refreshClientList();
            JOptionPane.showMessageDialog(this,
                    client.getName() + " foi atendido",
                    "Atendimento concluído",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(attendButton);
        panel.add(buttonPanel, BorderLayout.EAST);

        return panel;
    }
}