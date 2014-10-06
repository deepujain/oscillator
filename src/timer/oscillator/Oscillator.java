package timer.oscillator;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Oscillator {
	/**
	 * Oscillates execution of tasks between taskON and taskOFF at a fixed rate
	 * of period. Tasks are scheduled using ScheduledExecutorService and hence
	 * individual tasks must catch any thrown unchecked exceptions.
	 * 
	 * @param taskON
	 *            Execution starts with this task
	 * @param taskOFF
	 *            Execution oscillates to this task after defined fixed peroid.
	 * @param period
	 *            oscillation rate.
	 * @param unit
	 *            oscillation rate unit.
	 * @see ScheduledExecutorService
	 */
	public void start(OscillatingTask taskON, OscillatingTask taskOFF,
			long period, TimeUnit unit) {
		LockState lock = new LockState(taskON, taskOFF);
		ScheduledExecutorService scheduledThreadPool = Executors
				.newScheduledThreadPool(1);
		scheduledThreadPool.scheduleAtFixedRate(new ONTask(lock), 1, period,
				unit);
	}
}
