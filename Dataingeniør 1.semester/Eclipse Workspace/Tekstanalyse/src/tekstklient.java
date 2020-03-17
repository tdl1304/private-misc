import java.util.Scanner;
public class tekstklient {
	public static void main(String[] args) {
		//user input setup
		Scanner in = new Scanner(System.in);
		while(true) {
		System.out.println("Skriv inn tekst:");
		String essay = in.nextLine();
		System.out.println("Bokstav skal sjekkes:");
		String bokstav = in.nextLine();
		bokstav = bokstav.toUpperCase();
		
		//initialiserer objekter
		tekstanalyse targetBokstav = new tekstanalyse(bokstav);
		tekstanalyse tekst = new tekstanalyse(essay);
		
		//targetBokstav validering
		if(bokstav.length()>1) {
			throw new IllegalArgumentException("For mange tegn");
		} else if (targetBokstav.convertIndex(bokstav.charAt(0)) == 29) {
			throw new IllegalArgumentException("Dette er ikke en bokstav");
		}
		
		//tekstanalyse
		tekst.setTabell(tekst.fyllTabell());
		System.out.println("Mest brukte bokstav(er): "+tekst.frekventString());
		System.out.println("Antall typer bokstaver: "+tekst.diffBokstav());
		System.out.println("Antall av bokstaven "+bokstav+": "+tekst.antallAvBokstav(bokstav));
		System.out.println("Antall bokstaver i teksten: "+tekst.sumBokstav());
		System.out.printf("Andel tegn som ikke er bokstaver: %3.2f", tekst.prosentIkkeBokstav()); System.out.print("%"); 
		System.out.printf("%n%n");
		
		
		}//while
	}//main
	
}//class
