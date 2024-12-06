package bens;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import commons.BackButton;
import commons.ConnectionMySQL;
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

		NavigationButton vizualizarMovimentacoes = new NavigationButton("Ver", 50, 400, 200, 180);
		NavigationButton moverBem = new NavigationButton("Mover", 275, 400, 200, 180);
		NavigationButton baixarBem = new NavigationButton("Baixar", 500, 400, 200, 180);
		NavigationButton editarBem = new NavigationButton("Editar", 725, 400, 200, 180);
		NavigationButton deletarBem = new NavigationButton("Deletar", 950, 400, 200, 180);

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

		editarBem.addActionListener(e -> {
			int codigoMovel = Integer.parseInt(pesquisaCaixa.getText().trim());
			TelaEditarBem telaEditarBem = new TelaEditarBem(cardLayout, cards, codigoMovel);
			cards.add(telaEditarBem, "TelaEditarBem");
			cardLayout.show(cards, "TelaEditarBem");
		});

		deletarBem.addActionListener(e -> {
			int codigoMovel = Integer.parseInt(pesquisaCaixa.getText().trim());
			try {
				deletarBem(codigoMovel);
				JOptionPane.showMessageDialog(null, "Móvel deletado com sucesso");
			} catch (SQLException d) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + d.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		BackButton backButton = new BackButton(cardLayout, cards, "TelaBens");

		add(editarBem);
		add(deletarBem);
		add(title);
		add(pesquisaLegenda);
		add(pesquisaCaixa);
		add(vizualizarMovimentacoes);
		add(moverBem);
		add(baixarBem);
		add(backButton);

	}

	private void deletarBem(int codigoMovel) throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				DELETE FROM Movel
				WHERE CodigoPatrimonial = ?;
				""";

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, codigoMovel);
		stmt.executeUpdate();
		stmt.close();
		connection.close();
	}
}
