package timer.oscillator;

import java.util.concurrent.TimeUnit;

public class TestOscilation {
	public static void main(String[] args) {
		Oscillator o = new Oscillator();
		o.start(new OscillatingTask() {
			@Override
			public void run() {
				System.out.println("ON");
			}
		}, new OscillatingTask() {
			@Override
			public void run() {
				System.out.println("OFF");
			}
		}, 3, TimeUnit.SECONDS);
	}
}