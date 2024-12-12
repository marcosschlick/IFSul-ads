package sistema_gerenciador_de_bens;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import bens.TelaBens;
import bens.TelaCriarBem;
import bens.TelaProcurarBem;
import commons.TelaPrincipal;
import funcionario.TelaCriarFuncionario;
import funcionario.TelaDeletarFuncionario;
import funcionario.TelaEditarFuncionario;
import funcionario.TelaFuncionarios;
import setor.TelaCriarSetor;
import setor.TelaDeletarSetor;
import setor.TelaEditarSetor;
import setor.TelaSetores;

public class Application {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Sistema de Gestão de Bens");
		frame.setSize(1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		
		
		CardLayout cardLayout = new CardLayout();
		JPanel cards = new JPanel(cardLayout);

		cards.add(new TelaPrincipal(cardLayout, cards), "TelaPrincipal");
		cards.add(new TelaBens(cardLayout, cards), "TelaBens");
		cards.add(new TelaFuncionarios(cardLayout, cards), "TelaFuncionarios");
		cards.add(new TelaSetores(cardLayout, cards), "TelaSetores");
		cards.add(new TelaProcurarBem(cardLayout, cards), "TelaProcurarBem");
		cards.add(new TelaCriarFuncionario(cardLayout, cards), "TelaCriarFuncionario");
		cards.add(new TelaCriarSetor(cardLayout, cards), "TelaCriarSetor");
		cards.add(new TelaCriarBem(cardLayout, cards), "TelaCriarBem");
		cards.add(new TelaDeletarSetor(cardLayout, cards), "TelaDeletarSetor");
		cards.add(new TelaEditarSetor(cardLayout, cards), "TelaEditarSetor");
		cards.add(new TelaDeletarFuncionario(cardLayout, cards), "TelaDeletarFuncionario");
		cards.add(new TelaEditarFuncionario(cardLayout, cards), "TelaEditarFuncionario");
		

		frame.add(cards);
		frame.setVisible(true);
	}
}
