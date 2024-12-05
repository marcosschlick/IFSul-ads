package bens;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import commons.BackButton;
import commons.NavigationButton;
import commons.Title;

@SuppressWarnings("serial")
public class TelaProcurarBem extends JPanel {
	public TelaProcurarBem(CardLayout cardLayout, JPanel cards) {
		setLayout(null);

		setBackground(new Color(200, 255, 200));

		Title title = new Title("Procurar um bem");

		JLabel pesquisaLegenda = new JLabel("Digite o código do bem:");
		pesquisaLegenda.setBounds(350, 250, 500, 50);
		pesquisaLegenda.setFont(new Font("Arial", Font.BOLD, 30));
		pesquisaLegenda.setHorizontalAlignment(0);

		JTextField pesquisaCaixa = new JTextField();
		pesquisaCaixa.setBounds(350, 300, 500, 70);
		pesquisaCaixa.setFont(new Font("Arial", Font.BOLD, 20));

		NavigationButton vizualizarMovimentacoes = new NavigationButton("Ver histórico", 100, 400, 300, 200);
		NavigationButton moverBem = new NavigationButton("Mover bem", 450, 400, 300, 200);
		NavigationButton baixarBem = new NavigationButton("Baixar bem", 800, 400, 300, 200);

		vizualizarMovimentacoes.addActionListener(e -> {
			int codigoMovel = Integer.parseInt(pesquisaCaixa.getText().trim());
			TelaMovimentacoesEBaixas telaMovimentacoes = new TelaMovimentacoesEBaixas(cardLayout, cards, codigoMovel);
			cards.add(telaMovimentacoes, "TelaMovimentacoesEBaixas");
			cardLayout.show(cards, "TelaMovimentacoesEBaixas");
		});

		baixarBem.addActionListener(e -> {
			int codigoMovel = Integer.parseInt(pesquisaCaixa.getText().trim());
			TelaBaixa telaBaixa = new TelaBaixa(cardLayout, cards, codigoMovel);
			cards.add(telaBaixa, "TelaBaixa");
			cardLayout.show(cards, "TelaBaixa");
		});

		moverBem.addActionListener(e -> {
			int codigoMovel = Integer.parseInt(pesquisaCaixa.getText().trim());
			TelaMovimentacao telaMovimentacao = new TelaMovimentacao(cardLayout, cards, codigoMovel);
			cards.add(telaMovimentacao, "TelaMovimentacao");
			cardLayout.show(cards, "TelaMovimentacao");
		});

		BackButton backButton = new BackButton(cardLayout, cards, "TelaBens");

		add(title);
		add(pesquisaLegenda);
		add(pesquisaCaixa);
		add(vizualizarMovimentacoes);
		add(moverBem);
		add(baixarBem);
		add(backButton);

	}
}
