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
public class TelaCriarBem extends JPanel {
	public TelaCriarBem(CardLayout cardLayout, JPanel cards) {
		setLayout(null);
		setBackground(new Color(200, 255, 200));

		Title title = new Title("Criar setor");

		JLabel codigoPatrimonialLabel = new JLabel("Código Patrimonial:");
		codigoPatrimonialLabel.setBounds(250, 150, 320, 30);
		codigoPatrimonialLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(codigoPatrimonialLabel);

		JLabel descricaoLabel = new JLabel("Descrição:");
		descricaoLabel.setBounds(250, 220, 320, 30);
		descricaoLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(descricaoLabel);

		JLabel tipoLabel = new JLabel("Tipo:");
		tipoLabel.setBounds(250, 290, 320, 30);
		tipoLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(tipoLabel);

		JLabel dataAquisicaoLabel = new JLabel("Data de Aquisição:");
		dataAquisicaoLabel.setBounds(250, 360, 320, 30);
		dataAquisicaoLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(dataAquisicaoLabel);

		JLabel valorLabel = new JLabel("Valor:");
		valorLabel.setBounds(250, 430, 320, 30);
		valorLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(valorLabel);

		JLabel estadoLabel = new JLabel("Estado:");
		estadoLabel.setBounds(250, 500, 320, 30);
		estadoLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(estadoLabel);

		JLabel setorLabel = new JLabel("Setor:");
		setorLabel.setBounds(250, 570, 320, 30);
		setorLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(setorLabel);

		JTextField codigoPatrimonialField = new JTextField();
		codigoPatrimonialField.setBounds(570, 150, 400, 40);
		codigoPatrimonialField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(codigoPatrimonialField);

		JTextField descricaoField = new JTextField();
		descricaoField.setBounds(570, 220, 400, 40);
		descricaoField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(descricaoField);

		JComboBox<String> tipoComboBox = new JComboBox<>();
		tipoComboBox.setBounds(570, 290, 400, 40);
		tipoComboBox.setFont(new Font("Arial", Font.PLAIN, 25));
		try {
			preencherTipo(tipoComboBox);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		add(tipoComboBox);

		JTextField dataAquisicaoField = new JTextField();
		dataAquisicaoField.setBounds(570, 360, 400, 40);
		dataAquisicaoField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(dataAquisicaoField);

		JTextField valorField = new JTextField();
		valorField.setBounds(570, 430, 400, 40);
		valorField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(valorField);

		JComboBox<String> estadoComboBox = new JComboBox<>();
		estadoComboBox.setBounds(570, 500, 400, 40);
		estadoComboBox.setFont(new Font("Arial", Font.PLAIN, 25));
		estadoComboBox.addItem("ATIVO");
		estadoComboBox.addItem("EM_MANUTENCAO");
		estadoComboBox.addItem("DANIFICADO");
		estadoComboBox.addItem("INATIVO");
		estadoComboBox.addItem("BAIXADO");
		add(estadoComboBox);

		JComboBox<String> setorComboBox = new JComboBox<>();
		setorComboBox.setBounds(570, 570, 400, 40);
		setorComboBox.setFont(new Font("Arial", Font.PLAIN, 25));
		try {
			preencherSetor(setorComboBox);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		add(setorComboBox);

		NavigationButton confirmar = new NavigationButton("Confirmar", 800, 650, 300, 100);
		confirmar.addActionListener(e -> {
			try {
				int codigoPatrimonial = Integer.parseInt(codigoPatrimonialField.getText());
				String descricao = descricaoField.getText();
				String tipo = (String) tipoComboBox.getSelectedItem();
				String dataAquisicao = dataAquisicaoField.getText();
				double valor = Double.parseDouble(valorField.getText());
				String estado = (String) estadoComboBox.getSelectedItem(); 
				String setor = (String) setorComboBox.getSelectedItem();
				int tipoId = obterIdTipo(tipo);
				int setorId = obterIdSetor(setor);

				criarBem(codigoPatrimonial, descricao, tipoId, dataAquisicao, valor, estado, setorId);

				JOptionPane.showMessageDialog(null, "Novo bem criado com sucesso!");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + ex.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		BackButton backButton = new BackButton(cardLayout, cards, "TelaBens");

		add(title);
		add(confirmar);
		add(backButton);
	}

	private void preencherTipo(JComboBox<String> tipoComboBox) throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				SELECT Nome
				FROM Tipo
				""";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			tipoComboBox.addItem(result.getString("Nome"));
		}
		connection.close();
	}

	private void preencherSetor(JComboBox<String> setorComboBox) throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				SELECT Nome
				FROM Setor
				""";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			setorComboBox.addItem(result.getString("Nome"));
		}
		connection.close();
	}

	private static int obterIdSetor(String setor) throws SQLException {
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

	private static int obterIdTipo(String tipo) throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				SELECT ID
				FROM Tipo
				WHERE Nome = ?;
				""";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, tipo);
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

	private void criarBem(int codigoPatrimonial, String descricao, int tipoId, String dataAquisicao, double valor,
			String estado, int setorId) throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				INSERT INTO Movel
				(CodigoPatrimonial, Descricao, IDTipo, DataAquisicao, Valor, Estado, IDSetor)
				VALUES (?, ?, ?, ?, ?, ?, ?)
				""";

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, codigoPatrimonial);
		stmt.setString(2, descricao);
		stmt.setInt(3, tipoId);
		stmt.setString(4, dataAquisicao);
		stmt.setDouble(5, valor);
		stmt.setString(6, estado);
		stmt.setInt(7, setorId);
		stmt.executeUpdate();

		connection.close();
	}
}
