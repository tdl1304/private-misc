import java.util.ArrayList;
import java.util.List;
public class tekstanalyse {

	private String tekst;
	private int[] tabell;


	public tekstanalyse(String tekst) {
		this.tekst = tekst;
		
	}
	
	//henter ut antallTegn tabellen
	public int[] getTabell() {
		return tabell;
	}
	
	//setter listen for antallTegn tabell
	public void setTabell(int[] array) {
		this.tabell = array;
	}
	
	//fyller ut indextabell med type- og antall tegn
	public int[] fyllTabell() {
		tekst = tekst.toUpperCase();
		int[] antallTegn = new int[30];
		int[] typeOgAntall = new int[2];
		
		while(tekst.length() > 0) {
			char ch = tekst.charAt(0);
			typeOgAntall[0] = convertIndex(ch); //angir index for tegntypen
			typeOgAntall[1] = charCount(ch, tekst); //teller antall av tegnet
			antallTegn[typeOgAntall[0]] = typeOgAntall[1];
			tekst = tekst.replace(""+ch, "");
		}
		return antallTegn;
	}
	
	//tar en char og gir index f.o.m. 0 til 29.
	public int convertIndex(char ch) {
		int index;
		if (ch <= 90 && ch >= 65) {//tester om indexen tilsvarer A-Z
			index = ch-65;
			return index;
		} else if (ch == 197) { //tester om indexen er 'Å'
			return 28;
		} else if (ch == 198) { //tester om index er 'Æ'
			return 27;
		} else if (ch == 216) { //tester om index er 'Ø'
			return 26;
		} else {
			return 29; //index nr er 29 dersom det ikke er en bokstav
		}
			
	}
	
	//reverserer convertIndex
	public char rConvertIndex(int index) {
		int resultat;
		char ch;
		if (index <= 25 && index >= 0) {//tester om indexen tilsvarer A-Z
			resultat = index+65;
			ch = (char) resultat;
			return ch;
		} else if (index == 28) { //tester om indexen er 'Å'
			ch = 'Å';
			return ch;
		} else if (index == 27 ) { //tester om index er 'Æ'
			ch = 'Æ';
			return ch;
		} else if (index == 26) { //tester om index er 'Ø'
			ch = 'Ø';
			return ch;
		} else return '0';
	}
	
	//teller antallet av én type char i hele strengen
	public int charCount(char ch, String str) {
		int count = 0;
		String copyStr = str;
		while(copyStr.indexOf(ch) != -1) { //sjekker om char eksisterer i teksten
			count++;
			copyStr = copyStr.substring(copyStr.indexOf(ch)+1); //forkorter setningen med ett tegn
		}
		return count;
	}
	
	//antall forskjellige bokstaver
	public int diffBokstav() { 
		int count = 0;
		for(int i = 0; i < tabell.length-1; i++) {
			if(tabell[i] > 0) {
				count++;
			}
		}
		return count;
	}
	
	//finner antall bokstaver
	public int sumBokstav() {
		int sum = 0;
		for(int i = 0; i < tabell.length-1; i++) {
			sum = sum + tabell[i];
		}
		return sum;
	}
	
	//gir prosentandel av spesialtegn
	public double prosentIkkeBokstav() {
		double teller = tabell[29];
		double nevner = this.sumBokstav()+tabell[29];
		return 100*teller/nevner;
	} 
	
	//gir antall av en type bokstav
	public int antallAvBokstav(String bokstav) {
		bokstav = bokstav.toUpperCase();
		char ch = bokstav.charAt(0);
		int index = convertIndex(ch);
		if (index == 29) {
			throw new IllegalArgumentException("Ikke gyldig bokstav");
		} else {
		return tabell[index];
		}
	}

	//gir mest frekvente bokstav
	public char[] frekventBokstav() {
		int maxValue = 0;
		List<Integer> bokstavIndex = new ArrayList<Integer>();
		//finner bokstaven med størst forekomst av alle bokstavene
		for(int i = 0; i < tabell.length-1; i++) {
			if( maxValue < tabell[i]) {
				maxValue = tabell[i];		
			}
		}
		//legger indexen på maxValue bokstavene i lista
		for(int k = 0; k < tabell.length-1;k++) {
			if(maxValue == tabell[k]) {
				bokstavIndex.add(k);
			}
		}
		//konverterer ArrayList til array
		Integer[] bokstavIndexArray = bokstavIndex.toArray(new Integer[bokstavIndex.size()]);
		char[] bokstaver = new char[bokstavIndexArray.length];
		for(int j = 0; j < bokstavIndexArray.length; j++) {
			bokstaver[j] = rConvertIndex(bokstavIndexArray[j]);
		}
		
		return bokstaver;
	}
	
	public String frekventString() {
		char[] bokstaver = frekventBokstav();
		String bokstavString = "";
	
		for(Character x: bokstaver) {
			bokstavString += x+", ";
		}
		//trimmer av siste kommaet
		bokstavString = bokstavString.substring(0, bokstavString.length()-2);
		return bokstavString;
	}
}//class
