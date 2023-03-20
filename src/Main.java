public class Main {
    public static void main(String[] args) {
        // Läs in spelkort från en fil, sortera dem, och skriv ut dem på skärmen
        // <färg> <valör>
        // <färg> <valör>


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