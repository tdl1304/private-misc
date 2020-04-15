package com.oblig5;

import java.io.File;
import java.rmi.server.ExportException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static Logger log = Logger.getLogger(Main.class.getName());
    public static FileHandler fh;

    public static void createLog() {
        try {
            fh = new FileHandler(System.getProperty("user.dir") + File.separator + "log.log");
            log.addHandler(fh);
            fh.setFormatter(new SimpleFormatter());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createLog();
        WildAnimalFactory wildAnimalFactory = WildAnimalFactory.getInstance();
        ArrayList<ScandinavianWildAnimal> scandinavianWildAnimals = new ArrayList<>();
        ScandinavianWildAnimal ulla = wildAnimalFactory.newFemaleWolf(LocalDate.of(2015, 2, 26), "Ulla", LocalDate.of(2015, 4, 29), "Innhegning 2,  Skandinaviske rovdyr");
        log.info("Creating object:\n" + ulla.printInfo());
        ScandinavianWildAnimal eva = wildAnimalFactory.newFemaleBear(LocalDate.of(2017, 3, 15), "Eva", LocalDate.of(2013, 1, 1), "Innhegning 3, Skandinaviske rovdyr");
        log.info("Creating object:\n" + eva.printInfo());
        scandinavianWildAnimals.add(ulla);
        log.info("Adding to list: " + ulla.getName());
        scandinavianWildAnimals.add(eva);
        log.info("Adding to list: " + eva.getName());

        //scandinavianWildAnimals.forEach(x -> System.out.println(x.printInfo() + "\nAge:" + x.getAge() +"\n"));
    }
}
