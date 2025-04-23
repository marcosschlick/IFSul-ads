import java.util.Scanner;

public class ex16 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite a altura do retângulo: ");
		double height = enter.nextDouble();

		System.out.print("Digite a largura do retângulo: ");
		double width = enter.nextDouble();

		double perimeter = getPerimeter(height, width);

		System.out.println("O perímetro é " + perimeter);
		enter.close();

	}

	public static double getPerimeter(double height, double width) {
		double perimeter = 2 * (height + width);
		return perimeter;
	}

}
