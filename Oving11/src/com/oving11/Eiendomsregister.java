package com.oving11;

import java.util.ArrayList;

public class Eiendomsregister {
    private ArrayList<Eiendom> Eliste;

    //Konstruktor oppretter en tom arraylist
    //bruker arraylist fordi den ikke har en dynamisk storrelse, dermed kan man fritt legge til flere eiendomsobjekter
    Eiendomsregister() {
        Eliste = new ArrayList<Eiendom>();
    }

    public void nyEiendom(Eiendom eiendom) {
        Eliste.add(eiendom);
    }

    public void nyEiendom(int kommunenr, String kommunenavn, int gnr, int bnr, String navn, String eier, double areal) {
        Eliste.add(new Eiendom(kommunenr, kommunenavn, gnr, bnr, navn, eier, areal));
    }

    public int antEiendom() {
        return Eliste.size();
    }

    //Gaar gjennom hele eiendomsregisteret og dersom kravene i if-setningen blir oppfylt har den funnet det bestemte objektet
    //hvis ikke, returneres nullﬂ
    public Eiendom finnEiendom(int Kommunenr, int gnr, int bnr) {
        for (Eiendom e : Eliste
        ) {
            if (e.getKommunenr() == Kommunenr && e.getGnr() == gnr && e.getBnr() == bnr) {
                return e;
            }
        }
        return null;
    }

    public void slettEiendom(int kommunenr, int gnr, int bnr) {
        Eliste.remove(finnEiendom(kommunenr, gnr, bnr));
    }

    public void slettEiendom(Eiendom e) {
        Eliste.remove(e);
    }

    //Finner forst summen av arealet til alle eiendommene i lista, og deretter summen dividert med ant. elementer
    public double snittsAreal() {
        double sum = 0;
        for (Eiendom e : Eliste
        ) {
            sum += e.getAreal();
        }
        return sum / (double) Eliste.size();
    }

    /**
     * Metode for aa gi et nytt register med spesifikke eiendommer
     * da kan funksjoner i eiendomsregister klassen fortsatt brukes
     *
     * @param gnr gaardsnummer
     * @return liste Eiendomsregister-objekt
     */
    public Eiendomsregister finnEiendomGnr(int gnr) {
        Eiendomsregister liste = new Eiendomsregister();
        for (Eiendom e : Eliste
        ) {
            if (e.getGnr() == gnr) {
                liste.nyEiendom(e);
            }
        }
        if (liste.antEiendom() == 0) {
            throw new IllegalArgumentException("Finner ikke noen eiendommer med angitt gardsnummer");
        } else return liste;
    }

    //String med en liste med alle eiendommene i registeret
    @Override
    public String toString() {
        String output = "";
        for (Eiendom e : Eliste
        ) {
            output += e.toString() + "\n";
        }
        return output;
    }
}
