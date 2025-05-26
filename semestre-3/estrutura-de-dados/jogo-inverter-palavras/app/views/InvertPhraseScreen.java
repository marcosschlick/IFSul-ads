package app.views;

import app.entities.Phrase;
import commons.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class InvertPhraseScreen extends JPanel {
    public InvertPhraseScreen(CardLayout cardLayout, JPanel cards, List<Phrase> originalPhrasesList, Deque<Phrase> invertedPhrasesStack) {
        setLayout(null);
        setBackground(new Color(120, 190, 255));

        Title mainTitle = new Title("Inverter Nova Frase", 250, 700);

        Subtitle subtitleInputPhrase = new Subtitle("DIGITE UMA FRASE", 240);

        InvertTextField txtInputField = new InvertTextField();

        Subtitle subtitleInvertedPhrase = new Subtitle("FRASE INVERTIDA", 415);

        InvertedTextLabel txtInvertedLabel = new InvertedTextLabel();

        InvertButton btnInvertPhrase = new InvertButton();
        btnInvertPhrase.addActionListener(e -> {
            Phrase phrase = new Phrase();
            try {
                phrase.setOriginalPhrase(txtInputField.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<String> words = new ArrayList<>(Arrays.asList(phrase.getOriginalPhrase().split(" ")));
            Collections.reverse(words);

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
        add(subtitleInputPhrase);
        add(txtInputField);
        add(subtitleInvertedPhrase);
        add(txtInvertedLabel);
        add(btnInvertPhrase);
        add(btnReturn);
    }
}
