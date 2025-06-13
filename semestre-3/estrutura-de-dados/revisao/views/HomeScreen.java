package views;

import buttons.MenuButton;
import labels.Title;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class HomeScreen extends JPanel {
    public HomeScreen(CardLayout cardLayout, JPanel cards) {
        setLayout(null);
        setBackground(new Color(20, 20, 20));
        Deque<String> tasksStack = new ArrayDeque<>(); // pilha de tarefas
        List<String> shoppingList = new ArrayList<>(); // lista de compras
        List<String> acquiredList = new ArrayList<>(); // lista de compras já feitas
        Queue<String> queueQ = new LinkedList<>(); // fila para processar Q
        Queue<String> queueA = new LinkedList<>(); // fila para processar A
        Queue<String> queueB = new LinkedList<>(); // fila para processar B

        queueQ.add("Luis");
        queueQ.add("B");
        queueQ.add("Pedro");
        queueQ.add("A");
        queueQ.add("Luísa");
        queueQ.add("A");
        queueQ.add("Joao");
        queueQ.add("X");
        queueQ.add("Jose");
        queueQ.add("X");
        queueQ.add("Miguel");
        queueQ.add("B");

        Title title = new Title("Menu Principal ", 320, 560);

        MenuButton taskStackButton = new MenuButton("Pilha de Tarefas", 100, 300);
        taskStackButton.addActionListener(e -> {
            TaskStackScreen taskStackScreen = new TaskStackScreen(cardLayout, cards, tasksStack);
            cards.add(taskStackScreen, "TaskStackScreen");
            cardLayout.show(cards, "TaskStackScreen");
        });
        MenuButton shoppingListButton = new MenuButton("Lista de Compras", 450, 300);
        shoppingListButton.addActionListener(e -> {
            ShoppingListScreen shoppingListScreen = new ShoppingListScreen(cardLayout, cards, shoppingList, acquiredList);
            cards.add(shoppingListScreen, "ShoppingListScreen");
            cardLayout.show(cards, "ShoppingListScreen");
        });
        MenuButton queueProcessingButton = new MenuButton("Processar Fila", 800, 300);
        queueProcessingButton.addActionListener(e -> {
            QueueProcessingScreen queueProcessingScreen = new QueueProcessingScreen(cardLayout, cards, queueQ, queueA, queueB);
            cards.add(queueProcessingScreen, "QueueProcessingScreen");
            cardLayout.show(cards, "QueueProcessingScreen");
        });

        add(title);
        add(taskStackButton);
        add(shoppingListButton);
        add(queueProcessingButton);
    }
}