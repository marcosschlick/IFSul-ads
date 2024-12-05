package setor;

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
public class TelaCriarSetor extends JPanel {
	public TelaCriarSetor(CardLayout cardLayout, JPanel cards) {
		setLayout(null);
		setBackground(new Color(200, 255, 200));

		Title title = new Title("Criar setor");

		JLabel matriculaLabel = new JLabel("Código do setor:");
		matriculaLabel.setBounds(250, 340, 320, 30);
		matriculaLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(matriculaLabel);

		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(250, 410, 320, 30);
		nomeLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(nomeLabel);

		JLabel setorLabel = new JLabel("Funcionário responsável:");
		setorLabel.setBounds(250, 480, 320, 30);
		setorLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(setorLabel);

		JTextField matriculaField = new JTextField();
		matriculaField.setBounds(570, 340, 400, 40);
		matriculaField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(matriculaField);

		JTextField nomeField = new JTextField();
		nomeField.setBounds(570, 410, 400, 40);
		nomeField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(nomeField);

		JComboBox<String> responsavelComboBox = new JComboBox<>();
		responsavelComboBox.setBounds(570, 480, 400, 40);
		responsavelComboBox.setFont(new Font("Arial", Font.PLAIN, 25));
		try {
			preencherLista(responsavelComboBox);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		add(responsavelComboBox);

		NavigationButton confirmar = new NavigationButton("Confirmar", 800, 550, 300, 100);
		confirmar.addActionListener(e -> {
			try {
				int matricula = Integer.parseInt(matriculaField.getText());
				String nome = nomeField.getText();
				String responsavel = (String) responsavelComboBox.getSelectedItem();
				int setorId = obterId(responsavel);

				criarSetor(matricula, nome, setorId);
				JOptionPane.showMessageDialog(null, "Novo setor criado com sucesso");
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

	private void preencherLista(JComboBox<String> responsavelComboBox) throws SQLException {
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

	private void criarSetor(int CodigoSetor, String nome, int funcionarioId)
	        throws SQLException {
	    Connection connection = ConnectionMySQL.getConnection();
	    String sql = """
	            INSERT INTO Setor 
	            (CodigoSetor, Nome, Responsavel)
	            VALUES (?, ?, ?)
	            """;

	    PreparedStatement stmt = connection.prepareStatement(sql);
	    stmt.setInt(1, CodigoSetor);
	    stmt.setString(2, nome);
	    stmt.setInt(3, funcionarioId); 
	    stmt.executeUpdate();
	    stmt.close();
	    connection.close();
	}


	private static int obterId(String nome) throws SQLException {
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
