package timer.oscillator;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Oscillator {
	public void start(OscillatingTask taskON, OscillatingTask taskOFF,
			long period, TimeUnit unit) {
		LockState lock = new LockState(taskON, taskOFF);
		ScheduledExecutorService scheduledThreadPool = Executors
				.newScheduledThreadPool(1);
		scheduledThreadPool.scheduleAtFixedRate(new ONTask(lock), 1, period,
				unit);
	}
}
