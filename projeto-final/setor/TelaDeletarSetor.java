package setor;

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
public class TelaDeletarSetor extends JPanel {
	public TelaDeletarSetor(CardLayout cardLayout, JPanel cards) {
		setLayout(null);
		setBackground(new Color(200, 255, 200));

		Title title = new Title("Deletar setor");

		JLabel setorLabel = new JLabel("Código do setor:");
		setorLabel.setBounds(250, 410, 320, 30);
		setorLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(setorLabel);

		JTextField setorField = new JTextField();
		setorField.setBounds(570, 410, 400, 40);
		setorField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(setorField);

		NavigationButton confirmar = new NavigationButton("Confirmar", 800, 550, 300, 100);
		confirmar.addActionListener(e -> {
			try {

				int setor = Integer.parseInt(setorField.getText());

				deletarSetor(setor);
				JOptionPane.showMessageDialog(null, "Setor deletado com sucesso");
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

	private void deletarSetor(int CodigoSetor) throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				DELETE FROM Setor
				WHERE CodigoSetor = ?;
				""";

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, CodigoSetor);
		stmt.executeUpdate();
		stmt.close();
		connection.close();
	}

}
