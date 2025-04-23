import java.util.Random;
import javax.swing.JOptionPane;

public class Game {

	public static void main(String[] args) {

		final int answer = raffle();
		int round = 0;
		int num = 0;

		do {

			if (num > answer) {
				num = getInt(JOptionPane.showInputDialog(null,
						"O número deve ser menor, digite outro número de 0 á 100: ", "Jogo da adivinhação", 3));

			} else if (num < answer && num != 0) {
				num = getInt(JOptionPane.showInputDialog(null,
						"O número deve ser maior, digite outro número de 0 á 100: ", "Jogo da adivinhação", 3));

			} else {
				num = getInt(
						JOptionPane.showInputDialog(null, "Digite um número de 0 á 100: ", "Jogo da adivinhação", 3));
			}
			round++;

		} while (round < 5 && num != answer);

		if (num == answer) {
			JOptionPane.showMessageDialog(null, "Parabéns você acertou!!!", "Resultado", 1);

		} else {
			JOptionPane.showMessageDialog(null, "Não foi dessa vez, tente outra vez!", "Resultado", 0);
		}

	}

	public static int raffle() {
		Random random = new Random();
		return random.nextInt(101);
	}

	public static int getInt(String aux) {
		if (aux.isBlank() || aux.isEmpty()) {
			return 0;
		} else {
			return Integer.parseInt(aux);
		}

	}
}
