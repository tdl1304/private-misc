package com.RestaurantMeny;

/**
 * Klassen for retter
 *
 * @author tommyluu
 * @see java.lang.Comparable
 */
public class Rett implements Comparable {
    private String navn;
    private String type;
    private double pris;

    /**
     * Ny rett
     *
     * @param navn navn paa rett
     * @param type type rett
     * @param pris pris paa rett
     */
    public Rett(String navn, String type, double pris) {
        this.navn = navn;
        this.type = type;
        this.pris = pris;
    }

    /**
     * returnerer navn
     *
     * @return navn string med navn paa rett
     */
    public String getNavn() {
        return navn;
    }

    /**
     * returnerer type
     *
     * @return type type rett
     */
    public String getType() {
        return type;
    }

    /**
     * returnerer pris
     *
     * @return pris pris paa rett
     */
    public double getPris() {
        return pris;
    }

    /**
     * compareTo metode for retter, ser kun paa attributten "type"
     *
     * @param o et Rett objekt
     * @return -1, 0 eller 1
     */
    @Override
    public int compareTo(Object o) {
        Rett that = (Rett) o;
        if (this.getType().equalsIgnoreCase(that.getType())) {
            return 0;
        } else {
            return this.getType().compareToIgnoreCase(that.getType());
        }
    }

    /**
     * egendefinert toString metode
     *
     * @return String attributter for retten
     */
    @Override
    public String toString() {
        return getNavn() + ", " + getType() + ", " + getPris();
    }
}
