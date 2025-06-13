package views;

import buttons.ReturnButton;
import labels.Title;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ShoppingListScreen extends JPanel {
    private final List<String> shoppingList;
    private final List<String> acquiredList;
    private final JTextArea pendingArea = new JTextArea();
    private final JTextArea acquiredArea = new JTextArea();

    public ShoppingListScreen(CardLayout cardLayout, JPanel cards, List<String> shoppingList, List<String> acquiredList) {
        setLayout(null);
        setBackground(new Color(20, 20, 20));
        this.shoppingList = shoppingList;
        this.acquiredList = acquiredList;

        Title title = new Title("Lista de Compras", 320, 580);

        pendingArea.setBounds(100, 300, 400, 300);
        pendingArea.setEditable(false);
        pendingArea.setFont(new Font("Arial", Font.PLAIN, 20));

        acquiredArea.setBounds(600, 300, 400, 300);
        acquiredArea.setEditable(false);
        acquiredArea.setFont(new Font("Arial", Font.PLAIN, 20));

        JTextField newItemField = new JTextField();
        newItemField.setBounds(350, 250, 400, 40);
        newItemField.setFont(new Font("Arial", Font.PLAIN, 20));

        JButton addButton = new JButton("Adicionar Item");
        addButton.setBounds(350, 620, 180, 50);
        addButton.setFont(new Font("Arial", Font.BOLD, 18));
        addButton.setBackground(new Color(70, 70, 70));
        addButton.setForeground(Color.WHITE);

        JButton acquireButton = new JButton("Marcar como Adquirido");
        acquireButton.setBounds(570, 620, 250, 50);
        acquireButton.setFont(new Font("Arial", Font.BOLD, 18));
        acquireButton.setBackground(new Color(70, 70, 70));
        acquireButton.setForeground(Color.WHITE);

        addButton.addActionListener(e -> {
            shoppingList.add(newItemField.getText());
            newItemField.setText("");
            updateLists();
        });

        acquireButton.addActionListener(e -> {
            if (!shoppingList.isEmpty()) {
                acquiredList.add(shoppingList.remove(0));
                updateLists();
            }
        });

        ReturnButton returnButton = new ReturnButton(cardLayout, cards);
        add(title);
        add(returnButton);
        add(newItemField);
        add(addButton);
        add(acquireButton);
        add(pendingArea);
        add(acquiredArea);
        updateLists();
    }

    private void updateLists() {
        pendingArea.setText(String.join("\n", shoppingList));
        acquiredArea.setText(String.join("\n", acquiredList));
    }
}