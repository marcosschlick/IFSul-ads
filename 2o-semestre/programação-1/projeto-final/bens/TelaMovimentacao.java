package bens;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import commons.BackButton;
import commons.ConnectionMySQL;
import commons.NavigationButton;
import commons.Title;

@SuppressWarnings("serial")
public class TelaMovimentacao extends JPanel {
	public TelaMovimentacao(CardLayout cardLayout, JPanel cards, int codigoMovel) {
		setLayout(null);
		setBackground(new Color(200, 255, 200));

		Title title = new Title("Criar funcionário");

		JLabel dataLabel = new JLabel("Data:");
		dataLabel.setBounds(250, 220, 250, 30);
		dataLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(dataLabel);

		JLabel origemLabel = new JLabel("Setor de origem:");
		origemLabel.setBounds(250, 290, 250, 30);
		origemLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(origemLabel);

		JLabel destinoLabel = new JLabel("Setor de destino:");
		destinoLabel.setBounds(250, 360, 250, 30);
		destinoLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(destinoLabel);

		JLabel responsavelLabel = new JLabel("Func. Responsável:");
		responsavelLabel.setBounds(250, 430, 250, 30);
		responsavelLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(responsavelLabel);

		JTextField dataField = new JTextField();
		dataField.setBounds(550, 220, 400, 40);
		dataField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(dataField);

		JComboBox<String> origemComboBox = new JComboBox<>();
		origemComboBox.setBounds(550, 290, 400, 40);
		origemComboBox.setFont(new Font("Arial", Font.PLAIN, 25));
		try {
			preencherSetor(origemComboBox);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		add(origemComboBox);

		JComboBox<String> destinoComboBox = new JComboBox<>();
		destinoComboBox.setBounds(550, 360, 400, 40);
		destinoComboBox.setFont(new Font("Arial", Font.PLAIN, 25));
		try {
			preencherSetor(destinoComboBox);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		add(destinoComboBox);

		JComboBox<String> responsavelComboBox = new JComboBox<>();
		responsavelComboBox.setBounds(550, 430, 400, 40);
		responsavelComboBox.setFont(new Font("Arial", Font.PLAIN, 25));
		try {
			preencherResponsavel(responsavelComboBox);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		add(responsavelComboBox);

		NavigationButton confirmar = new NavigationButton("Confirmar", 800, 550, 300, 100);
		confirmar.addActionListener(e -> {
			try {
				String data = dataField.getText();
				String origem = (String) origemComboBox.getSelectedItem();
				String destino = (String) destinoComboBox.getSelectedItem();
				String responsavel = (String) responsavelComboBox.getSelectedItem();
				int origemID = obterSetorId(origem);
				int destinoID = obterSetorId(destino);
				int responsavelID = obterResponsavelId(responsavel);

				movimentar(data, codigoMovel, origemID, destinoID, responsavelID);
				JOptionPane.showMessageDialog(null, "Movimentação realizada com sucesso");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + ex.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		BackButton backButton = new BackButton(cardLayout, cards, "TelaProcurarBem");

		add(title);
		add(confirmar);
		add(backButton);
	}

	private void movimentar(String data, int codigoMovel, int setorOrigem, int setorDestino, int responsavel)
			throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				   	INSERT INTO Movimentacao (DataMovimentacao, CodigoMovel, IDSetorOrigem, IDSetorDestino, IDResponsavel)
				    VALUES (?, ?, ?, ?, ?);
				""";

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, data);
		stmt.setInt(2, codigoMovel);
		stmt.setInt(3, setorOrigem);
		stmt.setInt(4, setorDestino);
		stmt.setInt(5, responsavel);
		stmt.executeUpdate();
		stmt.close();
		connection.close();
	}

	private void preencherSetor(JComboBox<String> setorComboBox) throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				SELECT Nome FROM Setor
				""";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			setorComboBox.addItem(result.getString("Nome"));
		}
		connection.close();
	}

	private void preencherResponsavel(JComboBox<String> responsavelComboBox) throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				SELECT Nome
				FROM Funcionario
				""";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			responsavelComboBox.addItem(result.getString("Nome"));
		}
		connection.close();

	}

	private static int obterSetorId(String setor) throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				SELECT ID
				FROM Setor
				WHERE Nome = ?;
				""";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, setor);
		ResultSet result = stmt.executeQuery();
		try {
			if (result.next()) {
				return result.getInt("ID");
			} else {
				return 0;
			}
		} finally {
			result.close();
			stmt.close();
			connection.close();
		}
	}

	private static int obterResponsavelId(String nome) throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				SELECT ID
				FROM Funcionario
				WHERE Nome = ?;
				""";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, nome);
		ResultSet result = stmt.executeQuery();
		try {
			if (result.next()) {
				return result.getInt("ID");
			} else {
				return 0;
			}
		} finally {
			result.close();
			stmt.close();
			connection.close();
		}
	}
}