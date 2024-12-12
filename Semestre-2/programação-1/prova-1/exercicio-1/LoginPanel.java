import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel {

	private JTextField loginField;
	private JTextField passwordFIeld;
	private JTextField confirmPasswordField;

	public LoginPanel() {
		setLayout(new GridLayout(6, 2));

		loginField = new JTextField(20);
		passwordFIeld = new JTextField(20);
		confirmPasswordField = new JTextField(20);

		add(new JLabel(
				"Digite um login que  tenha entre 5 e 20 caracteres usando apenas letras e números (não pode começar com um número)."));
		add(loginField);
		add(new JLabel(
				"Digite a sua senha que tenha entre 16 e 32 caracteres com pelo menos uma letra maiúscula,letra minúscula, um número e um caractere especial (por exemplo, !, @, #, $, %):"));
		add(passwordFIeld);
		add(new JLabel("Confirme a sua senha:"));
		add(confirmPasswordField);

	}

	public String getLogin() {
		return loginField.getText();
	}

	public String getPassword() {
		return passwordFIeld.getText();
	}

	public String getConfirmPassword() {
		return confirmPasswordField.getText();
	}

}
