package app.views;

import app.entities.Phrase;
import commons.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class InvertWordsScreen extends JPanel {
    public InvertWordsScreen(CardLayout cardLayout, JPanel cards, List<Phrase> originalPhrasesList, Deque<Phrase> invertedPhrasesStack) {
        setLayout(null);
        setBackground(new Color(120, 190, 255));

        Title mainTitle = new Title("Inverter Novas Palavras", 180, 840);

        Subtitle subtitleInputWords = new Subtitle("DIGITE AS PALAVRAS", 240);

        InvertTextField txtInputField = new InvertTextField();

        Subtitle subtitleInvertedWords = new Subtitle("PALAVRAS INVERTIDAS", 415);

        InvertedTextLabel txtInvertedLabel = new InvertedTextLabel();

        InvertButton btnInvertWords = new InvertButton();
        btnInvertWords.addActionListener(e -> {
            Phrase phrase = new Phrase();
            try {
                phrase.setOriginalPhrase(txtInputField.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] words = phrase.getOriginalPhrase().split(" ");

            for(int i = 0; i < words.length; i++) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }

            phrase.setInvertedPhrase(String.join(" ", words));

            originalPhrasesList.add(phrase);
            invertedPhrasesStack.push(phrase);
            txtInvertedLabel.setText(phrase.getInvertedPhrase());
        });

        ReturnButton btnReturn = new ReturnButton();
        btnReturn.addActionListener(e -> {
            txtInputField.setText("");
            txtInvertedLabel.setText("");
            cardLayout.show(cards, "HomeMenuScreen");
        });

        add(mainTitle);
        add(subtitleInputWords);
        add(txtInputField);
        add(subtitleInvertedWords);
        add(txtInvertedLabel);
        add(btnInvertWords);
        add(btnReturn);
    }
}
