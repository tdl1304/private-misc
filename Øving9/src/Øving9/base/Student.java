package Øving9.base;

public class Student {
    private String navn;
    private int antOppg; //antall oppgaver godkjent
    private int studId;

    public Student(String navn, int antOppg, int studId) {
        this.navn = navn;
        this.antOppg = antOppg;
        this.studId = studId;
    }
    public String getNavn() {
        return navn;
    }

    public int getAntOppg() {
        return antOppg;
    }

    public void økAntOppg(int økning) {
        this.antOppg += økning;
    }

    public String toString() {
        return "Navn: "+navn+", oppg:"+antOppg+" id: "+studId;
    }
}
