package app.views;

import app.entities.Phrase;
import commons.NavigationButton;
import commons.Title;

import javax.swing.*;
import java.awt.*;
import java.util.Deque;
import java.util.List;

public class HomeMenuScreen extends JPanel {
    public HomeMenuScreen(CardLayout cardLayout, JPanel cards, List<Phrase> originalPhrasesList, Deque<Phrase> invertedPhrasesStack) {
        setLayout(null);
        setBackground(new Color(120, 190, 255));

        Title title = new Title("Jogo de Inverter Palavras", 160, 880);

        NavigationButton btnInvertNewPhrase = new NavigationButton("INVERTER NOVA FRASE", 80, 370, 260, 140);
        btnInvertNewPhrase.addActionListener(e -> cardLayout.show(cards, "InvertPhraseScreen"));

        NavigationButton btnInvertLettersPerWord = new NavigationButton("INVERTER LETRAS POR PALAVRAS", 370, 370, 380, 140);
        btnInvertLettersPerWord.addActionListener(e -> cardLayout.show(cards, "InvertWordsScreen"));

        NavigationButton btnUndoLastInvert = new NavigationButton("DESFAZER ÚLTIMA INVERSÃO", 780, 370, 340, 140);
        btnUndoLastInvert.addActionListener(e -> {
            if(!invertedPhrasesStack.isEmpty()) {
                invertedPhrasesStack.pop();
            } else {
                JOptionPane.showMessageDialog(null, "COMO VAI REMOVER ALGO QUE NÃO EXISTE SEU CORNO","Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        NavigationButton btnViewOriginalPhrases = new NavigationButton("VER FRASES ORIGINAIS", 170, 540, 260, 140);
        btnViewOriginalPhrases.addActionListener(e -> {
            OriginalPhrasesScreen originalPhrasesScreen = new OriginalPhrasesScreen(cardLayout, cards, originalPhrasesList);
            cards.add(originalPhrasesScreen, "OriginalPhrasesScreen");
            cardLayout.show(cards, "OriginalPhrasesScreen");
        });

        NavigationButton btnViewInvertedPhrases = new NavigationButton("VER FRASES INVERTIDAS", 460, 540, 280, 140);
        btnViewInvertedPhrases.addActionListener(e -> {
            InvertedPhrasesScreen invertedPhrasesScreen = new InvertedPhrasesScreen(cardLayout, cards, invertedPhrasesStack);
            cards.add(invertedPhrasesScreen, "InvertedPhrasesScreen");
            cardLayout.show(cards, "InvertedPhrasesScreen");
        });

        NavigationButton btnExit = new NavigationButton("SAIR DO JOGO", 770, 540, 260, 140);
        btnExit.addActionListener(e -> System.exit(0));


        add(title);
        add(btnInvertNewPhrase);
        add(btnUndoLastInvert);
        add(btnViewOriginalPhrases);
        add(btnViewInvertedPhrases);
        add(btnInvertLettersPerWord);
        add(btnExit);
    }
}
