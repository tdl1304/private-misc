/*

SekToTime
Programmet skal omgjøre sekunder om til timer, minutter og sekunder

*/
import java.util.*;
	
class SekToTime {
	public static void main(String[] args) {
		
		final int chs = 3600; //conversion rate between hours to seconds
		final int cms = 60; //conversion rate between minutes to seconds
		Scanner in = new Scanner(System.in);
		
		System.out.println("Antall sekunder(avrundet heltall):"); //bruker skriver inn data
		int sek = in.nextInt();
		
		int timer = sek/chs; //regner timer med heltalsdivisjon
		int min = (sek-(timer*chs))/cms; // regner gjenstående minutter med heltalsdivisjon
		int sekRest = sek-(timer*chs)-(min*cms); // regner gjenstående sekunder
		
		
		if( sek < 0) { //hvis tiden er mindre enn 0 -> feilmelding
			System.out.println("Ugyldig(e) tid(er)!(negativ)");
		} else if (timer == 0 && min == 0){			// Hvis tiden er under 60sek vil tiden bli angitt i sekunder
			
			System.out.println("Dette tilsvarer "+sekRest+" sekund(er)."); 
		} else if (timer == 0) {				// Hvis tiden er under 3600sek vil tiden bli angitt i minutter og sekunder
			System.out.println("Dette tilsvarer "+min+" minutt(er) og "+sekRest+" sekund(er).");
			
		} else {		//Hvis tiden er over 3600sek vil tiden bli angitt i både timer, minutter og sekunder.
			System.out.println("Dette tilsvarer "+timer+" time(r), "+min+" minutt(er) og "+sekRest+" sekund(er).");
		}
	}
}
	