package sem_retorno;

import java.util.Scanner;

public class ex29 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite a altura do retângulo: ");
		int height = enter.nextInt();

		System.out.print("Digite a largura do retângulo: ");
		int witdh = enter.nextInt();

		System.out.print("Digite o caractére para desenhar o retângulo: ");
		char character = enter.next().charAt(0);

		printRectangle(height, witdh, character);

		enter.close();

	}

	public static void printRectangle(int height, int witdh, char character) {

		for (int i = 0; i < height; i++) {

			for (int j = 0; j < witdh; j++) {

				System.out.print(character + " ");
			}

			System.out.println();
		}

	}

}
