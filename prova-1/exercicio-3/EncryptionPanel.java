import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class EncryptionPanel extends JPanel {

	private JTextField messageField;
	private JTextField keyField;

	public EncryptionPanel() {
		setLayout(new GridLayout(6, 2));

		messageField = new JTextField(20);
		keyField = new JTextField(5);

		add(new JLabel("Digite uma mensagem à ser codificada:"));
		add(messageField);
		add(new JLabel("Digite qual será a chave da criptografia:"));
		add(keyField);

	}

	public String getMessage() {
		return messageField.getText();
	}

	public int getKey() {
		return Integer.parseInt(keyField.getText());
	}

}