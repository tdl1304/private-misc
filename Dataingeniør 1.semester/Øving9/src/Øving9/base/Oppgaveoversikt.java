package Øving9.base;

import java.util.Arrays;

public class Oppgaveoversikt {
    private Student[] studenter;
    private int antStud = 0;

    public Oppgaveoversikt() {
        studenter = new Student[antStud];
    }

    public int getAntStud() {
        return antStud;
    }

    public int getAntLøst(int id) {
        return studenter[id].getAntOppg();
    }

    //setter en elev i systemet og sender tilbake konfirmasjonsinfo
    public void nyStud(String navn, int antOppg) {
        this.studenter = Arrays.copyOf(studenter, studenter.length+1);
        antStud++;
        int studId = antStud - 1;
        studenter[studId] = new Student(navn, antOppg, studId);

    }

    public void økAntOppg(int økning, int id) {
        studenter[id].økAntOppg(økning);
    }

    public String toString() {
        String toString = "";
        for (Student s : studenter) {
            toString += s.toString() + "\n";
        }
        return toString;
    }
}
