package admin.arbeidstaker;

public class Person {
    private final String fornavn;
    private final String etternavn;
    private final int fdår;

    public Person(String fnavn, String enavn, int fdår) {
        this.fornavn = fnavn;
        this.etternavn = enavn;
        this.fdår = fdår;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public int getFdår() {
        return fdår;
    }
}
