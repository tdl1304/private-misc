package Øving9.base;

import java.util.ArrayList;

public class Oppgaveoversikt {
    private ArrayList<Student> studenter = new ArrayList<Student>();
    private int antStud = 0;

    public Oppgaveoversikt() {
    }

    public int getAntStud() {
        return antStud;
    }

    public int getAntLøst(int id) {
        return studenter.get(id).getAntOppg();
    }

    //setter en elev i systemet og sender tilbake konfirmasjonsinfo
    public void nyStud(String navn, int antOppg) {
        antStud++;
        int studId = antStud - 1;
        studenter.add(studId, new Student(navn, antOppg, studId));
    }

    public void økAntOppg(int økning, int id) {
        studenter.get(id).økAntOppg(økning);
    }

    public String toString() {
        String toString = "";
        for (Student s : studenter) {
            toString += s.toString() + "\n";
        }
        return toString;
    }
}
