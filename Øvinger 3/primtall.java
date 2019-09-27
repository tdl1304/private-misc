//Programmet sjekker om et tall er et primtall eller ikke
import java.util.*;
class primtall {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Tast inn et tall(positivt heltall):");
		//looper programmet
		while(true) { //Det er mange unntak ved de første tallene i rekka, mange av de er primtall
			int tall = in.nextInt();
				if (tall == 1) { 
					System.out.println("Tallet er ikke et primtall");
				}
				else if(tall == 2 || tall == 3 || tall == 5 || tall == 7) {
					System.out.println("Tallet er et primtall");
				}
				else if(tall%2 == 0 || tall%3 == 0 || tall%5 == 0 || tall%7 == 0) { //dersom et tall er delelig på disse, er det ikke et primtall.
					System.out.println("Tallet er ikke er primtall");
				} else {
					System.out.println("Tallet er et primtall");
				}
		}
		
		
	}
}
boolean a = false;

for(int i = 0; i < tall; i++) {
	if(tall%i == 0) {
		a = true;
	}
} 

if (a) {
	"primtall"
} else {
	"ikke pritmall"
}