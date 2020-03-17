import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Class for handling card decks and streams of cards
 */
public class Deck {
    private ArrayList<Card> deck;
    private Random random;
    public final static char[] suit = {'S', 'H', 'D', 'C'};

    public Deck() {
        random = new Random();
        deck = new ArrayList<Card>();
    }

    /**
     * Fills deck with all cards
     */
    public void fillDeck() {
        IntStream.rangeClosed(1, 13).forEach(i -> { //loops through nums. 1-13
            for (char c : suit
            ) {
                deck.add(new Card(c, i)); //add to the list for each suit and number
            }
        });
    }

    /**
     * Get a random cards
     * Not more than 1 copy per card
     *
     * @param n int amount of cards
     * @return list with random cards or null if error occurs
     */
    public ArrayList<Card> assign(int n) {
        ArrayList<Card> randomcards = new ArrayList<>();
        try {
            if(n > 52 || n < 1) throw new Exception("Illegal amount of cards");
            for (int i = 0; i < n; i++) {
                Card c = deck.get(random.nextInt(52));
                if (!randomcards.contains(c)) { //checks if the card already exist in the list
                    randomcards.add(c);
                } else i--; //Try again if random card already exists
            }

            return randomcards;
        } catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return null; //returns null if an illegal amount of cards is detected
    }

    /**
     * String of all cards in the deck
     * @return output String
     */
    @Override
    public String toString() {
        String output = "";
        for (Card c : deck) {
            output += c.toString() + "\n";
        }
        return output;
    }

}

