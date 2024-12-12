package race;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TimeLabel extends JLabel {

	public TimeLabel(String seconds, Color color, int vertical) {
		setSize(500, 45);
		setFont(new Font("", Font.BOLD, 40));
		setText(seconds + " segundos!!!!");
		setForeground(color);
		setLocation(100, vertical);

	}

}
