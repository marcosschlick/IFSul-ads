import java.awt.GridLayout;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class ConsumerPanel extends JPanel {

	private JTextField nameField;
	private JFormattedTextField birthDateField;
	private JTextField addressField;
	private JTextField balanceField;
	private JComboBox<String> sexBox;

	public ConsumerPanel() {
		setLayout(new GridLayout(6, 2));

		nameField = new JTextField(20);
		addressField = new JTextField(20);
		balanceField = new JTextField(5);

		try {
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
			mascaraData.setPlaceholderCharacter('_');
			birthDateField = new JFormattedTextField(mascaraData);
			birthDateField.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String[] sexOptions = { "Masculino", "Feminino" };
		sexBox = new JComboBox<>(sexOptions);

		add(new JLabel("Nome Completo:"));
		add(nameField);
		add(new JLabel("Data de Nascimento (dd/MM/yyyy):"));
		add(birthDateField);
		add(new JLabel("Endereço:"));
		add(addressField);
		add(new JLabel("Sexo:"));
		add(sexBox);
		add(new JLabel("Saldo bancário:"));
		add(balanceField);
		

		
	}
	public void setConsumer(Consumer consumer) {
		consumer.setName(nameField.getText());
		consumer.setAdress(addressField.getText());
		consumer.setBalance(Double.parseDouble(balanceField.getText().replace(',', '.')));
		consumer.setSex((String) sexBox.getSelectedItem());
	}


}