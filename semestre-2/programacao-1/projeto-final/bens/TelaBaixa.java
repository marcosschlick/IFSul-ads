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
public class TelaBaixa extends JPanel {
	public TelaBaixa(CardLayout cardLayout, JPanel cards, int codigoMovel) {
		setLayout(null);
		setBackground(new Color(200, 255, 200));

		Title title = new Title("Criar funcionário");

		JLabel dataLabel = new JLabel("Data:");
		dataLabel.setBounds(250, 340, 200, 30);
		dataLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(dataLabel);

		JLabel motivoLabel = new JLabel("Motivo:");
		motivoLabel.setBounds(250, 410, 200, 30);
		motivoLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(motivoLabel);

		JTextField dataField = new JTextField();
		dataField.setBounds(420, 340, 400, 40);
		dataField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(dataField);

		JTextField motivoField = new JTextField();
		motivoField.setBounds(420, 410, 400, 40);
		motivoField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(motivoField);

		NavigationButton confirmar = new NavigationButton("Confirmar", 800, 550, 300, 100);
		confirmar.addActionListener(e -> {
			try {
				String data = dataField.getText();
				String motivo = motivoField.getText();
				baixar(codigoMovel, motivo, data);
				JOptionPane.showMessageDialog(null, "Baixa realizada com sucesso");
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

	private void baixar(int codigoMovel, String motivo, String data) throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				    INSERT INTO Baixa (CodigoMovel, Motivo, DataBaixa)
				    VALUES (?, ?, ?);
				    """;

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, codigoMovel);
		stmt.setString(2, motivo);
		stmt.setString(3, data);

		stmt.executeUpdate();
		stmt.close();
		connection.close();
	}

}
