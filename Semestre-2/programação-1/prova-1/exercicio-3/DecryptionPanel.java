import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DecryptionPanel extends JPanel {

	public DecryptionPanel(String encrypted) {
		setLayout(new GridLayout(6, 2));

		add(new JLabel("Mensagem criptografada:"));

		add(new JLabel(encrypted));

		add(new JLabel("Deseja descriptografar a mensagem?"));

	}

}