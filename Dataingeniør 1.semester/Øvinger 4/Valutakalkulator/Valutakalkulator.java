//Programmet er en valutakalkulator for omgjøring av USD, EURO og YEN til NOK.
import java.util.*;
class Valutakalkulator {
	public static void main(String[] args) {
		Valuta usd = new Valuta(8.9585,"$"); //konstruerer valutaer og dets conversion rate
		Valuta euro = new Valuta(10.0698, "€");
		Valuta yen = new Valuta(0.084989, "¥");
		
		Scanner in = new Scanner(System.in); //Får input fra brukeren
		System.out.printf(
			"Velg valuta: %n1. Amerikanske dollar%n2. Euro%n3. Japanske Yen%n"); 
		int a = in.nextInt();
		System.out.println("Angi mengde:");
		double i = in.nextDouble();
		
		switch(a) { //Valgmenyen bestemmer hvilken valuta man regner med, kaller funksjonen omregning() fra class Valuta
			case 1:
			System.out.printf(i+usd.getName()+" tilsvarer %5.2fkr%n %5.2f usd", usd.omregningTil(i), usd.omregningFra(i));
				break;
		
		
			case 2: 
			
				break;
		
		
			case 3:
			
				
		default: 
			
		}//switch
		
	} //main
	
} //class


class Valuta {
	private double cr; //conversion rate
	private String name;
	
	public String getName() {
		return this.name;
	}
	
	public Valuta(double n1, String s1) { //bestemmer variablene med argumenter
		this.cr = n1;
		this.name = s1;
	}
	
 	public double omregningTil(double n1) { //regner om på valuta og printer ut til terminalen
		return n1*this.cr;
	}
	public double omregningFra(double n1) {
		return n1/this.cr;
	}
}