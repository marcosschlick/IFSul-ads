package views;

import buttons.ReturnButton;
import labels.Title;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class QueueProcessingScreen extends JPanel {
    private final Queue<String> queueQ;
    private final Queue<String> queueA;
    private final Queue<String> queueB;
    private final JTextArea queueAArea = new JTextArea();
    private final JTextArea queueBArea = new JTextArea();
    private final JTextArea queueQArea = new JTextArea();

    public QueueProcessingScreen(CardLayout cardLayout, JPanel cards, Queue<String> queueQ, Queue<String> queueA, Queue<String> queueB) {
        setLayout(null);
        setBackground(new Color(20, 20, 20));
        this.queueQ = queueQ;
        this.queueA = queueA;
        this.queueB = queueB;

        Title title = new Title("Processar Fila", 320, 580);

        JLabel qLabel = new JLabel("Fila Q:");
        qLabel.setBounds(450, 100, 300, 30);
        qLabel.setForeground(Color.WHITE);
        qLabel.setFont(new Font("Arial", Font.BOLD, 20));

        queueQArea.setBounds(300, 130, 600, 100);
        queueQArea.setEditable(false);
        queueQArea.setFont(new Font("Arial", Font.PLAIN, 18));
        queueQArea.setText(String.join("\n", queueQ));

        JLabel aLabel = new JLabel("Fila A:");
        aLabel.setBounds(300, 250, 300, 30);
        aLabel.setForeground(Color.WHITE);
        aLabel.setFont(new Font("Arial", Font.BOLD, 20));

        queueAArea.setBounds(300, 280, 250, 200);
        queueAArea.setEditable(false);
        queueAArea.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel bLabel = new JLabel("Fila B:");
        bLabel.setBounds(650, 250, 300, 30);
        bLabel.setForeground(Color.WHITE);
        bLabel.setFont(new Font("Arial", Font.BOLD, 20));

        queueBArea.setBounds(650, 280, 250, 200);
        queueBArea.setEditable(false);
        queueBArea.setFont(new Font("Arial", Font.PLAIN, 18));

        JButton processButton = new JButton("Processar Fila");
        processButton.setBounds(450, 520, 300, 50);
        processButton.setFont(new Font("Arial", Font.BOLD, 20));
        processButton.setBackground(new Color(70, 70, 70));
        processButton.setForeground(Color.WHITE);
        processButton.addActionListener(e -> processQueue());

        add(qLabel);
        add(queueQArea);
        add(aLabel);
        add(bLabel);
        add(processButton);
        add(queueAArea);
        add(queueBArea);

        ReturnButton returnButton = new ReturnButton(cardLayout, cards);
        add(title);
        add(returnButton);
    }

    private void processQueue() {
        queueA.clear();
        queueB.clear();

        Queue<String> tempQ = new LinkedList<>(queueQ);

        while (!tempQ.isEmpty()) {
            String name = tempQ.poll();
            if (tempQ.isEmpty()) break;

            String operation = tempQ.poll();

            switch (operation) {
                case "A":
                    queueA.add(name);
                    break;
                case "B":
                    queueB.add(name);
                    break;
                case "X":
                    if (queueA.size() < queueB.size()) {
                        queueA.add(name);
                    } else if (queueB.size() < queueA.size()) {
                        queueB.add(name);
                    }
                    break;
            }
        }

        queueAArea.setText(String.join("\n", queueA));
        queueBArea.setText(String.join("\n", queueB));
    }
}