package Øving9.base;

public class Main {

    public static void main(String[] args) {
        Oppgaveoversikt ProgrammeringsØvinger = new Oppgaveoversikt();
        ProgrammeringsØvinger.nyStud("Jon", 2);
        ProgrammeringsØvinger.nyStud("Jan", 3);
        System.out.println(ProgrammeringsØvinger.toString());
        System.out.println("\nAnt. studenter: "+ProgrammeringsØvinger.getAntStud());
        System.out.println("Oppgaver Løst for student med id 0: "+ProgrammeringsØvinger.getAntLøst(0));
        ProgrammeringsØvinger.økAntOppg(2, 0);
        System.out.println("(økt)Oppgaver Løst for student med id 0: "+ProgrammeringsØvinger.getAntLøst(0));


    }
}
