package race;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

public class CarThread extends Thread {
	private Timer timer = new Timer();
	private long start;

	public CarThread(Car car, RaceScreen raceScreen, Semaphore semaphore) {

		try {
			semaphore.acquire();
			start = System.nanoTime();

			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					long end = System.nanoTime();

					long durationNano = end - start;
					double durationMs = durationNano / 1_000_000.0;
					DecimalFormat df = new DecimalFormat("#.##");
					String duracaoFormatada = df.format(durationMs / 1000.0);

					if (car.check(raceScreen, duracaoFormatada)) {
						car.move();
					} else {
						this.cancel();
						semaphore.release();
					}
				}
			};
			timer.scheduleAtFixedRate(task, 0, 50);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
