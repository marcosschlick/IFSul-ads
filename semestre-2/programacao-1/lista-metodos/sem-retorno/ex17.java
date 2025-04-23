import java.util.Scanner;

public class ex17 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite um número para imprimir a sua tabuáda: ");
		int num = enter.nextInt();

		multiplicationTable(num);

		enter.close();

	}

	public static void multiplicationTable(int num) {
		System.out.println("1 * " + num + " = " + 1 * num);
		System.out.println("2 * " + num + " = " + 2 * num);
		System.out.println("3 * " + num + " = " + 3 * num);
		System.out.println("4 * " + num + " = " + 4 * num);
		System.out.println("5 * " + num + " = " + 5 * num);
		System.out.println("6 * " + num + " = " + 6 * num);
		System.out.println("7 * " + num + " = " + 7 * num);
		System.out.println("8 * " + num + " = " + 8 * num);
		System.out.println("9 * " + num + " = " + 9 * num);
		System.out.println("10 * " + num + " = " + 10 * num);
	}

}
