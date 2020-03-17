/*
sekunder
Programmet skal omgjøre timer og minutter til antall sekunder
*/
import java.util.*;
	
class sekunder {
	public static void main(String[] args) {
		
		final double chs = 3600.0; //conversion rate between hours to seconds
		final double cms = 60.0; //conversion rate between minutes to seconds
		Scanner in = new Scanner(System.in);
		
		System.out.println("Antall timer:"); //bruker skriver inn data
		double timer = in.nextDouble();
		
		System.out.println("Antall minutter:");
		double min = in.nextDouble();
		
		double sek = (timer*chs)+(min*cms); //gjør om angitt tid til sekunder
		
		if( timer < 0 || min < 0) { //hvis tiden er mindre enn 0 -> feilmelding
			System.out.println("Ugyldig(e) tid(er)!(negativ)");
		} else {
			
			System.out.printf("Dette tilsvarer omtrent %6.2f sekunder%n",sek);
		}
	}
}
	