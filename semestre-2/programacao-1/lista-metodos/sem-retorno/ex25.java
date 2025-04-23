import java.util.Scanner;

public class ex25 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite a altura da pirâmide: ");
		int height = enter.nextInt();

		printTriangle(height);

		enter.close();

	}

	public static void printTriangle(int height) {

		for (int i = 0; i < height; i++) {

			for (int j = i; j < height - 1; j++) {
				System.out.print(" ");
			}

			for (int k = i; k >= 0; k--) {
				System.out.print("* ");
			}

			System.out.println();

		}

	}

}
