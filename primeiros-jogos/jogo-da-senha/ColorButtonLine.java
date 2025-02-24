import java.util.ArrayList;
import javax.swing.JFrame;

public class ColorButtonLine {
	
	ArrayList<ColorButton> colorsLine = new ArrayList<ColorButton>();


	public ColorButtonLine(int x, int y, JFrame screen) {


		ColorButton c1 = new ColorButton(x, y, screen);
		colorsLine.add(c1);
		
		ColorButton c2 = new ColorButton(x + 60, y, screen);
		colorsLine.add(c2);

		ColorButton c3 = new ColorButton(x + 120, y, screen);
		colorsLine.add(c3);

		ColorButton c4 = new ColorButton(x + 180, y, screen);
		colorsLine.add(c4);

	}
	
	
}
