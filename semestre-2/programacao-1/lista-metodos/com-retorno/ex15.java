import java.util.Scanner;

public class ex15 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite o texto que desejas passar para maísculas: ");
		String text = enter.nextLine();

		String textUpper = toUpper(text);

		System.out.println("O resultado foi: " + textUpper);

		enter.close();

	}

	public static String toUpper(String text) {

		return text.toUpperCase();
	}

}
