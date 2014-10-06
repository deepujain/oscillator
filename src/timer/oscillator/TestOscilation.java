package timer.oscillator;

import java.util.concurrent.TimeUnit;

public class TestOscilation {
	public static void main(String[] args) {
		Oscillator o = new Oscillator();
		OscillatingTask taskON = new OscillatingTask() {
			@Override
			public void run() {
				System.out.println("ON");
			}
		};
		
		OscillatingTask taskOFF = new OscillatingTask() {
			@Override
			public void run() {
				System.out.println("OFF");
			}
		};

		o.start(taskON, taskOFF, 3, TimeUnit.SECONDS);
	}
}