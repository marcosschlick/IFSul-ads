package commons;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BackButton extends JButton {

	public BackButton(CardLayout cardLayout, JPanel cards, String screen) {
		setText("Voltar");
		setBounds(500, 700, 200, 50);
		setBackground(Color.DARK_GRAY);
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.BOLD, 25));
		addActionListener(e -> cardLayout.show(cards, screen));


	}

}
