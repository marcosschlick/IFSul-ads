package commons;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class InvertTextField extends JTextArea {
    private static final int MAX_CHARS = 198;

    public InvertTextField() {
        setFont(new Font("Arial", Font.BOLD, 25));
        setBounds(100, 275, 1000, 100);
        setLineWrap(true);
        setDocument(new LimitDocument(MAX_CHARS));
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
