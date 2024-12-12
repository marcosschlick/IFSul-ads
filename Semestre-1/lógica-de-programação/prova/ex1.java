package prova;

public class ex1 {

	public static void main(String[] args) {
		int j = 1;
		int a = 1;
		int n = 8;
		while (j < n) {
			j = j * 2;
			for (int k = 0; k <= j; k++) {
				System.out.print(a + " ");
				a++;
			}
		}
	}
}
