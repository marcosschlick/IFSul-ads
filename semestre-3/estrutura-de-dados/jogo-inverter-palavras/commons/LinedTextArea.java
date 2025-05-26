package commons;

import javax.swing.*;
import java.awt.*;

public class LinedTextArea extends JTextArea {
    public LinedTextArea() {
        super();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(0, 0, 0));

        FontMetrics fm = getFontMetrics(getFont());
        int lineHeight = fm.getHeight();
        int y = lineHeight;

        while (y < getHeight()) {
            g2.drawLine(0, y, getWidth(), y);
            y += lineHeight;
        }
    }
}
