import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A static method for sorting Comparables, i.e. objects of
 * types implementing the java.util.Comparable interface.
 */
public class SortMain {

    /**
     * Objects must be of a type implementing Comparable.
     * Sorting algorithm: Bubble sort.
     */
    public static <T> void bubbleSort(Comparable[] arr) {
        Comparable temp;
        boolean swapped;

        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // swap elements
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // if no two elements were swapped, then break
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {

        /*
        // some cards
        Card[] cards = new Card[5];
        cards[0] = new Card(Rank.ACE, Suit.CLUBS);
        cards[1] = new Card(Rank.TEN, Suit.HEARTS);
        cards[2] = new Card(Rank.ACE, Suit.SPADES);
        cards[3] = new Card(Rank.KING, Suit.CLUBS);
        cards[4] = new Card(Rank.TWO, Suit.DIAMONDS);

        // sort the objects in the array
        /*
        SortMain.bubbleSort(cards);
        for(Card c : cards) {
            System.out.println(c);
        }


        // create 52 cards
        List<Card> cards = new ArrayList<>();
        for(Suit s : Suit.values()) {
            for(Rank r : Rank.values()) {
                cards.add(new Card(r, s));
            }
        }
        System.out.println(cards);

        Collections.shuffle(cards);
        System.out.println(cards);

        Collections.sort(cards);
        System.out.println(cards);
        */
    }

    /**
     * A better/more correct version of the above sort method,
     * indicating a type extending generic interface Comparable<T>.
     */
    /*
    public static <T extends Comparable<T>> void bubbleSortT(T[] arr) {
        T temp;
        boolean swapped;

        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // swap elements
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // if no two elements were swapped, then break
            if (!swapped) break;
        }
     }
     */
}