package bens;

import java.awt.CardLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import commons.BackButton;
import commons.ConnectionMySQL;
import commons.Title;

@SuppressWarnings("serial")
public class TelaMovimentacoesEBaixas extends JPanel {
	public TelaMovimentacoesEBaixas(CardLayout cardLayout, JPanel cards, int codigoMovel) {
		setLayout(null);
		setBackground(new Color(200, 255, 200));

		Title title = new Title("Histórico de movimentações");

		String[] columnsMovimentacao = { "Data", "Setor Origem", "Setor Destino", "Responsável" };
		DefaultTableModel tableModelMovimentacao = new DefaultTableModel(columnsMovimentacao, 0);
		JTable tableMovimentacao = new JTable(tableModelMovimentacao);
		JScrollPane scrollPaneMovimentacao = new JScrollPane(tableMovimentacao);
		scrollPaneMovimentacao.setBounds(50, 150, 1100, 200);
		add(scrollPaneMovimentacao);

		String[] columnsBaixa = { "Data Baixa", "Motivo" };
		DefaultTableModel tableModelBaixa = new DefaultTableModel(columnsBaixa, 0);
		JTable tableBaixa = new JTable(tableModelBaixa);
		JScrollPane scrollPaneBaixa = new JScrollPane(tableBaixa);
		scrollPaneBaixa.setBounds(50, 400, 1100, 150);
		add(scrollPaneBaixa);

		try {
			carregarMovimentacoes(tableModelMovimentacao, codigoMovel);
			carregarBaixas(tableModelBaixa, codigoMovel);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		BackButton backButton = new BackButton(cardLayout, cards, "TelaProcurarBem");
		add(backButton);
		add(title);
	}

	private void carregarMovimentacoes(DefaultTableModel tableModel, int codigoMovel) throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				    SELECT
				    m.DataMovimentacao,
				    sOrigem.Nome AS SetorOrigem,
				    sDestino.Nome AS SetorDestino,
				    f.Nome AS Responsavel
				    FROM Movimentacao m
				    JOIN Setor sOrigem ON m.IDSetorOrigem = sOrigem.ID
				    JOIN Setor sDestino ON m.IDSetorDestino = sDestino.ID
				    JOIN Funcionario f ON m.IDResponsavel = f.ID
				    WHERE m.CodigoMovel = ?
				    ORDER BY m.DataMovimentacao ASC;
				""";

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, codigoMovel);
		ResultSet result = stmt.executeQuery();

		while (result.next()) {
			Object[] row = { result.getDate("DataMovimentacao"), result.getString("SetorOrigem"),
					result.getString("SetorDestino"), result.getString("Responsavel") };
			tableModel.addRow(row);
		}
	}

	private void carregarBaixas(DefaultTableModel tableModel, int codigoMovel) throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				SELECT
				b.DataBaixa,
				b.Motivo
				FROM Baixa b
				WHERE b.CodigoMovel = ?
				ORDER BY b.DataBaixa ASC;
				""";

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, codigoMovel);
		ResultSet result = stmt.executeQuery();

		while (result.next()) {
			Object[] row = { result.getDate("DataBaixa"), result.getString("Motivo") };
			tableModel.addRow(row);
		}
	}
}
