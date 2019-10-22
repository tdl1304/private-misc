package øving10.oppg1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        ArrangementRegister ArrListe = new ArrangementRegister();
        ArrListe.NyArrangement(1, "hei", "borda", "bud", "fest", 100010111900L);
        ArrListe.NyArrangement(0, "hei", "jorda", "gud", "fest", 100010121800L);
        ArrListe.NyArrangement(2, "hei", "jorda", "sud", "fest", 100010132000L);
        ArrListe.NyArrangement(3, "hei", "aorda", "lud", "fest", 100010132100L);
        do {
            System.out.println("1: Nytt arrangement\n2: Vis liste\n3: Sorteringsmuligheter");
            int userInput = in.nextInt();
            switch (userInput) {
                case 1:
                    System.out.println("Skriv id, navn, sted, arrangerer, type og tid (YEARMMDDHRMM)");
                    String input = in.nextLine();
                    input = in.nextLine();
                    String[] a = input.trim().split(" ");
                    ArrListe.NyArrangement(Integer.parseInt(a[0]), a[1], a[2], a[3], a[4], Long.parseLong(a[5]));
                    System.out.println("Nytt arrangement lagt til");
                    break;
                case 2:
                    System.out.println(ArrListe.toString());
                    break;
                case 3:
                    System.out.println("1: Sorter etter sted\n2: Sorter etter type\n3: Sorter etter tid og dato\n4: Vis liste med spesifikk sted"
                            + "\n5: Vis liste med spesifikk dato\n6: Vis liste med mellom spesifikke datoer");
                    int userInput2 = in.nextInt();
                    switch (userInput2) {
                        case 1:
                            ArrListe.SortByPlace();
                            System.out.println(ArrListe.toString());
                            break;
                        case 2:
                            ArrListe.SortByType();
                            System.out.println(ArrListe.toString());
                            break;
                        case 3:
                            ArrListe.SortByTime();
                            System.out.println(ArrListe.toString());
                            break;
                        case 4:
                            System.out.println("Angi sted:");
                            String sted = in.nextLine();
                            sted = in.nextLine();
                            ArrListe.ListOfPlace(sted);
                            System.out.println(ArrListe.toString());
                            break;
                        case 5:
                            System.out.println("Angi dato:");
                            int dato = in.nextInt();
                            ArrListe.ListOfDate(dato);
                            System.out.println(ArrListe.toString());
                            break;
                        case 6:
                            //datoen må være eksisterende på lista
                            System.out.println("Angi dato fra(YEARMMDD):");
                            int nedreDato = in.nextInt();
                            System.out.println("Angi dato til(YEARMMDD):");
                            int ovreDato = in.nextInt();
                            ArrListe.ListOfDates(nedreDato, ovreDato);
                            System.out.println(ArrListe.toString());
                            break;
                    }
                    break;
            }
            Thread.sleep(1000);
        } while (true);


    }

}
