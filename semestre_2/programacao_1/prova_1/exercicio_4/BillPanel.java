import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BillPanel extends JPanel {

	public BillPanel(Consumer consumer) {

		setLayout(new GridLayout(6, 2));

		add(new JLabel("Nome Completo:"));
		add(new JLabel(consumer.getName()));

		add(new JLabel("Data de Nascimento (dd/MM/yyyy):"));
		add(new JLabel(consumer.getBirthDate()));

		add(new JLabel("Endereço:"));
		add(new JLabel(consumer.getAdress()));

		add(new JLabel("Sexo:"));
		add(new JLabel(consumer.getSex()));

		add(new JLabel("Produtos:"));
		add(new JLabel(consumer.getBuyes()));

		String bill = String.format("%.2f", consumer.getBill());
		add(new JLabel("Valor da fatura"));
		add(new JLabel(bill));

	}

}