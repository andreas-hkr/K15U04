import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Läs in spelkort från en fil, sortera dem, och skriv ut dem på skärmen
        // <färg> <valör>
        // <färg> <valör>

        Card[] cards = new Card[52];
        int count = 0;

        Scanner fileIn = new Scanner(new File("cards.txt"));
        while (fileIn.hasNextInt()) {
            Card c = new Card();
            c.suit = fileIn.nextInt();
            c.rank = fileIn.nextInt();
            cards[count] = c;
            count++;
        }

        Arrays.sort(cards, 0, count);

        for (int i=0; i < count; i++) {
            System.out.println(cards[i]);
        }
    }
}

class Card implements Comparable<Card> {
    static final int CLUBS = 0;
    static final int DIAMONDS = 1;
    static final int HEARTS = 2;
    static final int SPADES = 3;
    static String[] suits = {"Klöver", "Ruter", "Hjärter", "Spader"};
    static String[] ranks = {
            "ess", "två", "tre", "fyra", "fem", "sex", "sju",
            "åtta", "nio", "tio", "knekt", "dam", "kung"
    };

    int suit;
    int rank;

    public int compareTo(Card c) {
        if (suit < c.suit) {
            return -1;
        } else if (suit > c.suit) {
            return 1;
        } else {
            if (rank == c.rank) {
                return 0;
            } else if (c.rank == 1) {
                return -1;
            } else if (rank == 1 || rank > c.rank) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        return suits[suit] + " " + ranks[rank - 1];
    }
}