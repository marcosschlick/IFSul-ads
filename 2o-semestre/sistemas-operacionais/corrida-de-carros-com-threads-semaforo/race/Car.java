package race;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Car extends JPanel {

	private int speed = 5;
	private ImageIcon image;

	public Car(Color color, int vertical) {
		this.image = new ImageIcon(
				"C:\\Users\\marcos\\eclipse-workspaces\\eclipse-workspace\\corrida-de-carros-com-threads-semafaro\\src\\images/car.png");
		setLocation(20, vertical);
		setBackground(color);
		setVisible(true);
		setBounds(20, vertical, image.getIconWidth(), image.getIconHeight());
	}

	public void addTurbo() {
		setSpeed(10);
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				setSpeed(5);
			}
		};
		timer.schedule(task, 100);
	}

	private void setSpeed(int speed) {
		this.speed = speed;
	}

	public void move() {
		this.setLocation(this.getX() + this.speed, this.getY());
		repaint();
		double turbo = Math.random() * 10;
		if (turbo > 9.5) {
			addTurbo();
		}
	}

	public boolean check(RaceScreen screen, String seconds) {
		if (this.getX() >= 650) {
			screen.addLabel(new TimeLabel(seconds, this.getBackground(), this.getY()));
			return false;
		}
		return true;

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image.getImage(), 0, 0, this);
	}
}
