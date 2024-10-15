import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Login {

	public static void main(String[] args) {
		LoginPanel loginPanel = new LoginPanel();
		String login = "", password = "", confirmPassword = "";

		int result = JOptionPane.showConfirmDialog(null, loginPanel, "Digite as informações para criar uma conta",
				JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {

			login = loginPanel.getLogin();
			password = loginPanel.getPassword();
			confirmPassword = loginPanel.getConfirmPassword();

			System.out.println(validateLogin(login));
			System.out.println(validatePassword(password));
			System.out.println(confirmPassword(confirmPassword, password));
		}
		if (validateLogin(login) && validatePassword(password) && confirmPassword(confirmPassword, password)) {
			JOptionPane.showMessageDialog(null, "A sua conta foi criada com sucesso!", "Criação da conta", 1);
		} else {
			JOptionPane.showMessageDialog(null, "As suas informações não cumpriram com os requisitos...", "ERROR", 0);
		}

	}

	public static boolean validateLogin(String login) {
		String regex = "^[A-Za-z]\\w{4,19}$";
		Pattern pattern = Pattern.compile(regex);
		return login.matches(regex);
	}

	public static boolean validatePassword(String password) {
		String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{16,32}$";
		Pattern pattern = Pattern.compile(regex);
		return password.matches(regex);
	}

	public static boolean confirmPassword(String confirmPassword, String password) {
		return confirmPassword.equals(password);
	}

}
