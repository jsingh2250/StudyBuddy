import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StudyBuddy extends Application {
    private TextField termTextField = new TextField();
    private TextArea definitionTextArea = new TextArea();
    private Button addNewCardButton = new Button("Add New Card");
    private Button shuffleCardsButton = new Button("Shuffle Cards");
    private Button showDefinitionButton = new Button("Show Definition");
    private Button nextCardButton = new Button("Next Card");
    private Button previousCardButton = new Button("Previous Card");

    Font labelFont = Font.font("Veranda", FontWeight.SEMI_BOLD, 18);
    Font buttonFont = Font.font("Veranda", FontWeight.BOLD, 11);
    // Instantiate the deck of flash cards.
    Deck deck = new Deck();

    // Declare a variable that can store the index of the currently selected flash card in the deck.
    int deckIndex = 0;

    @Override
    public void start(Stage stage) throws Exception {
        // // Test code.
        // for (int i = 0; i < 10; i++) {
        //     deck.add(new FlashCard("Term: " + Integer.toString(i), "Definition: " + Integer.toString(i)));
        // }
        // showFlashCardTerm(deck.get(deckIndex));

        // Create the main user interface.
        int horizontalAndVerticalGapInPixels = 26;
        GridPane mainGridPane = new GridPane();
        mainGridPane.setBackground(
                new Background(new BackgroundFill(Color.rgb(40, 40, 42), new CornerRadii(0), new Insets(3))));
        mainGridPane.setPadding(new Insets(horizontalAndVerticalGapInPixels));
        mainGridPane.setHgap(horizontalAndVerticalGapInPixels);
        mainGridPane.setVgap(horizontalAndVerticalGapInPixels);

        // Add term and definition text areas to the main user interface.
        GridPane termAndDefinitionGridPane = new GridPane();
        termAndDefinitionGridPane.setHgap(horizontalAndVerticalGapInPixels);
        termAndDefinitionGridPane.setVgap(horizontalAndVerticalGapInPixels);
        Label termLabel = new Label("Term:");
        termLabel.setFont(labelFont);
        termLabel.setTextFill(Color.WHITESMOKE);
        GridPane.setHalignment(termLabel, HPos.RIGHT);
        termAndDefinitionGridPane.add(termLabel, 0, 0);
        termAndDefinitionGridPane.add(termTextField, 1, 0);
        Label definitionLabel = new Label("Definition:");
        definitionLabel.setFont(labelFont);
        definitionLabel.setTextFill(Color.WHITESMOKE);
        GridPane.setHalignment(definitionLabel, HPos.RIGHT);
        termAndDefinitionGridPane.add(definitionLabel, 0, 1);
        definitionTextArea.setWrapText(true);
        termAndDefinitionGridPane.add(definitionTextArea, 1, 1);
        mainGridPane.add(termAndDefinitionGridPane, 0, 0);

        // Add buttons to the main user interface.
        GridPane buttonGridPane = new GridPane();
        buttonGridPane.setHgap(horizontalAndVerticalGapInPixels);
        buttonGridPane.setVgap(horizontalAndVerticalGapInPixels);
        buttonGridPane.add(addNewCardButton, 0, 0);
        buttonGridPane.add(shuffleCardsButton, 0, 1);
        buttonGridPane.add(showDefinitionButton, 0, 2);
        buttonGridPane.add(nextCardButton, 0, 3);
        buttonGridPane.add(previousCardButton, 0, 4);
        mainGridPane.add(buttonGridPane, 1, 0);

        // Setting formatting for buttons.
        int buttonWidth = 120;
        addNewCardButton
                .setStyle("-fx-background-color: whitesmoke; -fx-border-color: whitesmoke; -fx-border-radius: 2;");
        addNewCardButton.setFont(buttonFont);
        addNewCardButton.setPrefWidth(buttonWidth);

        shuffleCardsButton
                .setStyle("-fx-background-color: whitesmoke; -fx-border-color: whitesmoke; -fx-border-radius: 2;");
        shuffleCardsButton.setFont(buttonFont);
        shuffleCardsButton.setPrefWidth(buttonWidth);

        showDefinitionButton
                .setStyle("-fx-background-color: whitesmoke; -fx-border-color: whitesmoke; -fx-border-radius: 2;");
        showDefinitionButton.setFont(buttonFont);
        showDefinitionButton.setPrefWidth(buttonWidth);

        nextCardButton
                .setStyle("-fx-background-color: whitesmoke; -fx-border-color: whitesmoke; -fx-border-radius: 2;");
        nextCardButton.setFont(buttonFont);
        nextCardButton.setPrefWidth(buttonWidth);

        previousCardButton
                .setStyle("-fx-background-color: whitesmoke; -fx-border-color: whitesmoke; -fx-border-radius: 2;");
        previousCardButton.setFont(buttonFont);
        previousCardButton.setPrefWidth(buttonWidth);

        // Set the properties of the user interface.
        mainGridPane.setAlignment(Pos.CENTER);

        // Process events.
        addNewCardButton.setOnAction(e -> {
            String termToAdd = termTextField.getText();
            String definitionToAdd = definitionTextArea.getText();
            if (termToAdd.equals("") || definitionToAdd.equals("")) {
                return;
            }
            for (int i = 0; i < deck.size(); i++) {
                if (deck.get(i).getTerm().equals(termToAdd)) {
                    deck.set(i, new FlashCard(termToAdd, definitionToAdd));
                    return;
                }
            }
            deck.add(deckIndex, new FlashCard(termToAdd, definitionToAdd));
        });
        shuffleCardsButton.setOnAction(e -> {
            clearTextFieldAndTextArea();
            if (deck.isEmpty()) {
                return;
            }
            deck.shuffle();
            deckIndex = 0;
            showFlashCardTerm(deck.get(deckIndex));
        });
        showDefinitionButton.setOnAction(e -> {
            if (deck.isEmpty()) {
                return;
            }
            showFlashCardDefinition(deck.get(deckIndex));
        });
        nextCardButton.setOnAction(e -> {
            clearTextFieldAndTextArea();
            if (deck.isEmpty()) {
                return;
            }
            if (deckIndex < (deck.size() - 1)) {
                deckIndex++;
            }
            showFlashCardTerm(deck.get(deckIndex));
        });
        previousCardButton.setOnAction(e -> {
            clearTextFieldAndTextArea();
            if (deck.isEmpty()) {
                return;
            }
            if (deckIndex > 0) {
                deckIndex--;
            }
            showFlashCardTerm(deck.get(deckIndex));
        });

        // Create a scene and place it in the stage.
        Scene scene = new Scene(mainGridPane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Study Buddy");
        stage.show();
    }

    private void clearTextFieldAndTextArea() {
        termTextField.clear();
        definitionTextArea.clear();
    }

    private void showFlashCardTerm(FlashCard flashCard) {
        termTextField.setText(flashCard.getTerm());
    }

    private void showFlashCardDefinition(FlashCard flashCard) {
        definitionTextArea.setText(flashCard.getDefinition());
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
