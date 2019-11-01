package com.oving11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Eiendomsregister Eliste = new Eiendomsregister();
        Eiendom e1 = new Eiendom(1445, "Gloppen", 77, 631, "", "Jens Olsen", 1017.6);
        Eliste.nyEiendom(e1);
        Eliste.nyEiendom(1445, "Gloppen", 77, 131, "Syningrom", "Nicolay Madsen", 661.3);
        Eliste.nyEiendom(1445, "Gloppen", 75, 19, "Fugletun", "Evilyn Jensen", 650.6);
        Eliste.nyEiendom(1445, "Gloppen", 74, 188, "", "Karl Ove Bråten", 1457.2);
        Eliste.nyEiendom(1445, "Gloppen", 69, 47, "Høiberg", "Elsa Indregård", 1339.4);
        //Brukerstyrt menysystem
        Scanner in = new Scanner(System.in);
        int menyvalg = 0;
        while (true) {
            System.out.println("Norges eiendomsregister");
            System.out.println("Menyvalg:");
            System.out.println("1: Legg til eiendom");
            System.out.println("2: Vis alle registrerte eiendommer");
            System.out.println("3: Søk etter eiendom");
            System.out.println("4: Gjennomsnittsareal på registrerte eiendommer");
            System.out.println("5: Avslutt");
            menyvalg = in.nextInt();

            switch (menyvalg) {
                case 1:
                    System.out.println("Kommunenummer: ");
                    int kommunenr = in.nextInt();
                    System.out.println("Kommunenavn: ");
                    String kommunenavn = in.nextLine();
                    kommunenavn = in.nextLine();
                    System.out.println("Gårdsnummer: ");
                    int gnr = in.nextInt();
                    System.out.println("Bruksnummer: ");
                    int bnr = in.nextInt();
                    System.out.println("Eiendomsnavn ");
                    String navn = in.nextLine();
                    navn = in.nextLine();
                    System.out.println("Eier: ");
                    String eier = in.nextLine();
                    System.out.println("Areal: ");
                    double areal = in.nextDouble();
                    Eliste.nyEiendom(kommunenr, kommunenavn, gnr, bnr, navn, eier, areal);
                    System.out.println("Ny eiendom er registrert!");
                    break;
                case 2:
                    System.out.println(Eliste.toString());
                    break;
                case 3:
                    System.out.println("Hva er kommunenummeret?");
                    int knr = in.nextInt();
                    System.out.println("Hva er gårdsnummeret?");
                    int gaardsnr = in.nextInt();
                    System.out.println("Hva er bruksnummeret?");
                    int bruksnr = in.nextInt();
                    try {
                        Eiendom funnet = Eliste.finnEiendom(knr, gaardsnr, bruksnr);
                        System.out.println("Eiendom funnet: " + funnet.toString() + " Kommune: " + funnet.getKommunenavn() + ", Navn: " + funnet.getNavn()
                                + ", Eier: " + funnet.getEier()
                                + ", Areal: " + funnet.getAreal() + "\n");
                    } catch (NullPointerException e) {
                        System.out.println("Eiendom ikke funnet\n");
                    }
                    break;
                case 4:
                    double gjennomsnitt = Eliste.snittsAreal();
                    System.out.println("Gjennomsnittsareal: " + gjennomsnitt + "\n");
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Ugyldig menyvalg, prøv igjen \n");
                    break;
            }
        }


    }
}
