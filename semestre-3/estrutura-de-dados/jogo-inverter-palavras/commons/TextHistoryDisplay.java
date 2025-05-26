package commons;

import app.entities.Phrase;
import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class TextHistoryDisplay extends JScrollPane {
    private JTextArea textArea;

    public TextHistoryDisplay(List<Phrase> originalPhrasesList) {
        this((Iterable<Phrase>) sortList(originalPhrasesList), true);
    }

    public TextHistoryDisplay(Deque<Phrase> invertedPhrasesStack) {
        this((Iterable<Phrase>) invertedPhrasesStack, false);
    }

    private TextHistoryDisplay(Iterable<Phrase> items, Boolean original) {
        textArea = new LinedTextArea();
        textArea.setFont(new Font("Arial", Font.BOLD, 20));
        textArea.setLineWrap(true);
        textArea.setEditable(false);

        if(original) {
            items.forEach(item -> textArea.append(item.getOriginalPhrase() + "\n"));
        } else {
            items.forEach(item -> textArea.append(item.getInvertedPhrase() + "\n"));
        }

        setViewportView(textArea);
        setBounds(100, 200, 1000, 400);
    }

    private static List sortList(List list) {
        Collections.sort(list);
        return list;
    }
}