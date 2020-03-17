package oblig4;

public class ZooException extends Exception{

    public ZooException() {
        super("Something went wrong in the Zoo, the animals aren't behaving right");
    }

    public ZooException(String message) {
        super(message);
    }
}
