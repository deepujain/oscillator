package timer.oscillator;

public class OffTask implements Runnable {
	private LockState lock;

	public OffTask(LockState lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			if (lock.get() == OscilationState.OFF) {
				lock.runOFF();
				lock.switchMe();
			}
		}
	}
}

