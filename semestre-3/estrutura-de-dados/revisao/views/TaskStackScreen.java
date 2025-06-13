package views;

import buttons.ReturnButton;
import labels.Title;

import javax.swing.*;
import java.awt.*;
import java.util.Deque;

public class TaskStackScreen extends JPanel {
    private final Deque<String> tasksStack;
    private final JLabel taskLabel = new JLabel("Próxima tarefa: ");

    public TaskStackScreen(CardLayout cardLayout, JPanel cards, Deque<String> tasksStack) {
        setLayout(null);
        setBackground(new Color(20, 20, 20));

        Title title = new Title("Pilha de Tarefas ", 310, 580);

        this.tasksStack = tasksStack;

        taskLabel.setBounds(600, 500, 400, 100);
        taskLabel.setForeground(new Color(255, 255, 255));
        taskLabel.setFont(new Font("Arial", Font.BOLD, 30));


        JTextField taskField = new JTextField();
        taskField.setBounds(600, 300, 300, 150);

        JButton insertButton = new JButton("Inserir Tarefa");
        insertButton.setBackground(new Color(70, 70, 70));
        insertButton.setForeground(new Color(255, 255, 255));
        insertButton.setFont(new Font("Arial", Font.BOLD, 20));
        insertButton.setBounds(200, 300, 300, 150);
        insertButton.addActionListener(e -> {
            tasksStack.push(taskField.getText());
            taskField.setText("");
        });

        JButton getButton = new JButton("Obter Próxima Tarefa");
        getButton.setBackground(new Color(70, 70, 70));
        getButton.setForeground(new Color(255, 255, 255));
        getButton.setFont(new Font("Arial", Font.BOLD, 20));
        getButton.setBounds(200, 500, 300, 150);
        getButton.addActionListener(e -> {
            if (!tasksStack.isEmpty()) {
                taskLabel.setText("Próxima tarefa: " + tasksStack.pop());
            }
        });

        ReturnButton returnButton = new ReturnButton(cardLayout, cards);
        add(title);
        add(returnButton);
        add(taskField);
        add(insertButton);
        add(getButton);
        add(taskLabel);
        }
}
