package commons;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class NavigationButton extends JButton {

	public NavigationButton(String buttonText, int x, int y, int w, int h) {
		setText(buttonText);
		setFont(new Font("Arial", Font.BOLD, 40));
		setBounds(x, y, w, h);
		setBackground(new Color(250, 250, 250));
	}
}
