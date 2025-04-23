import java.util.Scanner;

public class ex8 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);
		System.out.print("Digite uma palavra para contar seus caractéres: ");
		String word = enter.next();

		int character = countCharacter(word);

		System.out.print("A palavra tem " + character + " caractéres");

		enter.close();

	}

	public static int countCharacter(String word) {

		int result = word.length();

		return result;
	}

}
