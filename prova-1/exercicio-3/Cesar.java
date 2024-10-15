import java.text.Normalizer;

import javax.swing.JOptionPane;

public class Cesar {

	public static void main(String[] args) {

		EncryptionPanel encryptionPanel = new EncryptionPanel();
		String message = "";
		String encryptedMessage = "";
		int key = 0;

		int result = JOptionPane.showConfirmDialog(null, encryptionPanel, "Criptografia de Cesar",
				JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {

			message = encryptionPanel.getMessage();
			key = encryptionPanel.getKey();

			encryptedMessage = encrypt(message, key);

			DecryptionPanel decryptionPanel = new DecryptionPanel(encryptedMessage);

			int result2 = JOptionPane.showConfirmDialog(null, decryptionPanel, "Criptografia de Cesar",
					JOptionPane.YES_NO_OPTION);

			if (result2 == JOptionPane.YES_OPTION) {

				DecryptedPanel decryptedPanel = new DecryptedPanel(encryptedMessage, message, key);

				JOptionPane.showConfirmDialog(null, decryptedPanel, "Criptografia de Cesar",
						JOptionPane.OK_CANCEL_OPTION);

			}
		}

	}

	public static String encrypt(String message, int key) {

		final String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		message = message.toUpperCase();
		message = fix(message);

		StringBuilder encryptedMessage = new StringBuilder();

		for (int i = 0; i < message.length(); i++) {

			Character originalChar = message.charAt(i);

			int pos = alfabet.indexOf(originalChar);

			if (pos != -1) {

				if (!alfabet.contains(originalChar.toString())) {
					encryptedMessage.append(originalChar);

				} else {

					int newPos = (pos + key) % 26;
					char encryptedChar = alfabet.charAt(newPos);
					encryptedMessage.append(encryptedChar);
				}

			} else {

				encryptedMessage.append(originalChar);

			}

		}
		return encryptedMessage.toString();
	}

	private static String fix(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

}
