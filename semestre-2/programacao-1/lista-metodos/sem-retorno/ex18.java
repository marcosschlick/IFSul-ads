import java.util.Scanner;

public class ex18 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		printNumbers();

		enter.close();

	}

	public static void printNumbers() {

		for (int i = 1; i <= 10; i++) {

			System.out.println(i);

		}

	}
}
