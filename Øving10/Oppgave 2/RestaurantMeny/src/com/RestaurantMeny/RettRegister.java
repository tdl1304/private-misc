package com.RestaurantMeny;

import java.util.Arrays;

/**
 * Registrerer for alle retter
 *
 * @author tommyluu
 * @see com.RestaurantMeny.Rett
 */
public class RettRegister {
    private Rett[] retter;

    /**
     * tom liste
     */
    public RettRegister() {
        retter = new Rett[0];
    }

    /**
     * oppretter og legger til en rett i registeret
     *
     * @param navn navn paa rett
     * @param type type rett
     * @param pris pris paa rett
     */
    public void nyRett(String navn, String type, double pris) {
        retter = Arrays.copyOf(retter, retter.length + 1);
        retter[retter.length - 1] = new Rett(navn, type, pris);
    }

    /**
     * Sorterer listen etter type
     */
    public void sorter() {
        Arrays.sort(retter);
    }

    /**
     * Finn en rett i registeret med navnet
     *
     * @param navn navn paa rett som skal finnes
     * @return Rett returnerer objekt av Rett klassen, hvis navn ikke er funnet, returneres null objekt.
     * @throws IllegalArgumentException Dersom objektet av Rett ikke eksisterer
     */
    public Rett getRett(String navn) {
        for (Rett r : retter
        ) {
            if (r.getNavn().equalsIgnoreCase(navn)) {
                return r;
            }

        }
        throw new IllegalArgumentException("Finner ikke angitt rett");
    }

    /**
     * finner en liste med type retter, gitt at lista er sortert
     * @param type en string for typen som skal finnes
     * @return Rett[] liste med retter
     * */
    public Rett[] finnTypeRetter(String type) {
        int ovreIndex = 0;
        int nedreIndex = 0;
        for (int ovre = retter.length - 1; ovre > 0; ovre--) {
            if (retter[ovre].getType().equalsIgnoreCase(type)) {
                ovreIndex = ovre;
                break;
            }
        }

        for (int nedre = 0; nedre < retter.length; nedre++) {
            if (retter[nedre].getType().equalsIgnoreCase(type)) {
                nedreIndex = nedre;
                break;
            }
        }
        Rett[] output = Arrays.copyOfRange(retter, nedreIndex, ovreIndex+1);
        return output;
    }

    /**
     * Atributter for Rett objektene i lista
     *
     * @return output toString metode
     */
    @Override
    public String toString() {
        String output = "";
        for (Rett r : retter
        ) {
            output += r.toString() + "\n";
        }
        return output;
    }
}
