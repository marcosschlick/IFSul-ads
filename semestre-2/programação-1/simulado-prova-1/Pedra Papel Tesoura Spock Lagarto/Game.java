import java.util.Random;
import javax.swing.JOptionPane;

public class Game {

	public static void main(String[] args) {

		int playerWins = 0;
		int botWins = 0;

		Rules[] options = { Rules.TESOURA, Rules.PEDRA, Rules.PAPEL, Rules.SPOCK, Rules.LAGARTO };

		while (playerWins < 3 && botWins < 3) {

			Rules bot = options[raffle()];

			Rules player = options[JOptionPane.showOptionDialog(null, "Escolha a sua jogada:",
					"Pedra, Papel, Tesoura, Lagarto, Spock", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, options, options[0])];

			if (player.play(bot) == 0) {
				JOptionPane.showMessageDialog(null, "Você e o bot jogaram " + player
						+ " portanto o placar está:  Player: " + playerWins + " Bot: " + botWins, "Resultado da rodada",
						1);
			} else if (player.play(bot) == 1) {
				playerWins++;
				JOptionPane.showMessageDialog(null, "Você jogou " + player + " e o bot jogou " + bot
						+ " portanto você ganhou a rodada e o placar está:  Player: " + playerWins + " Bot: " + botWins,
						"Resultado da rodada", 1);
			} else if (player.play(bot) == 2) {
				botWins++;
				JOptionPane.showMessageDialog(null,
						"Você jogou " + player + " e o bot jogou " + bot
								+ " portanto o bot ganhou a rodada e o placar está:  Player: " + playerWins + " Bot: "
								+ botWins,
						"Resultado da rodada", 1);
			}

		}

	}

	public static int raffle() {
		Random random = new Random();
		return random.nextInt(5);
	}

}
