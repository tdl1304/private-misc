//Programmet avgjør hva som er billigst mellom 2 varer

import java.util.*;

class Billigst {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in); //brukeren taster inn pris og ant. gram per vare
		System.out.println("Angi pris på vare 1:");
		double prisvare1 = in.nextDouble();
		System.out.println("Angi antall gram på vare 1:");
		double gramvare1 = in.nextDouble();
		
		System.out.println("Angi pris på vare 2:");
		double prisvare2 = in.nextDouble();
		System.out.println("Angi antall gram på vare 2:");
		double gramvare2 = in.nextDouble();
		
		double p1 = prisvare1/gramvare1; //finner kr per gram
		double p2 = prisvare2/gramvare2;
		
		if(prisvare1<=0||prisvare2<=0||gramvare1<=0||gramvare2<=0){ //sjekker at ingen av tallene er negative eller lik 0
			System.out.println("Ugyldige tall");
		}
		
		 else if(p1>p2 && p1 != p2){ //sammenligner pris per gram mellom varene, setningen er sann dersom vare 1 er dyrere
			System.out.println("Vare 2 er billigst");
		} else if(p1==p2){ //sjekker om varene har like pris
			System.out.println("Varene er like rimelige!");	
		} else {
			System.out.println("Vare 1 er billigst");
		}
	}
}