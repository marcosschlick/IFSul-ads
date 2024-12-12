package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Answer {

	ArrayList<Integer> nums = new ArrayList<Integer>();

	int num1 = raffle(nums);
	int num2 = raffle(nums);
	int num3 = raffle(nums);
	int num4 = raffle(nums);

	Color color1 = setColor(num1);
	Color color2 = setColor(num2);
	Color color3 = setColor(num3);
	Color color4 = setColor(num4);

	Color[] colors = { color1, color2, color3, color4 };

	private static Color setColor(int num) {

		switch (num) {

		case 0:
			return Color.red;

		case 1:
			return Color.blue;
		case 2:
			return Color.green;

		case 3:
			return Color.pink;

		case 4:
			return Color.yellow;

		default:
			return Color.orange;
		}

	}

	public int raffle(ArrayList<Integer> nums) {
		Random random = new Random();
		int num;

		do {
			num = random.nextInt(6);

		} while (nums.contains(num));
		nums.add(num);
		return num;

	}

	public Color getColor1() {
		return color1;
	}

	public Color getColor2() {
		return color2;
	}

	public Color getColor3() {
		return color3;
	}

	public Color getColor4() {
		return color4;
	}

}
