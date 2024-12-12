package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class VerifyButton extends JButton {

	Answer answer = new Answer();
	int line = 0;

	public VerifyButton(ColorButton[] colorsButton, ColorButtonLine[] colorsLine) {
		setText("Verificar");
		setSize(200, 70);
		setBackground(Color.lightGray);
		setFont(new Font("", Font.BOLD, 40));

		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (line < 8) {

					for (int i = 0; i < 4; i++) {
						colorsLine[line].colorsLine.get(i).setBackground(colorsButton[i].getBackground());

						if (colorsButton[i].getBackground() == answer.colors[i]) {
							colorsButton[i].setEnabled(false);
							colorsButton[i].setBackground(answer.colors[i]);
							continue;

						} else if (colorsButton[i].getBackground() == answer.getColor1()
								| colorsButton[i].getBackground() == answer.getColor2()
								| colorsButton[i].getBackground() == answer.getColor3()
								| colorsButton[i].getBackground() == answer.getColor4()) {

							colorsLine[line].colorsLine.get(i).setText("O");
							continue;

						} else {
							colorsLine[line].colorsLine.get(i).setText("X");

						}

					}

					line++;
				} else {
					setEnabled(false);
				}
			}
		});

	}

}
