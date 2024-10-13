import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Register {

	public static void main(String[] args) {

		ArrayList<Customer> customers = new ArrayList<Customer>();

		final int end = 0;
		int aux;

		do {
			customers.add(new Customer(JOptionPane.showInputDialog(
					"Digite o nome do cliente e seu email separados por ',' exemplo: 'Marcos da Silva, marcosdasilva@ifsul.com")));

			aux = JOptionPane.showConfirmDialog(null, "Deseja encerrar a inserção?", "Confirmar",
					JOptionPane.YES_NO_OPTION);

		} while (end != aux);

		StringBuilder message = new StringBuilder();
		message.append(String.format("%-15s %-15s %-15s %-15s%n", "Sobrenome", "Nome", "Instituição", "Usuário"));

		customers.forEach(customer -> message.append(String.format("%-15s %-15s %-15s %-15s%n", customer.getSurname(),
				customer.getName(), customer.getInstitution(), customer.getUser())));

		JOptionPane.showMessageDialog(null, message.toString(), "Resultado", JOptionPane.INFORMATION_MESSAGE);

	}
}
