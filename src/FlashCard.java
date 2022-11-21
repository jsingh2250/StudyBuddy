public class FlashCard {
    // Declare variables the store the term and definition for the flashcard.
    private String term;
    private String definition;
    
    // Constructor.
    public FlashCard(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }
}
