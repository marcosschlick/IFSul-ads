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

		NavigationButton vizualizarSetores = new NavigationButton("Visualizar", 95, 400, 230, 180);
		NavigationButton novoSetor = new NavigationButton("Criar", 355, 400, 230, 180);
		NavigationButton deletarSetor = new NavigationButton("Deletar", 615, 400, 230, 180);
		NavigationButton editarSetor = new NavigationButton("Editar", 875, 400, 230, 180);

		novoSetor.addActionListener(e -> cardLayout.show(cards, "TelaCriarSetor"));
		deletarSetor.addActionListener(e -> cardLayout.show(cards, "TelaDeletarSetor"));
		editarSetor.addActionListener(e -> cardLayout.show(cards, "TelaEditarSetor"));

		vizualizarSetores.addActionListener(e -> {
			TelaVisualizarSetores tlaVisualizarSetores = new TelaVisualizarSetores(cardLayout, cards);
			cards.add(tlaVisualizarSetores, "TelaVisualizarSetores");
			cardLayout.show(cards, "TelaVisualizarSetores");
		});

		BackButton backButton = new BackButton(cardLayout, cards, "TelaPrincipal");

		add(editarSetor);
		add(deletarSetor);
		add(title);
		add(vizualizarSetores);
		add(novoSetor);
		add(backButton);
	}
}
