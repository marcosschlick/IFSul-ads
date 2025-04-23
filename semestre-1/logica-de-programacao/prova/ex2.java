public class ex2 {
	public static void main(String[] args) {
		int a = 3;
		int b = 0;
		int c = 3;
		while (a > c) {
			a = a - 1;
			b = b + 1;
			c = c + b;
		}
		System.out.println("Laço A: " + " a = " + a + ", b = " + b + ", c = " + c);
		do {
			a = a - 1;
			b = b + 1;
			c = c + b;
		} while (a > c);
		System.out.println("\nLaço B: " + " a = " + a + ", b = " + b + ", c = " + c);
	}
}
