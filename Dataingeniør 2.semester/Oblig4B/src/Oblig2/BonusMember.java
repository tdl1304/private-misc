package Oblig2;


import Oblig2.memberships.BasicMember;
import Oblig2.memberships.GoldMember;
import Oblig2.memberships.SilverMember;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class BonusMember {
    public static String pathToResources = "/Users/tommyluu/Documents/IntellJ prosjekter/Oblig2/resources/";
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
            throw new IllegalArgumentException("Invalid arguments in BonusMember");
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
     * @throws IllegalArgumentException
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
     * @throws NullPointerException
     */
    public boolean okPassword(String password) throws NullPointerException {
        password.trim();
        if (password.equals("")) throw new NullPointerException();
        return (personals.okPassword(password));
    }

    public void registerPoints(int points) {
        this.point += points;
    }

    public static ArrayList<String[]> readMembers() throws IOException, FileNotFoundException, IndexOutOfBoundsException {
        String fileName = "personals.txt";
        String line = null;
        ArrayList<String[]> strings = new ArrayList<>();
        FileReader fileReader = new FileReader(pathToResources + "personals.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((line = bufferedReader.readLine()) != null) {
            strings.add(line.split(","));
        }
        bufferedReader.close();

        return strings;
    }

    public static boolean savePersonals(BonusMember b) throws IOException {
        String[] saveData = formatSaveData(b);
        if (!readMembers().contains(saveData)) {
            FileWriter fileWriter = new FileWriter(pathToResources + "personals.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.append(
                    saveData[0] + "," +
                            saveData[1] + "," +
                            saveData[2] + "," +
                            saveData[3] + "," +
                            saveData[4] + "," +
                            saveData[5] + "," +
                            saveData[6]
            );
            bufferedWriter.close();
            return true;
        } else {
            return false;
        }
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

    public static BonusMember readFormattedSaveData(String[] saveData) {
        String[] date = saveData[1].split("-");
        LocalDate saveDate = LocalDate.of(Integer.parseInt(date[0].trim()), Integer.parseInt(date[1].trim()), Integer.parseInt(date[2].trim()));
        int memberNo = Integer.parseInt(saveData[0].trim());
        int points = Integer.parseInt(saveData[6].trim());
        Personals p = new Personals(saveData[2].trim(), saveData[3].trim(), saveData[4].trim(), saveData[5].trim());

        if (points >= MemberArchive.GOLD_LIMIT) {
            return new GoldMember(memberNo, saveDate, p, points);
        } else if (points >= MemberArchive.SILVER_LIMIT ) {
            return new SilverMember(memberNo, saveDate, p, points);
        } else {
            return new BasicMember(memberNo, saveDate, p, points);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this.getPersonals().getEmail().equals(((BonusMember) o).getPersonals().getEmail())) {
            return true;
        } else return false;
    }
}
