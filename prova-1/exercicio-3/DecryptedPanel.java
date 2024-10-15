import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DecryptedPanel extends JPanel {

	public DecryptedPanel(String encrypted, String decrypted, int key) {
		setLayout(new GridLayout(6, 2));

		add(new JLabel("Mensagem criptografada:"));

		add(new JLabel(encrypted));

		add(new JLabel("Mensagem descriptografada:"));

		add(new JLabel(decrypted));
		
		add(new JLabel("Chave escolhida:"));

		add(new JLabel(Integer.toString(key)));

	}

}