package oblig4.animals;

import oblig4.Oviparous;
import oblig4.traits.*;

public class Crocodile extends Oviparous implements Walkable, Swimmable {

    public Crocodile(String name, int code) {
        super(name, code);
    }

    @Override
    public boolean swim() {
        return true;
    }

    @Override
    public boolean walk() {
        return true;
    }
}
