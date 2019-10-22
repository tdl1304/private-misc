package com.RestaurantMeny;

import java.util.Arrays;

/**
 * Meny registeret
 * Systematiserer menyer, retter, og rettregisteret for restauranten.
 *
 * @author tommyluu
 * @see Meny
 * @see RettRegister
 * @see Rett
 */
public class MenyRegister {
    private Meny[] menyRegister;
    private RettRegister rettRegister;

    /**
     * Konstruktor
     */
    public MenyRegister() {
        menyRegister = new Meny[0];
        rettRegister = new RettRegister();
    }

    /**
     * returnerer rettregisteret til bedriften
     *
     * @return RettRegister Objekt av rettregister som er registrert paa bedriften
     */
    public RettRegister getRettRegister() {
        return rettRegister;
    }

    /**
     * Finner spesifikt meny-objekt i registeret
     *
     * @param navn Navn paa meny som skal finnes
     * @return m Menyen
     * @throws IllegalArgumentException dersom menyobjektet ikke blir funnet
     */
    public Meny getMeny(String navn) {
        for (Meny m : menyRegister
        ) {
            if (m.getNavn().equalsIgnoreCase(navn)) {
                return m;
            }
        }
        throw new IllegalArgumentException("Finner ikke angitt meny");
    }

    /**
     * Lager ny meny som er tom
     *
     * @param navn navn paa menyen
     */
    public void nyMeny(String navn) {
        menyRegister = Arrays.copyOf(menyRegister, menyRegister.length + 1);
        menyRegister[menyRegister.length - 1] = new Meny(navn);
    }

    /**
     * Lager ny meny som inkluderer flere retter
     *
     * @param navn      navn paa meny
     * @param forrett   forretten av objekt Rett
     * @param hovedrett hovedretten av objekt Rett
     * @param dessert   desserten av objekt Rett
     */
    public void nyMeny(String navn, Rett forrett, Rett hovedrett, Rett dessert) {
        menyRegister = Arrays.copyOf(menyRegister, menyRegister.length + 1);
        menyRegister[menyRegister.length - 1] = new Meny(navn, forrett, hovedrett, dessert);
    }

    /**
     * Legger til eksisterende meny i registeret
     *
     * @param meny en meny av objektet Meny
     */
    public void leggTilMeny(Meny meny) {
        menyRegister = Arrays.copyOf(menyRegister, menyRegister.length + 1);
        menyRegister[menyRegister.length - 1] = meny;
    }

    /**
     * Sorterer menyer paa totalpris
     *
     * @see Meny
     * @see Comparable
     */
    public void sorterMenyer() {
        Arrays.sort(menyRegister);
    }

    /**
     * Gir liste med meny basert paa totalpris range, gitt at lista er sortert etter totalpris
     * @param nedrePris fra totalsum
     * @param ovrePris til totalsum
     * @return output Meny arrayobjekt
     */
    public Meny[] totalPrisSok(double nedrePris, double ovrePris) {
        int ovreIndex = 0;
        int nedreIndex = 0;
        for (int ovre = menyRegister.length - 1; ovre > 0; ovre--) {
            if (menyRegister[ovre].totalPris() <= ovrePris) {
                ovreIndex = ovre;
                break;
            }
        }

        for (int nedre = 0; nedre < menyRegister.length; nedre++) {
            if (menyRegister[nedre].totalPris() >= nedrePris) {
                nedreIndex = nedre;
                break;
            }
        }
        Meny[] output = Arrays.copyOfRange(menyRegister, nedreIndex, ovreIndex + 1);
        return output;
    }

    /**
     * to string metode
     *
     * @return output en string for menyRegisteret
     */
    @Override
    public String toString() {
        String output = "";
        for (Meny m : menyRegister
        ) {
            output += m.getNavn() + ", " + m.totalPris() + "\n";
        }
        return output;
    }


}
