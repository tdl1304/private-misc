package oblig4.animals;

import oblig4.Mammal;
import oblig4.traits.*;


public class Whale extends Mammal implements Swimmable, Jumpable {
    public Whale(String name, int code) {
        super(name, code);
    }

    @Override
    public boolean jump() {
        return true;
    }

    @Override
    public boolean swim() {
        return true;
    }
}
