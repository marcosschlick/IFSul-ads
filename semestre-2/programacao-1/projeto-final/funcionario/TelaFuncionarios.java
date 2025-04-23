package funcionario;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import commons.BackButton;
import commons.NavigationButton;
import commons.Title;

@SuppressWarnings("serial")
public class TelaFuncionarios extends JPanel {
	public TelaFuncionarios(CardLayout cardLayout, JPanel cards) {
		setLayout(null);
		setBackground(new Color(200, 255, 200));

		Title title = new Title("Funcionários");

		NavigationButton vizualizarFuncionarios = new NavigationButton("Visualizar", 95, 400, 230, 180);
		NavigationButton novoFuncionario = new NavigationButton("Criar", 355, 400, 230, 180);
		NavigationButton deletarFuncionario = new NavigationButton("Deletar", 615, 400, 230, 180);
		NavigationButton editarFuncionario = new NavigationButton("Editar", 875, 400, 230, 180);

		novoFuncionario.addActionListener(e -> cardLayout.show(cards, "TelaCriarFuncionario"));
		deletarFuncionario.addActionListener(e -> cardLayout.show(cards, "TelaDeletarFuncionario"));
		editarFuncionario.addActionListener(e -> cardLayout.show(cards, "TelaEditarFuncionario"));

		vizualizarFuncionarios.addActionListener(e -> {
			TelaVisualizarFuncionarios telaVisualizarFuncionarios = new TelaVisualizarFuncionarios(cardLayout, cards);
			cards.add(telaVisualizarFuncionarios, "TelaVisualizarFuncionarios");
			cardLayout.show(cards, "TelaVisualizarFuncionarios");
		});

		BackButton backButton = new BackButton(cardLayout, cards, "TelaPrincipal");

		add(editarFuncionario);
		add(deletarFuncionario);
		add(title);
		add(vizualizarFuncionarios);
		add(novoFuncionario);
		add(backButton);
	}
}
