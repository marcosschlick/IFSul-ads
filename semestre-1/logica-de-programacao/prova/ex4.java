import java.util.Scanner;

public class ex4 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		int q = 0, qMenor = 0;
		double total = 0, conta = 0, preco = 0, maior = 0;

		do {
			System.out.print("Digite a quantidade de litros de uma residência em m³ ou -1 para sair: ");
			conta = enter.nextDouble();
			if (conta != -1) {
				q++;
				total += conta;
				if (conta > maior | q == 1) {
					maior = conta;
				}
				if (conta <= 10) {
					System.out.println("Você deverá pagar 9 reais pelo consumo.");
					qMenor++;
				} else if (conta > 10 & conta <= 20) {
					preco = 9 + ((conta - 10) * 2);
					System.out.println("Você deverá pagar " + preco + " reais pelo consumo.");
				} else if (conta > 20 & conta <= 30) {
					preco = 9 + 20 + ((conta - 20) * 3);
					System.out.println("Você deverá pagar " + preco + " reais pelo consumo.");
				} else if (conta > 30) {
					preco = 9 + 20 + 30 + ((conta - 30) * 5);
					System.out.println("Você deverá pagar " + preco + " reais pelo consumo.");
				}
			}

		} while (conta != -1);

		System.out.println("A média do consumo foi " + total / q + " m³ por residência.");
		System.out.println("A residência com maior consumo foi " + maior + " m³.");
		System.out.println("A porcentagem de residências com consumo menor à 10m³ é " + ((100 / q) * qMenor) + "%");

		enter.close();

	}

}
