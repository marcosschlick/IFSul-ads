import java.util.Scanner;

public class ex10 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite uma palavra para verificar se é um Palíndromo: ");
		String word = enter.next();

		System.out.println(isPalindrome(word) ? "Sim, um Palíndromo!" : "Não, é um Palíndromo!");

		enter.close();

	}

	public static boolean isPalindrome(String word) {
		String wordAux = "";
		for (int i = word.length() - 1; i >= 0; i--) {
			wordAux += word.charAt(i);
		}
		return word.equalsIgnoreCase(wordAux);
	}

}
