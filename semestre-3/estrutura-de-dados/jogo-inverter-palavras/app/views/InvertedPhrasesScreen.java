package app.views;

import app.entities.Phrase;
import commons.*;
import javax.swing.*;
import java.awt.*;
import java.util.Deque;

public class InvertedPhrasesScreen extends JPanel {
    public InvertedPhrasesScreen(CardLayout cardLayout, JPanel cards, Deque<Phrase> invertedPhrasesList) {
        setLayout(null);
        setBackground(new Color(120, 190, 255));

        Title title = new Title("Frases Invertidas", 300, 600);

        TextHistoryDisplay textHistoryDisplay = new TextHistoryDisplay(invertedPhrasesList);

        ReturnButton btnReturn = new ReturnButton();
        btnReturn.addActionListener(e -> {
            cardLayout.show(cards, "HomeMenuScreen");
        });

        add(title);
        add(textHistoryDisplay);
        add(btnReturn);
    }
}
