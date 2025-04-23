import java.util.Scanner;

public class ex24 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite quantos termos deseja imprimir da sequência Fibonacci: ");
		int amount = enter.nextInt();

		printFibonacci(amount);

		enter.close();

	}

	public static void printFibonacci(int amount) {
		int aux1 = 0, aux2 = 1;
		int i = 1;

		while (i <= amount) {
			System.out.print(aux1 + " ");
			int sum = aux1 + aux2;
			aux1 = aux2;
			aux2 = sum;
			i++;
		}

	}

}
