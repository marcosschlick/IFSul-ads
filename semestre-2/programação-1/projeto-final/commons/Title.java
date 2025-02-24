package commons;
import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Title extends JLabel {
	
	public Title(String title) {
		setText(title);
		setFont(new Font("Arial", Font.BOLD, 70));
		setBounds(0, 50, 1200, 100);
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(TOP);
		}

}
