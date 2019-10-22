package com.RestaurantMeny;

import java.util.Arrays;

/**
 * Registrerer restaurant menyer
 *
 * @author tommyluu
 * @see com.RestaurantMeny.Rett
 * @see com.RestaurantMeny.RettRegister
 */
public class Meny implements Comparable {
    private Rett[] meny;
    private String navn;

    /**
     * returnerer navn
     *
     * @return navn en string
     */
    public String getNavn() {
        return navn;
    }

    /**
     * Lager en tom meny
     * @param navn navn paa menyen
     */
    public Meny(String navn) {
        this.navn = navn;
        meny = new Rett[0];
    }

    /**
     * Lager en ferdigstilt 3 - retters meny
     *
     * @param navn navn paa menyen
     * @param forrett   forretten
     * @param hovedrett hovedretten
     * @param dessert   desserten
     */
    public Meny(String navn, Rett forrett, Rett hovedrett, Rett dessert) {
        this.navn = navn;
        meny = new Rett[3];
        meny[0] = forrett;
        meny[1] = hovedrett;
        meny[2] = dessert;
    }

    /**
     * Tilfoyer ny rett til eksisterende meny
     *
     * @param rett Retten som skal legges til i menyen
     */
    public void leggTilRett(Rett rett) {
        meny = Arrays.copyOf(meny, meny.length + 1);
        meny[meny.length - 1] = rett;
    }

    /**
     * gir totalsum paa hele menyen
     *
     * @return sum (double) totalpris paa menyen
     */
    public double totalPris() {
        double sum = 0;
        for (Rett r : meny
        ) {
            sum += r.getPris();
        }
        return sum;
    }

    /**
     * to string metode
     *
     * @return output en string
     */
    @Override
    public String toString() {
        String output = "";
        for (Rett r : meny
        ) {
            output += r.toString() + "\n";
        }
        return output;
    }

    /**
     * Sorterer menyer basert paa totalpris
     *
     * @param o objekt av Meny klassen
     * @return int -1,0,1 ettersom totalpris er storre eller lavere
     */
    @Override
    public int compareTo(Object o) {
        Meny that = (Meny) o;
        if (this.totalPris() > that.totalPris()) {
            return 1;
        } else if (this.totalPris() == that.totalPris()) {
            return 0;
        } else return -1;
    }

}
