package com.oblig5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Represents one specific individual animal in the Zoo.
 * All individuals in the Zoo have a given name, a date of birth,
 * and it is also tagged whether or not the animal is dangerous for the
 * visiting guests of the Zoo.
 */
abstract class Individual extends Animal implements ScandinavianWildAnimal {
    private String name;
    private LocalDate dateOfBirth;
    private boolean isDangerous;

    /**
     * Creates an instance of Individual.
     *
     * @param norName     norwegian name of the animal
     * @param latName     the animal name in latin
     * @param latFamily   the family in latin
     * @param arrivalDate date of arrival to the Zoo
     * @param address     the address of the animal
     * @param name        the name of the individual
     * @param dateOfBirth date of birth
     * @param isDangerous <code>true</code> if dangerous for visitors
     */
    public Individual(String norName,
                      String latName,
                      String latFamily,
                      LocalDate arrivalDate,
                      String name,
                      LocalDate dateOfBirth,
                      boolean isDangerous,
                      String address) {

        super(norName, latName, latFamily, arrivalDate, address);
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.isDangerous = isDangerous;
    }

    /**
     * Returns the name of the individual.
     *
     * @return the name of the individual.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the individual.
     *
     * @param name the name of the individual.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the date of birth.
     *
     * @return the date of birth.
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns <code>true</code> if the animal can be dangerous for the
     * visitors of the Zoo. <code>false</code> if not.
     *
     * @return <code>true</code> if the animal can be dangerous for the
     * visitors of the Zoo. <code>false</code> if not.
     */
    public boolean isDangerous() {
        return isDangerous;
    }

    /**
     * Sets whether or not the individual might be dangerous for the
     * visitors of the Zoo.
     *
     * @param isDangerous <code>true</code> if the individual is dangerous.
     */
    public void setDangerous(boolean isDangerous) {
        this.isDangerous = isDangerous;
    }

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(getDateOfBirth(), LocalDate.now());
    }

    public void move(String newAddress) {
        setAddress(newAddress);
    }

    public String printInfo() {
        return super.toString();
    }

    public abstract int getNoOfLitters();
}