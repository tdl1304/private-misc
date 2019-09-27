/*
InchesToCm
Programmet skal omgjøre tommer til centimeter
*/
import java.util.*;
	
class InchesToCM {
	public static void main(String[] args) {
		
		final double cr = 2.54; //conversion rate between inches and centimetres
		Scanner in = new Scanner(System.in);
		
		System.out.println("Angi lengde(inches):"); //brukeren taster inn lengde
		double inches = in.nextDouble();
		
		double cm = inches*cr; //regner om inches til cm
		
		if(cm < 0) { //lengden er ugylding om indata er negativt
			System.out.println("Lengden er ugyldig!(negativ)");
		} else {
			
			System.out.printf("Dette tilsvarer omtrent %6.2fcm%n",cm);
		}
	}
}
	