import java.awt.GridLayout;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class PanelIMC extends JPanel {

	private JTextField nameField;
	private JFormattedTextField birthDateField;
	private JTextField addressField;
	private JTextField heightField;
	private JTextField weightField;
	private JComboBox<String> sexBox;

	public PanelIMC() {
		setLayout(new GridLayout(6, 2));

		nameField = new JTextField(20);
		addressField = new JTextField(20);
		heightField = new JTextField(5);
		weightField = new JTextField(5);

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
		add(new JLabel("Altura (m):"));
		add(heightField);
		add(new JLabel("Peso (kg):"));
		add(weightField);
	}

	public String getName() {
		return nameField.getText();
	}

	public String getBirthDate() {
		return birthDateField.getText();
	}

	public String getAddress() {
		return addressField.getText();
	}

	public double getHeightM() {
		double height = Double.parseDouble(heightField.getText().replace(',', '.'));
		return height;
	}

	public double getWeightKg() {
		double weight = Double.parseDouble(weightField.getText().replace(',', '.'));
		return weight;
	}

	public String getSexo() {
		return (String) sexBox.getSelectedItem();
	}
}
