package Oblig4B;

import Oblig4B.memberships.BasicMember;
import Oblig4B.memberships.GoldMember;
import Oblig4B.memberships.SilverMember;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.logging.Level;

public abstract class BonusMember {
    public static String pathToResources = System.getProperty("user.dir") + File.separator + "resources" + File.separator;
    public static final double GOLD_FACTOR = 1.5;
    public static final double SILVER_FACTOR = 1.2;
    private final Personals personals;
    private final int memberNo;
    private final LocalDate enrolledDate;
    private int point = 0;

    /**
     * Feil kan oppstå under registrering og brukeren kan skrive feil informasjon, derfor kastes IllegalArgumentException
     *
     * @param memberNo
     * @param enrolledDate
     * @param personals
     * @throws IllegalArgumentException
     */
    public BonusMember(int memberNo, LocalDate enrolledDate, Personals personals) throws IllegalArgumentException {
        if (memberNo < 0 || enrolledDate == null || personals == null) {
            throw new IllegalArgumentException("Invalid arguments in Oblig4B.BonusMember");
        }
        this.personals = personals;
        this.memberNo = memberNo;
        this.enrolledDate = enrolledDate;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public int getPoints() {
        return point;
    }

    protected void setPoints(int points) {
        this.point = points;
    }

    public Personals getPersonals() {
        return personals;
    }

    /**
     * Når dato ikke er oppgitt kastes en exception. Da NullPointerException
     *
     * @param localDate
     * @return
     * @throws NullPointerException
     */
    public int findQualificationPoints(LocalDate localDate) throws NullPointerException {
        if (localDate == null) throw new NullPointerException();
        int daysBetween = (int) ChronoUnit.DAYS.between(enrolledDate, localDate);
        if (daysBetween < 365) return point;
        else return 0;
    }

    /**
     * Dersom brukeren ikke har skrevet noe, kastes NullPointerException. Tom streng regnes da som null.
     *
     * @param password
     * @return
     */
    public boolean okPassword(String password) {
        if (password == null || password.trim().equals("")) throw new IllegalArgumentException();
        return (personals.okPassword(password));
    }

    public void registerPoints(int points) {
        this.point += points;
    }

    /**
     * Mapper og lagrer en Bonusmember i en tekst fil.
     *
     * @param b
     * @return
     * @throws IOException Kastes for feil ved skriving og lesing av fil.
     */
    public static boolean savePersonals(BonusMember b) throws IOException {
        String[] saveData = formatSaveData(b);
        if (!readMembers().contains(saveData)) {
            FileWriter fileWriter = new FileWriter(pathToResources + "members.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(
                    saveData[0] + "," +
                            saveData[1] + "," +
                            saveData[2] + "," +
                            saveData[3] + "," +
                            saveData[4] + "," +
                            saveData[5] + "," +
                            saveData[6]
            );
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Deletes a member from the save file
     *
     * @param b
     * @throws IOException
     */
    public static void deleteMemberData(BonusMember b) throws IOException {
        String[] tempData = formatSaveData(b);
        String tempString = tempData[0] + "," + tempData[1] + "," + tempData[2] + "," + tempData[3] + "," + tempData[4] + "," + tempData[5] + "," + tempData[6];
        String line = null;

        //Save all data except the deleted bonusmember to a temporary text file
        FileReader fr = new FileReader(pathToResources + "members.txt");
        FileWriter fw = new FileWriter(pathToResources + "temp.txt", true);
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);

        while ((line = br.readLine()) != null) {
            if (!line.equals(tempString)) {
                bw.append(line);
                bw.newLine();
            }
        }

        br.close();
        bw.close();
        fr.close();
        fw.close();
        //Delete content in members.txt
        FileWriter clearMembers = new FileWriter(pathToResources + "members.txt");
        clearMembers.write("");
        clearMembers.close();

        //Copy from temp file to member file
        FileWriter fw1 = new FileWriter(pathToResources + "members.txt", true);
        FileReader fr1 = new FileReader(pathToResources + "temp.txt");
        BufferedWriter bw1 = new BufferedWriter(fw1);
        BufferedReader br1 = new BufferedReader(fr1);
        while ((line = br1.readLine()) != null) {
            bw1.append(line);
            bw1.newLine();
        }
        //Close connections
        br1.close();
        bw1.close();
        fw1.close();
        fr1.close();
        //Clear temp.txt
        FileWriter clearTemp = new FileWriter(pathToResources + "temp.txt");
        clearTemp.write("");
        clearTemp.close();
        MemberUI.log(Level.INFO, b.toString() + "-successfully deleted-");
    }

    private static String[] formatSaveData(BonusMember b) {
        String[] saveData = new String[7];
        saveData[0] = String.valueOf(b.getMemberNo());
        saveData[1] = b.getEnrolledDate().toString();
        saveData[2] = b.getPersonals().getFirstname();
        saveData[3] = b.getPersonals().getSurname();
        saveData[4] = b.getPersonals().getEmail();
        saveData[5] = b.getPersonals().getPassword();
        saveData[6] = String.valueOf(b.getPoints());
        return saveData;
    }

    /**
     * Leser tekstilen med savedata og gir en liste med bonusmember info i en String[]
     *
     * @return
     * @throws IOException           kastes ved lese feil
     * @throws FileNotFoundException kastes når fila ikke finnes
     */
    public static ArrayList<String[]> readMembers() throws IOException, FileNotFoundException {
        String fileName = "members.txt";
        String line = null;
        ArrayList<String[]> strings = new ArrayList<>();
        FileReader fileReader = new FileReader(pathToResources + "members.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((line = bufferedReader.readLine()) != null) {
            if (!line.trim().equals("")) strings.add(line.split(","));
        }
        fileReader.close();
        bufferedReader.close();

        return strings;
    }

    public static BonusMember readFormattedSaveData(String[] saveData) {
        //Splits the date from savefile
        String[] date = saveData[1].split("-");
        //Format enrolled date from savefile
        LocalDate saveDate = LocalDate.of(Integer.parseInt(date[0].trim()), Integer.parseInt(date[1].trim()), Integer.parseInt(date[2].trim()));
        //Format the rest of the savedata
        int memberNo = Integer.parseInt(saveData[0].trim());
        int points = Integer.parseInt(saveData[6].trim());
        Personals p = new Personals(saveData[2].trim(), saveData[3].trim(), saveData[4].trim(), saveData[5].trim());

        if (points >= MemberArchive.GOLD_LIMIT) {
            return new GoldMember(memberNo, saveDate, p, points);
        } else if (points >= MemberArchive.SILVER_LIMIT) {
            return new SilverMember(memberNo, saveDate, p, points);
        } else {
            return new BasicMember(memberNo, saveDate, p, points);
        }
    }

    //Bonusmember object are the same if the email is the same.
    @Override
    public boolean equals(Object o) {
        if (this.getPersonals().getEmail().equals(((BonusMember) o).getPersonals().getEmail())) {
            return true;
        } else return false;
    }

    @Override
    public abstract String toString();
}
