package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ColorButton extends JButton {

	private ArrayList<Color> colors = new ArrayList<Color>();
	private int colorNumber = 0;

	public ColorButton(int x, int y, JFrame screen) {

		setHorizontalAlignment(CENTER);
		setFont(new Font("", Font.BOLD, 20));
		

		setSize(50, 50);
		setLocation(x, y);
		setBackground(Color.lightGray);
		setEnabled(false);

		screen.add(this);

	}

	public ColorButton(int x, int y) {
		colors.add(Color.black);
		colors.add(Color.red);
		colors.add(Color.blue);
		colors.add(Color.green);
		colors.add(Color.pink);
		colors.add(Color.yellow);
		colors.add(Color.orange);

		setHorizontalAlignment(CENTER);

		setSize(70, 70);
		setLocation(x, y);

		setBackground(colors.getFirst());

		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (colorNumber == 6) {
					colorNumber = 0;

				} else {
					colorNumber++;
				}
				setBackground(colors.get(colorNumber));
			}
		});

	}

}