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
public class TelaVizualizarBens extends JPanel {
	public TelaVizualizarBens(CardLayout cardLayout, JPanel cards) {
		setLayout(null);
		setBackground(new Color(200, 255, 200));

		Title title = new Title("Consultar Bens");

		String[] columnNames = { "ID", "Código Patrimonial", "Descrição", "Tipo", "Data de Aquisição", "Valor",
				"Estado", "Setor" };
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		JTable table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 200, 1100, 470);
		add(scrollPane);

		try {
			carregarDados(tableModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		BackButton backButton = new BackButton(cardLayout, cards, "TelaBens");
		add(backButton);
		add(title);
	}

	private void carregarDados(DefaultTableModel tableModel) throws SQLException {

		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
			    SELECT m.ID, m.CodigoPatrimonial, m.Descricao, t.Nome AS Tipo, m.DataAquisicao, m.Valor, m.Estado, s.Nome AS Setor
			    FROM Movel m
			    JOIN Tipo t ON m.IDTipo = t.ID
			    JOIN Setor s ON m.IDSetor = s.ID
			    ORDER BY m.ID ASC;
			""";


		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet result = stmt.executeQuery();

		while (result.next()) {
			Object[] row = { result.getInt("ID"), result.getInt("CodigoPatrimonial"), result.getString("Descricao"),
					result.getString("Tipo"), result.getDate("DataAquisicao"), result.getBigDecimal("Valor"),
					result.getString("Estado"), result.getString("Setor") };
			tableModel.addRow(row);
		}

	}
}
