package oblig4.animals;

import oblig4.Oviparous;
import oblig4.traits.*;

public class Pelican extends Oviparous implements Walkable, Flyable {

    public Pelican(String name, int code) {
        super(name, code);
    }

    @Override
    public boolean fly() {
        return true;
    }

    @Override
    public boolean walk() {
        return true;
    }
}
