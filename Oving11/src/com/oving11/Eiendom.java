package com.oving11;

/**
 * Klasse for Eiendom-objektet
 * Inneholder nodvendig informasjon om en eiendom i Norge
 * @author tommyluu
 */
public class Eiendom {
    private int kommunenr;
    private String kommunenavn;
    private int gnr;
    private int bnr;
    private String navn;
    private String eier;
    private double areal;

    /**
     * Konstruktor for Eiendom
     * @param kommunenr kommunenummeret maa vere et tall fra 101 t.o.m. 5054
     * @param kommunenavn navn på kommune
     * @param gnr gaardsnummer
     * @param bnr bruksnummer
     * @param navn navn paa eiendom
     * @param eier eier av eiendom
     * @param areal kvadratmeter (m2)
     */
    public Eiendom(int kommunenr, String kommunenavn, int gnr, int bnr, String navn, String eier, double areal) {
        if(kommunenr >= 101 && kommunenr <= 5054) {
            this.kommunenr = kommunenr;
        } else throw new IllegalArgumentException("ugyldig kommunenr");
        this.kommunenavn = kommunenavn;
        this.gnr = gnr;
        this.bnr = bnr;
        this.navn = navn;
        this.eier = eier;
        this.areal = areal;
    }

    /**
     * Ved endring av navn på eiendommen
     * @param navn Navn på eiendom
     */
    public void setNavn(String navn) {
        this.navn = navn;
    }

    /**
     * Ved eierskifte
     * @param eier Navn på eier
     */
    public void setEier(String eier) {
        this.eier = eier;
    }

    /**
     * Ved videre utbygging av tomt
     * @param areal Areal på eiendommen
     */
    public void setAreal(double areal) {
        this.areal = areal;
    }

    public int getKommunenr() {
        return kommunenr;
    }

    public String getKommunenavn() {
        return kommunenavn;
    }

    public int getGnr() {
        return gnr;
    }

    public int getBnr() {
        return bnr;
    }

    public String getNavn() {
        return navn;
    }

    public String getEier() {
        return eier;
    }

    public double getAreal() {
        return areal;
    }
    //toString metode som gir ut streng etter onskede format i oppgaveteksten
    @Override
    public String toString() {
        String output = "";
        output = getKommunenr()+"-"+getGnr()+"/"+getBnr();
        return output;
    }
}
