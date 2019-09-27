/*
|........................................|
|Programmet avgjør om året er et skuddår |
|........................................|
*/
import java.util.*;

class Skuddår {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Angi et årstall:");
		int år = in.nextInt(); //tar inn data fra brukeren
			
		if(år%100 == 0 && år%400 == 0 && år) { //sjekker om året er delelig på 100 og 400
			System.out.println("Året er et skuddår");
				
			} else if(år%4 == 0 && år%100 != 0) { //sjekker om det er delelig på 4 og ikke 100
				System.out.println("Året er et skuddår");
				} else { //Hvis ingen ting av øvrige er sant => ikke et skuddår
					System.out.println("Året er ikke et skuddår");
					}	
		
		}
}