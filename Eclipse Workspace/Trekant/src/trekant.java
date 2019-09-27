import java.util.Scanner;;

public class trekant {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Hvor lang rekke vil du ha?");
		int a = input.nextInt();
		
		
		for (int i = 0; i <= a; i++) {
			for(int k = 1; k <= a-i;k++) { //
				System.out.print(" ");
			}
			
			for(int j = 1; j <= i; j++) {
				System.out.print("* ");

			}
			System.out.printf("%n");
		}

	}//main
	
}//class