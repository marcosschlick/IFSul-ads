package sem_retorno;

import java.util.Scanner;

public class ex26 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		printSquareNumbers();

		enter.close();

	}

	public static void printSquareNumbers() {

		for (int i = 1; i <= 10; i++) {

			System.out.println(i + "² = " + (int) Math.pow(i, 2));

		}
	}
}
