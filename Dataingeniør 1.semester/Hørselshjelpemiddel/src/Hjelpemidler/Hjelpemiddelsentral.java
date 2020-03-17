package Hjelpemidler;

import java.util.ArrayList;

/**
 * Klassen for Hjelpemiddelsentral
 * gir en oversikt over ulike Hjelpemiddel og deres utleiestatus
 */
public class Hjelpemiddelsentral {
    private String navn;
    private ArrayList<Hjelpemiddel> liste;

    /**
     * Konstruktor for Hjelpemiddelsentral
     *
     * @param navn String navn paa hjelpemiddelsentralen
     */
    public Hjelpemiddelsentral(String navn) {
        this.navn = navn; //Navn paa hjelpemiddelsentral
        this.liste = new ArrayList<>(); //Initierer en tom ArrayList naar objektet konstrueres
    }

    /**
     * Aksessormetode for navn
     *
     * @return navn String navn paa hjelpemiddelsentralen
     */
    public String getNavn() {
        return navn;
    }

    /**
     * Aksessormetode for lista over hjelpemidler i form av en ArrayList
     *
     * @return liste ArrayList<Hjelpemiddel> liste over hjelpemidler
     */
    public ArrayList<Hjelpemiddel> getListe() {
        return liste;
    }

    /**
     * Finner hjelpemiddel basert paa id
     * @param id int id til hjelpemiddel
     * @return null eller objekt av Hjelpemiddel dersom det eksisterer
     */
    public Hjelpemiddel finnHjelpemiddel(int id) {
        for (Hjelpemiddel m : getListe() //foreach loop for aa sjekke id til alle objektene i lista
        ) {
            if (m.getId() == id) return m; //dersom id til objektet er lik id til parameteren, returneres objektet
        }
        return null; //dersom ingen objekt av gitt id er funnet returneres null
    }

    /**
     * Metode for aa legge til objekter av Hjelpemiddel
     *
     * @param o Hjelpemiddel objekt
     */
    public void leggTilHjelpemiddel(Hjelpemiddel o) {
        if (liste.contains(o)) { //sjekker om Hjelpemiddelet allerede eksisterer i registeret
            throw new IllegalArgumentException("Hjelpemiddel finnes allerede i registeret"); //kaster en IllegalArgumentException dersom hjelpemiddelet allerede eksisterer
        } else {
            liste.add(o); //dersom det ikke allerede finnes i registeret blir Hjelpemiddelet lagt til i sentralen
        }
    }

    /**
     * Registrere ny leier til et hjelpemiddel
     *
     * @param leier String navn paa leier
     * @param o     Hjelpemiddel objekt av Hjelpemiddel
     */
    public void startUtleie(String leier, Hjelpemiddel o) {
        Hjelpemiddel utleie; //initierer objekt av Hjelpemiddel
        if (liste.contains(o)) { //sjekker at Hjelpemiddelet finnes i registeret
            utleie = liste.get(liste.indexOf(o)); //dersom objekt eksisterer blir utleie-objektet en referanse til objektet i lista.
        } else
            throw new IllegalArgumentException("Hjelpemiddel finnes ikke i registeret"); //feilmelding dersom Hjelpemiddelet ikke finnes
        if (!utleie.getUtleiestatus()) { //Dersom utleiestatus er false, kan Hjelpemiddelet leies ut til den nye leieren
            utleie.setLeier(leier); //setter ny leier paa hjelpemiddelet
            utleie.setUtleiestatus(true); //setter status paa utleie
        } else
            throw new IllegalArgumentException("Hjelpemiddelet er allerede utleid"); //dersom Hjelpemiddelet allerede er utleid kastes en IllegalArgumentException
    }

    /**
     * Registrere oppsigelser paa utleieforhold av hjelpemidler
     *
     * @param o Hjelpemiddel objekt
     */
    public void avsluttUtleie(Hjelpemiddel o) {
        if (liste.contains(o)) { //sjekker om hjelpemiddelet eksisterer i lista, sann dersom den gjor det
            Hjelpemiddel utleie = liste.get(liste.indexOf(o)); //initierer midlertidig objekt som referanse til objektet i lista
            utleie.setLeier(""); //setter leier navn tomt
            utleie.setUtleiestatus(false); //setter utleiestatus til ledig altsaa false
        } else
            throw new IllegalArgumentException("Hjelpemiddel finnes ikke i registeret"); //feilmelding dersom hjelpemiddelet ikke eksisterer i lista
    }

    /**
     * Metode som finner alle ledige hjelpemidler av gitt type
     *
     * @param type String type paa hjelpemiddel
     * @return ledigeHjelpemidler String tekstreng med oversikt over ledige hjelpemidler av gitt type
     */
    public String finnLedigeAvGittType(String type) {
        String ledigeHjelpemidler = ""; //initierer en tom streng
        for (Hjelpemiddel m : getListe()) { //foreach loop som gaar gjennom alle objekter av Hjelpemiddel i lista
            if (!m.getUtleiestatus() && m.getType().equals(type)) { //dersom hjelpemiddelet er ledig og har gitt type er if-setningen sann
                ledigeHjelpemidler += m.toString() + "\n"; //legger til funnet objekt sin toString i en tekststreng med en newline
            }
        }
        return ledigeHjelpemidler; //returnerer oversikt over ledige hjelpemidler av gitt type
    }

    /**
     * Gir en streng med informasjon om alle hjelpemidlene i Hjelpemiddelsentralen
     *
     * @return output String tekst med informasjon om hjelpemidlene
     */
    @Override
    public String toString() {
        String output = ""; //initierer en tom tekststreng
        for (Hjelpemiddel m : getListe()) { //bruker en foreach loop til aa gaa gjennom alle hjelpemidlene i register lista
            output += m.toString() + "\n"; //objektets toString metode blir lagt til i output-strengen etterfulgt av en ny linje
        }
        return output; //returnerer en tekststreng med info om alle hjelpemidlene i registeret
    }
}


