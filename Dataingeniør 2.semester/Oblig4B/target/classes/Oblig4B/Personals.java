package Oblig4B;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;

/**
 * Personalia.java  2010‐01‐18
 *
 * Klasse med personopplysninger: fornavn, etternavn, epostadresse og passord.
 * Passordet kan endres, men da mÃ¥ det nye vÃ¦re forskjellig fra det gamle.
 * Passordkontrollen skiller ikke mellom store og smÃ¥ bokstaver.
 */
public class Personals {
    private final String surname;
    private final String firstname;
    private final String email;
    private String password;

    /**
     * KonstruktÃ¸r:
     * Alle data mÃ¥ oppgis: fornavn, etternavn, eMailadr, passord
     * Ingen av dataene kan vÃ¦re null eller blanke strenger.
     */
    public Personals(String firstname, String surname, String eMailadr, String password) {
        //Big verification check
        if (firstname == null || surname == null || eMailadr == null || password == null ||
                firstname.trim().equals("") || surname.trim().equals("") ||
                eMailadr.trim().equals("") || password.trim().equals("")) {
            throw new IllegalArgumentException("Et eller flere konstruktrør argumenter er " +
                    "null og/eller blanke.");
        }
        this.firstname = firstname.trim();
        this.surname = surname.trim();
        this.email = eMailadr.trim();
        this.password = password.trim();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    protected String getPassword() {
        return password;
    }

    /**
     * Metoden returnerer true dersom passordet er korrekt.
     * Passordkontrollen skiller ikke mellom store og smÃ¥ bokstaver.
     */
    public boolean okPassword(String password) {
        return this.password.equalsIgnoreCase(password);
    }

    /**
     * Metoden setter nytt passord, dersom det er forskjellig fra
     * det gamle. To passord betraktes som like dersom det kun er
     * forskjeller i store/smÃ¥ bokstaver.
     *
     * Metoden returnerer true dersom passordet ble endret, ellers false.
     */
    public boolean changePassword(String oldPassword, String newPassword) {
        if (oldPassword == null || newPassword == null) {
            return false;
        }
        if (!password.equalsIgnoreCase(oldPassword.trim())) {
            return false;
        } else {
            password = newPassword.trim();
            return true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personals personals = (Personals) o;
        return email.equals(personals.email);
    }

    @Override
    public String toString() {
        return firstname+" "+surname+"\n"+email+"\nPassword: "+password;
    }
}