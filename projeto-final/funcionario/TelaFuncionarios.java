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

		NavigationButton vizualizarFuncionarios = new NavigationButton("Vizualizar", 250, 400, 300, 200);
		NavigationButton novoFuncionario = new NavigationButton("Criar", 650, 400, 300, 200);
		
		
		novoFuncionario.addActionListener(e -> cardLayout.show(cards, "TelaCriarFuncionario"));
		vizualizarFuncionarios.addActionListener(e -> cardLayout.show(cards, "TelaVisualizarFuncionarios"));
		
		BackButton backButton = new BackButton(cardLayout, cards, "TelaPrincipal");

		add(title);
		add(vizualizarFuncionarios);
		add(novoFuncionario);
		add(backButton);
	}
}
