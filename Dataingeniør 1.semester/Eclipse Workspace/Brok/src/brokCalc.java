
public class brokCalc {

	public static void main(String[] args) {
		
		Brok brok1 = new Brok(1,2);
		Brok brok2 = new Brok(2);
		
		brok1.getMulti(brok2);
		brok2.getSum(brok1);
		brok2.getDiv(brok1);
		
		System.out.println("brøk1:"+brok1.toString()); 
		System.out.println("brøk2:"+brok2.toString()); 
		
		
		
		
	}//main

}//class
