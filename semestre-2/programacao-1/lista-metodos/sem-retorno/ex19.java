import java.util.Scanner;

public class ex19 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite o texto à ser impresso: ");
		String text = enter.nextLine();

		System.out.print("Digite a quantidade de vezes à ser impresso: ");
		int amount = enter.nextInt();

		printMessage(text, amount);
		
		enter.close();

	}

	public static void printMessage(String text, int num) {

		for (int i = 0; i < num; i++) {
			System.out.println(text);
		}
	}

}
