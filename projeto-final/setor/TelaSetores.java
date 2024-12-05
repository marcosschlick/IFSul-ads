package setor;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import commons.BackButton;
import commons.NavigationButton;
import commons.Title;

@SuppressWarnings("serial")
public class TelaSetores extends JPanel {
	public TelaSetores(CardLayout cardLayout, JPanel cards) {
		setLayout(null);
		setBackground(new Color(200, 255, 200));

		Title title = new Title("Setores");

		NavigationButton vizualizarSetores = new NavigationButton("Vizualizar", 250, 400, 300, 200);
		NavigationButton novoSetor = new NavigationButton("Criar", 650, 400, 300, 200);

		novoSetor.addActionListener(e -> cardLayout.show(cards, "TelaCriarSetor"));
		vizualizarSetores.addActionListener(e -> cardLayout.show(cards, "TelaVisualizarSetores"));
		
		BackButton backButton = new BackButton(cardLayout, cards, "TelaPrincipal");

		add(title);
		add(vizualizarSetores);
		add(novoSetor);
		add(backButton);
	}
}
