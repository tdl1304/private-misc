import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.utility.Delay;
public class helloworld {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Delay.msDelay(1000);
		Button.waitForAnyEvent();
		Motor.A.forward();
		Motor.A.backward();
		Motor.A.stop();
		LCD.drawString("Stopping", 0, 0);
		
		
		
		
	}

}
