package com.oblig5;

import java.time.LocalDate;

public class WildAnimalFactory implements AnimalFactoryInterface {

    private static WildAnimalFactory instance;
    private static boolean isInitiated = false;

    private WildAnimalFactory() {isInitiated = true;}

    public static WildAnimalFactory getInstance() {
        if (!isInitiated) {
            instance = new WildAnimalFactory();
        }
        return instance;
    }

    @Override
    public ScandinavianWildAnimal newMaleBear(LocalDate arrivalDate, String name, LocalDate dateOfBirth, String address) {
        return new MaleIndividual("Bjørn", "Ursus arctos", "Ursidae", arrivalDate, name, dateOfBirth, true, address);
    }

    @Override
    public ScandinavianWildAnimal newFemaleBear(LocalDate arrivalDate, String name, LocalDate dateOfBirth, String address) {
        return new FemaleIndividual("Bjørn", "Ursus arctos", "Ursidae", arrivalDate, name, dateOfBirth, true, address, 0);
    }

    @Override
    public ScandinavianWildAnimal newMaleWolf(LocalDate arrivalDate, String name, LocalDate dateOfBirth, String address) {
        return new MaleIndividual("Ulv", "Canis lupus", "Canidae", arrivalDate, name, dateOfBirth, true, address);
    }

    @Override
    public ScandinavianWildAnimal newFemaleWolf(LocalDate arrivalDate, String name, LocalDate dateOfBirth, String address) {
        return new FemaleIndividual("Ulv", "Canis lupus", "Canidae", arrivalDate, name, dateOfBirth, true, address, 0);
    }
}
