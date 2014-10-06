package timer.oscillator;

public class ONTask implements Runnable {
	private LockState lock;

	public ONTask(LockState lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			if (lock.get() == OscilationState.ON) {
				lock.runON();
				lock.switchMe();
			} else {
				Thread t = new Thread(new OffTask(lock));
				t.start();
			}
		}
	}
}
