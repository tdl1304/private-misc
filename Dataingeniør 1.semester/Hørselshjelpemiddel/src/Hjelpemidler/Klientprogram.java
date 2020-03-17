package Hjelpemidler;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showOptionDialog;

public class Klientprogram {
    private static final int YES_NO_OPTION = JOptionPane.YES_NO_OPTION;
    private static final int INFORMATION_MESSAGE = JOptionPane.INFORMATION_MESSAGE;

    public static void main(String[] args) {

        Hjelpemiddelsentral ntnu = new Hjelpemiddelsentral("NTNU-sentralen");
        String[] muligheter = {"List all informasjon", "Registrer nytt hjelpemiddel", "Registrer Utlån", "Registrer innlevering", "Avslutt"};
        final int LIST_ALLE = 0;
        final int REGISTRER_NYTT_HJELPEMIDDEL = 1;
        final int UTLEVERING_AV_HJELPEMIDDEL = 2;
        final int INNLEVERING_AV_HJELPEMIDDEL = 3;
        final int AVSLUTT = 4;

        int valg = showOptionDialog(null, "Hjelpemiddelsentralen " + ntnu.getNavn() + "\nVelg funksjon", "Eksamen des 2019", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
        while (valg != AVSLUTT) {
            switch (valg) {
                case LIST_ALLE:
                    JOptionPane.showMessageDialog(null, "NTNU-sentralen\nRegistrerte hjelpemidler\n"+ntnu.toString());
                    break;
                case REGISTRER_NYTT_HJELPEMIDDEL:
                    String[] jaNei = {"Ja", "Nei"};
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Id:"));
                    String type = JOptionPane.showInputDialog("Type:");
                    boolean utleid = false;
                    int utleiestatus = JOptionPane.showOptionDialog(null, "Utleid:", "", YES_NO_OPTION, INFORMATION_MESSAGE, null, jaNei, jaNei[1]);
                    if (utleiestatus == 0) utleid = true;
                    String leier = JOptionPane.showInputDialog("Navn på leier:");

                    ntnu.leggTilHjelpemiddel(new Hjelpemiddel(id, type, utleid, leier));
                    JOptionPane.showMessageDialog(null, "Hjelpemiddel er registrert");
                    break;
                case UTLEVERING_AV_HJELPEMIDDEL:
                	String leierNavn = JOptionPane.showInputDialog("Navn på leier:");
                	int idTilHjelpemiddel = Integer.parseInt(JOptionPane.showInputDialog("Id:"));
                    ntnu.startUtleie(leierNavn, ntnu.finnHjelpemiddel(idTilHjelpemiddel));
                    JOptionPane.showMessageDialog(null,"Utlevering av hjelpemiddel var vellykket");
                    break;
                case INNLEVERING_AV_HJELPEMIDDEL:
                	int idAvsluttUtleie = Integer.parseInt(JOptionPane.showInputDialog("Id:"));
                	ntnu.avsluttUtleie(ntnu.finnHjelpemiddel(idAvsluttUtleie));
                	JOptionPane.showMessageDialog(null, "Innlevering var vellykket");
                	break;
                default:
                    break;
            }
            valg = showOptionDialog(null, "Hjelpemiddelsentralen " + ntnu.getNavn() + "\nVelg funksjon", "Eksamen des 2019", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
        }

    }
}