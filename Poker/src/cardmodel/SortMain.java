package cardmodel;

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
        cardmodel.Card[] cards = new cardmodel.Card[5];
        cards[0] = new cardmodel.Card(cardmodel.Rank.ACE, cardmodel.Suit.CLUBS);
        cards[1] = new cardmodel.Card(cardmodel.Rank.TEN, cardmodel.Suit.HEARTS);
        cards[2] = new cardmodel.Card(cardmodel.Rank.ACE, cardmodel.Suit.SPADES);
        cards[3] = new cardmodel.Card(cardmodel.Rank.KING, cardmodel.Suit.CLUBS);
        cards[4] = new cardmodel.Card(cardmodel.Rank.TWO, cardmodel.Suit.DIAMONDS);

        // sort the objects in the array
        /*
        cardmodel.SortMain.bubbleSort(cards);
        for(cardmodel.Card c : cards) {
            System.out.println(c);
        }


        // create 52 cards
        List<cardmodel.Card> cards = new ArrayList<>();
        for(cardmodel.Suit s : cardmodel.Suit.values()) {
            for(cardmodel.Rank r : cardmodel.Rank.values()) {
                cards.add(new cardmodel.Card(r, s));
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