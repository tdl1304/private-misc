package admin.arbeidstaker;

import java.util.GregorianCalendar;

public class ArbTaker {
    GregorianCalendar kalender = new GregorianCalendar();
    int år = kalender.get(java.util.GregorianCalendar.YEAR);

    private Person personlia;
    private long arbtakerNr;
    private int ansattÅr;
    private int mndLønn;
    private double prosentSkatt;

    public ArbTaker(String fnavn, String enavn, int fdår, long arbNr, int ansattÅr, int mndLønn, double prosentSkatt) {
        this.arbtakerNr = arbNr;
        this.ansattÅr = ansattÅr;
        this.mndLønn = mndLønn;
        this.prosentSkatt = prosentSkatt;
        this.personlia = new Person(fnavn, enavn, fdår);
    }

    public long getArbtakerNr() {
        return arbtakerNr;
    }

    public int getAnsattÅr() {
        return ansattÅr;
    }

    public int getMndLønn() {
        return mndLønn;
    }

    public double getProsentSkatt() {
        return prosentSkatt;
    }

    public void setMndLønn(int mndLønn) {
        this.mndLønn = mndLønn;
    }

    public void setProsentSkatt(double prosentSkatt) {
        this.prosentSkatt = prosentSkatt;
    }

    public double skattPerMnd() {
        return prosentSkatt * (double) mndLønn;
    }

    public int bruttolønn() {
        return mndLønn * 12;
    }

    public double skattPerÅr() {
        //1 måned er skattefri, og 1 måned er 1/2 skatt
        return 10.5 * skattPerMnd();
    }

    public String fulltNavn() {
        return "" + personlia.getEtternavn() + ", " + personlia.getFornavn();
    }

    public int alder() {
        return år - personlia.getFdår();
    }

    public int antallJobbÅr() {
        return år - ansattÅr;
    }

    public boolean ansattMerEnn(int ÅR) {
        if (this.antallJobbÅr() > ÅR) {
            return true;
        } else return false;
    }

}
