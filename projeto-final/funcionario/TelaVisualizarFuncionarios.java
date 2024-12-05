package funcionario;

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
public class TelaVisualizarFuncionarios extends JPanel {
    public TelaVisualizarFuncionarios(CardLayout cardLayout, JPanel cards) {
        setLayout(null);
        setBackground(new Color(200, 255, 200));

        Title title = new Title("Consultar Funcionários");

        String[] columnNames = { "ID", "Matrícula", "Nome", "Email", "Telefone", "Setor Que Pertence" };
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

        BackButton backButton = new BackButton(cardLayout, cards, "TelaFuncionarios");
        add(backButton);
        add(title);
    }

    private void carregarDados(DefaultTableModel tableModel) throws SQLException {

        Connection connection = ConnectionMySQL.getConnection();
        String sql = """
                SELECT f.ID, f.Matricula, f.Nome, f.Email, f.Telefone, s.Nome AS SetorQuePertence
                FROM Funcionario f
                LEFT JOIN Setor s ON f.SetorQuePertence = s.CodigoSetor
                ORDER BY f.ID ASC;
            """;

        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            Object[] row = { result.getInt("ID"), result.getInt("Matricula"), result.getString("Nome"),
                    result.getString("Email"), result.getString("Telefone"), result.getString("SetorQuePertence") };
            tableModel.addRow(row);
        }
    }
}
