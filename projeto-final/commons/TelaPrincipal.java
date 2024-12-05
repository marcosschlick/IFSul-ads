package commons;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TelaPrincipal extends JPanel {
	public TelaPrincipal(CardLayout cardLayout, JPanel cards) {
		setLayout(null);
		setBackground(new Color(200, 255, 200));

		Title title = new Title("Tela principal");

		NavigationButton bensButton = new NavigationButton("Bens", 100, 400, 300, 200);
		NavigationButton funcionariosButton = new NavigationButton("Funcionários", 450, 400, 300, 200);
		NavigationButton setoresButton = new NavigationButton("Setores", 800, 400, 300, 200);

		bensButton.addActionListener(e -> cardLayout.show(cards, "TelaBens"));
		funcionariosButton.addActionListener(e -> cardLayout.show(cards, "TelaFuncionarios"));
		setoresButton.addActionListener(e -> cardLayout.show(cards, "TelaSetores"));

		add(title);
		add(bensButton);
		add(funcionariosButton);
		add(setoresButton);
	}
}
