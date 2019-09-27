package admin.arbeidstaker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ArbTaker person1 = new ArbTaker("Jon", "Jonsen", 1985, 13042349, 2000, 30000, 23.6 / 100);

        System.out.println(person1.fulltNavn());
        System.out.println(person1.getAnsattÅr());
        System.out.println(person1.getArbtakerNr());
        System.out.println(person1.getMndLønn());
        System.out.println(person1.getProsentSkatt() + "\n");
        System.out.println(person1.alder());
        System.out.println(person1.antallJobbÅr());
        System.out.println(person1.bruttolønn());
        System.out.println(person1.skattPerMnd());
        System.out.println(person1.skattPerÅr());

        if (person1.ansattMerEnn(20)) System.out.println("Ansatt mer enn 10 år");
        else System.out.println("Ansatt mindre enn 10 år");

        Scanner in = new Scanner(System.in);
        while (true) {
            Thread.sleep(500);
            System.out.println("1: Månedslønn\t 2: Skatteprosent\t 3: exit");
            int valg = in.nextInt();
            if (valg == 1) {
                System.out.println("Nytt heltallsbeløp: ");
                int beløp = in.nextInt();
                person1.setMndLønn(beløp);
                System.out.println("Nytt beløp er nå " + person1.getMndLønn());
            } else if (valg == 2) {
                System.out.println("Ny skatteprosent (desimaltall): ");
                double prosent = in.nextDouble();
                person1.setProsentSkatt(prosent);
                System.out.println("Ny skatteprosent er nå " + person1.getProsentSkatt());
            } else if (valg == 3) {
                break;
            }
        }//while
        System.exit(0);
    }
}
