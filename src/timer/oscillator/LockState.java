package timer.oscillator;

public class LockState {
	private OscillatingTask taskON;
	private OscillatingTask taskOFF;

	LockState(OscillatingTask taskON, OscillatingTask taskOFF) {
		this.taskON = taskON;
		this.taskOFF = taskOFF;
	}

	private OscilationState state = OscilationState.ON;

	void switchMe() {
		if (state == OscilationState.ON) {
			state = OscilationState.OFF;
		} else {
			state = OscilationState.ON;
		}
	}

	OscilationState get() {
		return state;
	}

	void runON() {
		taskON.run();
	}

	void runOFF() {
		taskOFF.run();
	}
}