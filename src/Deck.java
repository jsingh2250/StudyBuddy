import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<FlashCard> {
    // Shuffles the order of the flash cards.
    public void shuffle() {
        Collections.shuffle(this);
    }
}
