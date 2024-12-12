package setor;

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
public class TelaVisualizarSetores extends JPanel {
    public TelaVisualizarSetores(CardLayout cardLayout, JPanel cards) {
        setLayout(null);
        setBackground(new Color(200, 255, 200));

        Title title = new Title("Consultar Setores");

        String[] columnNames = { "ID", "Código Setor", "Nome", "Responsável" };
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

        BackButton backButton = new BackButton(cardLayout, cards, "TelaSetores");
        add(backButton);
        add(title);
    }

    private void carregarDados(DefaultTableModel tableModel) throws SQLException {

        Connection connection = ConnectionMySQL.getConnection();
        String sql = """
                SELECT s.ID, s.CodigoSetor, s.Nome, f.Nome AS Responsavel
                FROM Setor s
                LEFT JOIN Funcionario f ON s.Responsavel = f.ID
                ORDER BY s.ID ASC;
            """;

        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            Object[] row = { result.getInt("ID"), result.getInt("CodigoSetor"), result.getString("Nome"),
                    result.getString("Responsavel") };
            tableModel.addRow(row);
        }
    }
}
