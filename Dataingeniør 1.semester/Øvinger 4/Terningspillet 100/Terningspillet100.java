/*
Terningspillet 100
er et spill der 2 spillere konkurrerer om å summere terningkastene til summen = 100.
Spesial regel: Dersom terningen viser 1, blir totalsummen opptil nå lik 0
*/
import java.util.Random;
class Terningspillet100 {
	public static void main(String[] args) {
		Spiller a = new Spiller("A"); //konstruerer spillere
		Spiller b = new Spiller("B");
		int i = 1;
		
		while(true) {
			a.kastTerning();
			System.out.println(
				"Spiller "+a.getNavn()+" - Runde "+i+" - Sum: "+a.getSumPoeng());
			if(a.erFerdig()) {
				System.out.println(a.getNavn()+" har vunnet");
				break;
			}
			
			b.kastTerning();
			System.out.println(
				"Spiller "+b.getNavn()+" - Runde "+i+" - Sum: "+b.getSumPoeng());
			if(b.erFerdig()) {
				System.out.println(b.getNavn()+" har vunnet"); 
				break;
			}
			i++;
		}
		
	}//main
	
}//class



class Spiller { //egenskaper til spillere
	private int sumPoeng;
	private String navn;
	private int terningKast;
	
	public Spiller(String n) {
		this.navn = n;
	}
	
	public String getNavn() {
		return this.navn;
	}

	
	public int getSumPoeng() { //gir sum for én runde fra summen av forrige sum + terningkast
		return this.sumPoeng;
	}
	
	public void kastTerning() { //simulerer et terningkast
		Random terning = new Random();
		this.terningKast = 1+terning.nextInt(6);
		/*if (this.sumPoeng > 100) {	//fjern kommentarer dersom raffinert versjon ønskes
			this.sumPoeng = this.sumPoeng - this.terningKast; //når summen er over 100, vil terningkastet blir summen redusert med terningkastet.
		} else {*/
			this.sumPoeng = this.sumPoeng+terningKast;
		 // }
		if (this.terningKast == 1) { //dersom terninga viser 1 blir summen lik 0
			this.sumPoeng = 0;
		}
	}
	
	public boolean erFerdig() {
		if(this.sumPoeng >= 100) {
			return true;
		} else return false;
		
 	}
}