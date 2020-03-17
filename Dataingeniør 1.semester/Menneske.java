class Menneske {
	public static void main(String[] args) {
		String navn1 = "Per";
		//Lager nytt menneske(GUD)
		Mennesker mann1 = new Mennesker(navn1, 14);
		Mennesker mann2 = new Mennesker("Pål", 15);
		
		//Dette funker ikke fordi attributten NAVN er private
		//System.out.println(mann1.navn);
		System.out.println(mann1.personlia()); //sender personlia
		System.out.println(mann2.personlia()+" "+mann2.klassetrinn()); //personlia
	}
}


class Mennesker {
	private String navn; //navn på mennesket
	private int alder;  //alder på mennesket
	
	//constructor eller konstruktør på norsk
	public Mennesker(String navn1, int alder1) {
		this.navn = navn1; //objektet får navnet navn1
		this.alder = alder1; //objektet får alderen alder1
	}
	//metode som henter ut navnet til objektet
	//merk at METODEN er private
	private String getNavn(int a){
		return navn;
	}
	//som getNavn, henter den ut alder
	//merk at METODEN er private
	private int getAlder() {
		return alder;
	}
	//gir en streng med personlia
	public String personlia() {
		return ""+getNavn()+","+getAlder();
	}
	//regner og gir ut klassetrinnet
	public int klassetrinn() {
		return 2019-(2019-alder)-5;
	}
}