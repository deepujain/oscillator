package timer.oscillator;

public class LockState {
	private OscillatingTask taskON;
	private OscillatingTask taskOFF;

	LockState(OscillatingTask taskON, OscillatingTask taskOFF) {
		this.taskON = taskON;
		this.taskOFF = taskOFF;
	}

	private OscilationState state = OscilationState.ON;

	public void switchMe() {
		if (state == OscilationState.ON) {
			state = OscilationState.OFF;
		} else {
			state = OscilationState.ON;
		}
	}

	public OscilationState get() {
		return state;
	}

	public void runON() {
		taskON.run();
	}

	public void runOFF() {
		taskOFF.run();
	}
}