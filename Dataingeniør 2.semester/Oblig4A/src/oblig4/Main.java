package oblig4;

import oblig4.animals.*;
import oblig4.traits.Flyable;
import oblig4.traits.Jumpable;
import oblig4.traits.Walkable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ZooException {

        Zoo zoo = new Zoo("Kristiansand Dyrepark");

        Collection<Animal> animals = new ArrayList<Animal>();

        animals.add(new Crocodile("Crocodylus niloticus", 1001));
        animals.add(new Crocodile("Crocodylus niloticus", 1002));
        animals.add(new Crocodile("Crocodylus porosus", 1101));
        animals.add(new Crocodile("Crocodylus porosus", 1102));
        animals.add(new Pelican("Brown Pelican  ", 4001));
        animals.add(new Pelican("Dalmatian Pelican  ", 4101));


        animals.add(new Whale("Blue whale", 2001));
        animals.add(new Whale("Blue whale", 2002));
        animals.add(new Whale("Minke whale", 2101));
        animals.add(new Whale("Minke whale", 2102));
        animals.add(new Bat("Acerodon ", 3001));
        animals.add(new Bat("Cistugo  ", 3002));

        zoo.setAnimals(animals);
        //2a)
        Collection<Animal> flyingAnimals = animals.stream()
                .filter(x -> x instanceof Flyable)
                .collect(Collectors.toList());
        flyingAnimals.forEach(x -> {
            if (((Flyable) x).fly()) ;
            System.out.println(x.name + "can fly");
        });

        //2b)
        Collection<Animal> jumpableMammals = animals.stream()
                .filter(x -> x instanceof Mammal & x instanceof Jumpable)
                .collect(Collectors.toList());
        jumpableMammals.forEach(x -> {
            if (((Jumpable) x).jump()) ;
            System.out.println(x.name + " can jump");
        });


        List<Object> walker = zoo.getAnimals().stream().filter(p -> p instanceof Walkable)
                .collect(Collectors.toList());



        //3a)
        try {
            walker.stream().forEach(p -> {
                ((Flyable) p).fly();
            });
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }


        /* 3b)
        try {
            walker.stream().forEach(p -> {
                ((Flyable) p).fly();
            });
        } catch (ClassCastException e) {
            System.exit(1);
        }
         */

        /* 3c)
        try {
            try {
                walker.stream().forEach(p -> {
                    ((Flyable) p).fly();
                });
            } catch (Exception e) {
                throw new ZooException();
            }
        } catch (ZooException e) {
            System.out.println(e.getMessage());
        }
        */
    }
}
