import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        Deck deck1 = new Deck();
        deck1.fillDeck();

        ArrayList<Card> luckyCards = deck1.assign(5);
        System.out.println(luckyCards.toString());


        //Prints all cards with spades
        System.out.println("All spades:");
        luckyCards.stream()
                .filter(x -> x.getSuit() == 'S')
                .forEach(System.out::println);

        //Collect all hearts in an arraylist
        ArrayList<Card> hearts = (ArrayList<Card>) luckyCards.stream()
                .filter(x -> x.getSuit() == 'H')
                .collect(Collectors.toList());
        System.out.println("All hearts:");
        hearts.forEach(System.out::println);

        //Collect all suits in a list and print out
        System.out.println("All suits:");
        ArrayList<Character> suits = (ArrayList<Character>) luckyCards.stream()
                .map(x -> x.getSuit())
                .collect(Collectors.toList());
        suits.forEach(System.out::println);

        //Reduce to sum
        int sum = luckyCards.stream()
                .map(x -> x.getFace())
                .reduce(0, (x, y) -> x + y);
        System.out.println("Sum = " + sum);

        //Check for hearts among the random cards
        boolean containsHeart = luckyCards.stream()
                .anyMatch(x -> x.getSuit() == 'H');
        if (containsHeart) System.out.println("There are hearts pulled out");
        else System.out.println("There are no hearts pulled out");

        //Check for poker-flush
        int[] suitsCount = new int[4]; // S=0, C=1, D=2, H=3
        AtomicBoolean pokerFlush = new AtomicBoolean(false);

        //Counts suits
        suits.stream().forEach(x -> {
            if (x == 'S') suitsCount[0]++;
            else if (x == 'C') suitsCount[1]++;
            else if (x == 'D') suitsCount[2]++;
            else if (x == 'H') suitsCount[3]++;
            if (suitsCount[0] == 5 || suitsCount[1] == 5 || suitsCount[2] == 5 || suitsCount[3] == 5)
                pokerFlush.set(true);
        });

        //if one of the suits are 5 print statement
        if (pokerFlush.get()) System.out.println("Poker Flush!");
        else System.out.println("No poker flush :(");
    }
}
