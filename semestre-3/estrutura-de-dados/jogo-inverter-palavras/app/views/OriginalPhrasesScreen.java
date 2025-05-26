package app.views;

import app.entities.Phrase;
import commons.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class OriginalPhrasesScreen extends JPanel {
    public OriginalPhrasesScreen(CardLayout cardLayout, JPanel cards, List<Phrase> originalPhrasesList) {
        setLayout(null);
        setBackground(new Color(120, 190, 255));

        Title title = new Title("Frases Originais", 320, 560);

        TextHistoryDisplay textHistoryDisplay = new TextHistoryDisplay(originalPhrasesList);

        ReturnButton btnReturn = new ReturnButton();
        btnReturn.addActionListener(e -> {
            cardLayout.show(cards, "HomeMenuScreen");
        });

        add(title);
        add(textHistoryDisplay);
        add(btnReturn);
    }
}
