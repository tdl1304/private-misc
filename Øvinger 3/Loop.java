//Programmet viser en gangetabell mellom tall som har 2 i differanse som er multiplisert med tall opptil 10
//Brukeren skal angi grensene for lista. F.eks 13-15, og 5-7.
import java.util.*;
class Loop {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Tast inn valgfritt tall (nedre grense): ");
		int lownum = in.nextInt();	
		System.out.println("Tast inn en faktor (nedre grense): ");
		int lowfaktor = in.nextInt();	
		
		System.out.println("Tast inn øvre grense: ");
		int bignum = in.nextInt();		
		System.out.println("Tast inn en faktor (øvre grense)" );
		int bigfaktor = in.nextInt();	
		/*
		if(lownum < 0 || bignum < 0 || 10 < bigfaktor || 10<lowfaktor|| bigfaktor<0||lowfaktor<0) { //Begrenser brukeren fra å taste feil
			System.out.println("Tallene du har tastet inn oppfyller ikke kravene!");
			System.exit(1);
		}
		
		int lownum2 = 0;
		int i = 0;
		
		
			if(lownum == bignum) { //Sjekker om nedre og øvre grense er like
			for(i = lowfaktor; i < bigfaktor+1; i++) {
				System.out.printf(lownum+" * "+i+" = "+i*lownum+"%n"); //gir en liste basert på laveste faktor og høyeste faktor.
				} 
			}		
			
				else if(lownum != bignum) {
			
					for(i = lowfaktor; i < 11; i++) { //Første rekken med tall som starter fra variabelen lowfaktor
						System.out.printf(lownum+" * "+i+" = "+i*lownum+"%n");
					}
				
				}
				
					
						lownum++; //Øker verdien av lownum med 1 for å teste om det finnes et tall som er 1 større
						if(bignum == lownum) { //lownum har nå verdi +1, og vi tester om den er den største.
							for(i = 1; i < bigfaktor+1; i++) {
								System.out.printf(lownum+" * "+i+" = "+i*lownum+"%n"); //gir en rekke dersom faktoren er øvre grensa
							}
						} else if(bignum > lownum) {
							for(i = 1; i < 11; i++) {
							System.out.printf(lownum+" * "+i+" = "+i*lownum+"%n"); //gir en full rekke dersom det finnes en høyere grenseverdi
							}
						
						  } lownum2 = lownum+1; //EDIT dette er for å skille mellom logiske uttrykk i linje 13 og 42.
						 
					
					
					if(lownum2 == bignum) {
						for(i = 1; i < bigfaktor+1; i++) { //Gir den siste rekken av gangetabellen dersom øvregrense er 2 større enn laveste-.
						System.out.printf(lownum2+" * "+i+" = "+i*lownum2+"%n");
						
		 				} 	
				
					}*/
		for(int i=lownum; i <=lownum; i++ ) { //gir første rekka av gangetabell
			for(int j=lowfaktor; j <= 10; j++) {
				System.out.printf(
					i+" * "+j+" = "+j*i+"%n");
			}
		
		}
		
		for(int i = lownum+1; i <= bignum-1; i++) { //gir gangetabell for alt mellom nedre og øverste grense
			for(int j=1; j <= 10; j++) {
				System.out.printf(
					i+" * "+j+" = "+j*i+"%n");
			}
		}
		
		for(int i = bignum; i <= bignum; i++) { //gir siste rekke av gangetabellen
			for(int j=1; j <= bigfaktor; j++) {
				System.out.printf(
					i+" * "+j+" = "+j*i+"%n");
			}
		}
			
		
			
	}
	
}
	

			

		
		

  


