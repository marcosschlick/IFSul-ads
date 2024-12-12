package game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Screen {

	public void execute() {

		JLabel titleLabel = new JLabel();
		titleLabel.setSize(600, 100);
		titleLabel.setText("Jogo da senha ");
		titleLabel.setLocation(0, 0);
		titleLabel.setFont(new Font("", Font.BOLD, 30));
		titleLabel.setHorizontalAlignment(0);
		
		JLabel helpLabel = new JLabel();
		helpLabel.setSize(600, 100);
		helpLabel.setText("'X', não tem essa cor");
		helpLabel.setLocation(420, 100);
		helpLabel.setFont(new Font("", Font.BOLD, 18));
		helpLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel helpLabel1 = new JLabel();
		helpLabel1.setSize(600, 100);
		helpLabel1.setText("'O', cor no lugar errado");
		helpLabel1.setLocation(420, 150);
		helpLabel1.setFont(new Font("", Font.BOLD,18));
		helpLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel helpLabel2 = new JLabel();
		helpLabel2.setSize(600, 100);
		helpLabel2.setText("'  ' acerto ");
		helpLabel2.setLocation(420, 200);
		helpLabel2.setFont(new Font("", Font.BOLD, 18));
		helpLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		JFrame screen = new JFrame();
		screen.setLayout(null);
		screen.setSize(640, 750);
		screen.setBackground(Color.WHITE);
		screen.setLocationRelativeTo(null);
		screen.setDefaultCloseOperation(3);
		screen.setFocusable(true);

		ColorButtonLine[] colorsLine = { new ColorButtonLine(180, 100, screen), new ColorButtonLine(180, 160, screen),
				new ColorButtonLine(180, 220, screen), new ColorButtonLine(180, 280, screen),
				new ColorButtonLine(180, 340, screen), new ColorButtonLine(180, 400, screen),
				new ColorButtonLine(180, 460, screen), new ColorButtonLine(180, 520, screen) };

		ColorButton[] colorsButton = { new ColorButton(50, 600), new ColorButton(125, 600), new ColorButton(200, 600),
				new ColorButton(275, 600) };

		VerifyButton verifyButton = new VerifyButton(colorsButton, colorsLine);
		verifyButton.setLocation(360, 600);

		for (ColorButton c : colorsButton) {
			screen.add(c);
		}

		screen.add(verifyButton);
		
		screen.add(helpLabel);
		screen.add(helpLabel1);
		screen.add(helpLabel2);

		

		screen.add(titleLabel);

		screen.setVisible(true);
	}
}
