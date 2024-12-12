package funcionario;

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
public class TelaDeletarFuncionario extends JPanel {
	public TelaDeletarFuncionario(CardLayout cardLayout, JPanel cards) {
		setLayout(null);
		setBackground(new Color(200, 255, 200));

		Title title = new Title("Deletar funcionário");

		JLabel matriculaLabel = new JLabel("Matrícula do funcionário:");
		matriculaLabel.setBounds(250, 410, 320, 30);
		matriculaLabel.setFont(new Font("Arial", Font.BOLD, 25));
		add(matriculaLabel);

		JTextField matriculaField = new JTextField();
		matriculaField.setBounds(570, 410, 400, 40);
		matriculaField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(matriculaField);

		NavigationButton confirmar = new NavigationButton("Confirmar", 800, 550, 300, 100);
		confirmar.addActionListener(e -> {
			try {

				int matricula = Integer.parseInt(matriculaField.getText());

				deletarFuncionario(matricula);
				JOptionPane.showMessageDialog(null, "Funcionário deletado com sucesso");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + ex.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		BackButton backButton = new BackButton(cardLayout, cards, "TelaFuncionarios");

		add(title);
		add(confirmar);
		add(backButton);
	}

	private void deletarFuncionario(int Matricula) throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				DELETE FROM Funcionario
				WHERE Matricula = ?;
				""";

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, Matricula);
		stmt.executeUpdate();
		stmt.close();
		connection.close();
	}

}
