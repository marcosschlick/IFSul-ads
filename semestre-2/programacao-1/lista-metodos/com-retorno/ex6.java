import java.util.Scanner;

public class ex6 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite o raio do círculo: ");
		double radius = enter.nextDouble();

		double area = getArea(radius);

		System.out.printf("A área do círculo é %.2f", area);

		enter.close();
	}

	public static double getArea(double radius) {

		double area = Math.PI * Math.pow(radius, 2);
		return area;

	}

}
