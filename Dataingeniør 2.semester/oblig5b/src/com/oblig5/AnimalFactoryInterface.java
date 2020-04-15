package com.oblig5;

import java.time.LocalDate;

public interface AnimalFactoryInterface {
    ScandinavianWildAnimal newMaleBear(LocalDate arrivalDate, String name, LocalDate dateOfBirth, String address);

    ScandinavianWildAnimal newFemaleBear(LocalDate arrivalDate, String name, LocalDate dateOfBirth, String address);

    ScandinavianWildAnimal newMaleWolf(LocalDate arrivalDate, String name, LocalDate dateOfBirth, String address);

    ScandinavianWildAnimal newFemaleWolf(LocalDate arrivalDate, String name, LocalDate dateOfBirth, String address);
}
