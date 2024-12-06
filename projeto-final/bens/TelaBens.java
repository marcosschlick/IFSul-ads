package bens;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import commons.BackButton;
import commons.NavigationButton;
import commons.Title;

@SuppressWarnings("serial")
public class TelaBens extends JPanel {
	public TelaBens(CardLayout cardLayout, JPanel cards) {
		setLayout(null);
		setBackground(new Color(200, 255, 200));

		Title title = new Title("Bens");

		NavigationButton visualizarBens = new NavigationButton("Visualizar", 100, 400, 300, 200);
		NavigationButton procurarBem = new NavigationButton("Procurar", 450, 400, 300, 200);
		NavigationButton novoBem = new NavigationButton("Criar", 800, 400, 300, 200);

		procurarBem.addActionListener(e -> cardLayout.show(cards, "TelaProcurarBem"));
		novoBem.addActionListener(e -> cardLayout.show(cards, "TelaCriarBem"));

		visualizarBens.addActionListener(e -> {
			TelaVisualizarBens telaVisualizarBens = new TelaVisualizarBens(cardLayout, cards);
			cards.add(telaVisualizarBens, "TelaVisualizarBens");
			cardLayout.show(cards, "TelaVisualizarBens");
		});

		BackButton backButton = new BackButton(cardLayout, cards, "TelaPrincipal");

		add(title);
		add(visualizarBens);
		add(procurarBem);
		add(novoBem);
		add(backButton);
	}
}
