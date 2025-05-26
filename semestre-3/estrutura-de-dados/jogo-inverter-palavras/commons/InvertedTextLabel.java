package commons;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class InvertedTextLabel extends JTextArea {
    private static final int MAX_CHARS = 198;

    public InvertedTextLabel() {
        setFont(new Font("Arial", Font.BOLD, 25));
        setBounds(100, 450, 1000, 100);
        setLineWrap(true);
        setDocument(new InvertedTextLabel.LimitDocument(MAX_CHARS));
        setEditable(false);
    }

    private static class LimitDocument extends PlainDocument {
        private final int max;

        public LimitDocument(int max) {
            this.max = max;
        }

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str == null) return;
            if (getLength() + str.length() <= max) {
                super.insertString(offs, str, a);
            }
        }
    }
}
