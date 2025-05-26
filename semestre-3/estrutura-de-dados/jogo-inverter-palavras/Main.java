import app.entities.Phrase;
import app.views.HomeMenuScreen;
import app.views.InvertPhraseScreen;
import app.views.InvertWordsScreen;
import app.views.OriginalPhrasesScreen;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Jogo de inverter palavras");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        CardLayout cardLayout = new CardLayout();
        JPanel cards = new JPanel(cardLayout);

        List<Phrase> originalPhrasesList = new ArrayList<>();
        Deque<Phrase> invertedPhrasesStack = new LinkedList<>();

        cards.add(new HomeMenuScreen(cardLayout, cards, originalPhrasesList, invertedPhrasesStack), "HomeMenuScreen");
        cards.add(new InvertPhraseScreen(cardLayout, cards, originalPhrasesList, invertedPhrasesStack), "InvertPhraseScreen");
        cards.add(new InvertWordsScreen(cardLayout, cards, originalPhrasesList, invertedPhrasesStack), "InvertWordsScreen");

        cards.add(new OriginalPhrasesScreen(cardLayout, cards, originalPhrasesList), "OriginalPhrasesScreen");
        frame.add(cards);

        frame.setVisible(true);
    }
}
