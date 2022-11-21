import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Deck extends LinkedList<FlashCard> {
    // Shuffles the order of the flash cards.
    public void shuffle() {
        Collections.shuffle(this);
    }
}
