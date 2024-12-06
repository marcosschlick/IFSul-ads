package funcionario;

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
public class TelaEditarFuncionario extends JPanel {
	public TelaEditarFuncionario(CardLayout cardLayout, JPanel cards) {
		setLayout(null);
		setBackground(new Color(200, 255, 200));

		Title title = new Title("Criar setor");

		JLabel matriculaAtualLabel = new JLabel("Matricula do funcionário:");
		matriculaAtualLabel.setBounds(250, 200, 320, 30);
		matriculaAtualLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(matriculaAtualLabel);

		JLabel matriculaLabel = new JLabel("Nova matrícula:");
		matriculaLabel.setBounds(250, 270, 320, 30);
		matriculaLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(matriculaLabel);

		JLabel nomeLabel = new JLabel("Novo nome:");
		nomeLabel.setBounds(250, 340, 320, 30);
		nomeLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(nomeLabel);

		JLabel emailLabel = new JLabel("Novo email:");
		emailLabel.setBounds(250, 410, 320, 30);
		emailLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(emailLabel);

		JLabel telefoneLabel = new JLabel("Novo telefone:");
		telefoneLabel.setBounds(250, 480, 320, 30);
		telefoneLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(telefoneLabel);

		JLabel setorLabel = new JLabel("Novo setor:");
		setorLabel.setBounds(250, 550, 320, 30);
		setorLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(setorLabel);

		JTextField matriculatualField = new JTextField();
		matriculatualField.setBounds(570, 200, 400, 40);
		matriculatualField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(matriculatualField);

		JTextField matriculaField = new JTextField();
		matriculaField.setBounds(570, 270, 400, 40);
		matriculaField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(matriculaField);

		JTextField nomeField = new JTextField();
		nomeField.setBounds(570, 340, 400, 40);
		nomeField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(nomeField);

		JTextField emailField = new JTextField();
		emailField.setBounds(570, 410, 400, 40);
		emailField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(emailField);

		JTextField telefoneField = new JTextField();
		telefoneField.setBounds(570, 480, 400, 40);
		telefoneField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(telefoneField);

		JComboBox<String> setorComboBox = new JComboBox<>();
		setorComboBox.setBounds(570, 550, 400, 40);
		setorComboBox.setFont(new Font("Arial", Font.PLAIN, 25));
		try {
			preencherLista(setorComboBox);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		add(setorComboBox);

		NavigationButton confirmar = new NavigationButton("Confirmar", 800, 600, 300, 100);
		confirmar.addActionListener(e -> {
			try {
				int matriculaAtual = Integer.parseInt(matriculatualField.getText());
				int matriculaNova = Integer.parseInt(matriculaField.getText());
				String nome = nomeField.getText();
				String email = emailField.getText();
				String telefone = telefoneField.getText();
				String setor = (String) setorComboBox.getSelectedItem();
				int setorId = obterId(setor);

				atualizarFuncionario(matriculaNova, nome, email, telefone, setorId, matriculaAtual);
				JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + ex.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		BackButton backButton = new BackButton(cardLayout, cards, "TelaSetores");

		add(title);
		add(confirmar);
		add(backButton);
	}

	private void preencherLista(JComboBox<String> setorComboBox) throws SQLException {
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

	private void atualizarFuncionario(int novaMatricula, String nome, String email, String telefone, int setorId,
			int matricula) throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				   UPDATE Funcionario
					SET Matricula = ?,
					Nome = ?,
					Email = ?,
					Telefone = ?,
					SetorQuePertence = ?
					WHERE Matricula = ?;
				    """;

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, novaMatricula);
		stmt.setString(2, nome);
		stmt.setString(3, email);
		stmt.setString(4, telefone);
		stmt.setInt(5, setorId);
		stmt.setInt(6, matricula);
		stmt.executeUpdate();
		stmt.close();
		connection.close();
	}

	private static int obterId(String setor) throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				SELECT CodigoSetor
				FROM Setor
				WHERE Nome = ?;
				""";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, setor);
		ResultSet result = stmt.executeQuery();
		try {
			if (result.next()) {
				return result.getInt("CodigoSetor");
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
