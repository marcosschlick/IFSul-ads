import java.util.Scanner;

public class ex22 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite um número inteiro à ser elevado ao quadrado: ");
		int num = enter.nextInt();

		getSquare(num);

		enter.close();

	}

	public static void getSquare(int num) {
		System.out.println("O número elevado ao quadrado é " + (int) Math.pow(num, 2));
	}
}
