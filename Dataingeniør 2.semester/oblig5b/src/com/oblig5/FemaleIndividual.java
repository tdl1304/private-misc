package com.oblig5;

import java.time.LocalDate;

/**
 * Represents a female individual. A female can give birth, represented
 * by the field noLitters.
 */
class FemaleIndividual extends Individual {
  private int noLitters;

  /**
   * Creates an instance of a FemaleIndividual.
   *
   * @param norName     norwegian name of the animal
   * @param latName     the animal name in latin
   * @param latFamily   the family in latin
   * @param arrivalDate date of arrival to the Zoo
   * @param address     the address of the animal
   * @param name        the name of the individual
   * @param dateOfBirth date of birth
   * @param isDangerous <code>true</code> if dangerous for visitors
   * @param noLitters   number of children/offspring.
   */
  public FemaleIndividual(String norName,
                          String latName,
                          String latFamily,
                          LocalDate arrivalDate,
                          String name,
                          LocalDate dateOfBirth,
                          boolean isDangerous,
                          String address,
                          int noLitters) {
    super(norName, latName, latFamily, arrivalDate, name, dateOfBirth, isDangerous, address);
    this.noLitters = noLitters;
  }


  /**
   * Returns the number of children/offsrping.
   *
   * @return the number of children/offsrping.
   */
  @Override
  public int getNoOfLitters() {
    return noLitters;
  }

  /**
   * Sets the number of offsprings.
   *
   * @param noLitters the number of children/offspring.
   */
  public void setNoLitters(int noLitters) {
    this.noLitters = noLitters;
  }


  /**
   * Increases the number of children by the amount specified.
   *
   * @param antall the number of children to increase the total
   *               number of children by.
   */
  @Override
  public void addLitter(int antall) {
    noLitters += antall;
  }


  /**
   * Increases the number of offsprings by one.
   */
  @Override
  public void addNewLitter() {
    noLitters += 1;
  }  
}
