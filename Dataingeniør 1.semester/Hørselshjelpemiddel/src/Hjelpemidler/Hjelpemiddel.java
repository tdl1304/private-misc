package Hjelpemidler;

/**
 * Klassen for hjelpemiddel
 * inneholder informasjon om hjelpemidlene
 */
public class Hjelpemiddel implements Comparable<Hjelpemiddel> {
    private int id;
    private String type;
    private boolean utleiestatus;
    private String leier;

    /**
     * Konstruktor for Hjelpemiddel
     *
     * @param id           int mellom 1001 og 9999
     * @param type         String som beskriver type hjelpemiddel
     * @param utleiestatus boolean som har utleiestatus
     * @param leier        String med navn på leier
     */
    public Hjelpemiddel(int id, String type, boolean utleiestatus, String leier) {
        if (id < 1001 || id > 9999) { //Sjekker om id ikke er mellom 1001 og 9999
            throw new IllegalArgumentException("id er ikke mellom 1001 t.o.m. 9999"); //gir feil melding dersom id er ugyldig
        } else { //dersom gyldig id, blir id registrert paa hjelpemiddelet
            this.id = id; //angir id
        }
        this.type = type; //angir type
        this.utleiestatus = utleiestatus; //angir utleiestatus true dersom hjelpemiddelet er utleid
        this.leier = leier; //angir navn paa leier
    }

    /**
     * Aksessormetode for id
     *
     * @return id int med id
     */
    public int getId() {
        return id;
    }

    /**
     * Aksessormetode for type
     *
     * @return type String med type
     */
    public String getType() {
        return type;
    }

    /**
     * Aksessormetode for utleiestatus
     *
     * @return utleiestatus boolean om hjelpemiddelet er utleid
     */
    public boolean getUtleiestatus() {
        return utleiestatus;
    }

    /**
     * Aksessormetode for endring av utleiestatus
     *
     * @param utleiestatus boolean ny utleiestatus
     */
    public void setUtleiestatus(boolean utleiestatus) {
        this.utleiestatus = utleiestatus;
    }

    /**
     * Aksessormetode for leier sitt navn
     *
     * @return leier String med navn
     */
    public String getLeier() {
        return leier;
    }

    /**
     * Aksessormetode for aa endre leier
     *
     * @param leier String ny leier
     */
    public void setLeier(String leier) {
        this.leier = leier;
    }

    /**
     * Metode for aa sammenligne objekter
     * Like objekter er de som har lik id
     *
     * @param o Hjelpemiddel Et objekt av Hjelpemiddel klassen
     * @return compareStatus int med resultat av sammenligning, 0 for likt, 1 for storre og -1 for mindre
     */
    @Override
    public int compareTo(Hjelpemiddel o) {
        int compareStatus = 0;
        if (o.getId() == this.getId()) { //sjekker id paa dette objektet og objekt i parameter om det er likt
            compareStatus = 0; //sammenligning gir 0 naar begge id paa objektene er like
        } else if (o.getId() > this.getId()) { //sjekker om id til dette objektet er mindre enn parameterobjektet
            compareStatus = -1; //variabel blir -1 dersom id er lavere enn paramterobjektet
        } else { //dersom det ikke er likt eller mindre maa id-verdien paa dette objektet vere storre enn paramterobjektet
            compareStatus = 1; //variabel gir 1, da har dette objektet hoyere id-verdi enn parameterobjektet
        }

        return compareStatus; //returnerer sammenligning i form av et heltall
    }

    /**
     * Metode for aa faa en streng med informasjon
     *
     * @return output String med informasjon om hjelpemiddel
     */
    @Override
    public String toString() {
        String output = ""; //initierer en tom streng-variabel
        if (getUtleiestatus()) { //dersom hjelpemiddelet er utleid returneres en streng med id, type og leier
            output = getId() + " " + getType() + " utleid til " + getLeier();
        } else { //dersom hjelpemiddelet er ledig, returneres en streng med id og type
            output = getId() + " " + getType() + " ledig";
        }
        return output; //returnerer streng med informasjon om hjelpemiddel
    }


}
