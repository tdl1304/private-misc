package com.RestaurantMeny;

/**
 * Oving 10 oppgave 2, Restaurant meny program
 * Inkluderer metoder for aa:
 * - Registrere en ny rett
 * - Finne en spesiell rett
 * - Registrere en ny meny
 * - Liste av menyer basert paa totalpris med ovre og nedre grense
 *
 * @author tommyluu
 */
public class Main {
    /**
     * @see MenyRegister
     * @see Meny
     * @see Rett
     * @see RettRegister
     * @param args mainprogrammet
     */
    public static void main(String[] args) {
        MenyRegister restaurant1 = new MenyRegister();
        RettRegister rettRegister = restaurant1.getRettRegister();

        rettRegister.nyRett("sjokoladeis", "dessert", 69);
        rettRegister.nyRett("spaghetti", "hovedrett", 79.90);
        rettRegister.nyRett("carbonara", "hovedrett", 59.90);
        rettRegister.nyRett("iskrem", "dessert", 40);
        rettRegister.nyRett("hvitloksbrod", "forrett", 39);
        rettRegister.nyRett("kjottboller", "hovedrett", 129);
        rettRegister.nyRett("misosuppe", "forrett", 49);

        Meny meny1 = new Meny("Tommysspesial");
        meny1.leggTilRett(rettRegister.getRett("kjottboller"));
        meny1.leggTilRett(rettRegister.getRett("carbonara"));
        meny1.leggTilRett(rettRegister.getRett("sjokoladeis"));
        restaurant1.leggTilMeny(meny1);

        restaurant1.nyMeny("Lunsj1", rettRegister.getRett("misosuppe"), rettRegister.getRett("spaghetti"), rettRegister.getRett("iskrem"));
        restaurant1.nyMeny("Lunsj2", rettRegister.getRett("hvitloksbrod"), rettRegister.getRett("kjottboller"), rettRegister.getRett("iskrem"));
        restaurant1.nyMeny("Middag", rettRegister.getRett("kjottboller"), rettRegister.getRett("carbonara"), rettRegister.getRett("sjokoladeis"));
        restaurant1.getMeny("Middag").leggTilRett(rettRegister.getRett("hvitloksbrod"));

        System.out.println(restaurant1.toString());
        System.out.println(rettRegister.toString());

        //Alle retter av en type:
        rettRegister.sorter();
        Rett[] hovedretter = rettRegister.finnTypeRetter("hovedrett");
        Rett[] forretter = rettRegister.finnTypeRetter("forrett");
        Rett[] desserter = rettRegister.finnTypeRetter("dessert");
        String rettInfo = "";
        for (Rett r : hovedretter
        ) {
            rettInfo += r.toString() + "\n";
        }
        System.out.println(rettInfo);

        //Menyer innenfor totalpris:
        restaurant1.sorterMenyer();
        Meny[] budsjettsMeny = restaurant1.totalPrisSok(200, 290);
        String menyInfo = "";
        for (Meny m : budsjettsMeny
        ) {
            menyInfo += m.getNavn() + ", " + m.totalPris() + "\n";
        }
        System.out.println(menyInfo);
    }


}
