import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StudyBuddy extends Application {
    private TextField termTextField = new TextField();
    private TextArea definitionTextArea = new TextArea();
    private Button addNewCardButton = new Button("Add New Card");
    private Button shuffleCardsButton = new Button("Shuffle Cards");
    private Button showDefinitionButton = new Button("Show Definition");
    private Button nextCardButton = new Button("Next Card");
    private Button previousCardButton = new Button("Previous Card");

    // @Override
    // public void start(Stage arg) throws Exception {
    //     Deck deck = new Deck();
    //     for (int i = 0; i < 10; i++) {
    //         deck.add(new FlashCard(Integer.toString(i), Integer.toString(i)));
    //     }

    //     for (FlashCard flashCard : deck) {
    //         System.out.println("Term " + flashCard.getTerm() + ": " + "Definition " + flashCard.getDefinition());
    //     }

    //     deck.shuffle();

    //     for (FlashCard flashCard : deck) {
    //         System.out.println("Term " + flashCard.getTerm() + ": " + "Definition " + flashCard.getDefinition());
    //     }

    //     deck.shuffle();

    //     for (FlashCard flashCard : deck) {
    //         System.out.println("Term " + flashCard.getTerm() + ": " + "Definition " + flashCard.getDefinition());
    //     }
    // }

    @Override
    public void start(Stage stage) throws Exception {
        // Create the main user interface.
        int horizontalAndVerticalGapInPixels = 27;
        GridPane mainGridPane = new GridPane();
        mainGridPane.setPadding(new Insets(horizontalAndVerticalGapInPixels));
        mainGridPane.setHgap(horizontalAndVerticalGapInPixels);
        mainGridPane.setVgap(horizontalAndVerticalGapInPixels);

        // Add term and definition text areas to the main user interface.
        GridPane termAndDefinitionGridPane = new GridPane();
        termAndDefinitionGridPane.setHgap(horizontalAndVerticalGapInPixels);
        termAndDefinitionGridPane.setVgap(horizontalAndVerticalGapInPixels);
        Label termLabel = new Label("Term:");
        GridPane.setHalignment(termLabel, HPos.RIGHT);
        termAndDefinitionGridPane.add(termLabel, 0, 0);
        termAndDefinitionGridPane.add(termTextField, 1, 0);
        Label definitionLabel = new Label("Definition:");
        GridPane.setHalignment(definitionLabel, HPos.RIGHT);
        termAndDefinitionGridPane.add(definitionLabel, 0, 1);
        // GridPane.setRowSpan(definitionTextArea, 4);
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

        // Set the properties of the user interface.
        mainGridPane.setAlignment(Pos.CENTER);
        termTextField.setEditable(false);
        definitionTextArea.setEditable(false);

        // Process events.
        addNewCardButton.setOnAction(e -> System.out.println("addNewCardButton"));
        shuffleCardsButton.setOnAction(e -> System.out.println("shuffleButton"));
        showDefinitionButton.setOnAction(e -> System.out.println("showDefinitionButton"));
        nextCardButton.setOnAction(e -> System.out.println("nextCardButton"));
        previousCardButton.setOnAction(e -> System.out.println("previousCardButton"));

        // Create a scene and place it in the stage.
        Scene scene = new Scene(mainGridPane);
        stage.setScene(scene);
        stage.setTitle("Study Buddy");
        stage.show();

        Deck deck = new Deck();
        for (int i = 0; i < 10; i++) {
            deck.add(new FlashCard(Integer.toString(i), Integer.toString(i)));
        }

        for (FlashCard flashCard : deck) {
            System.out.println("Term " + flashCard.getTerm() + ": " + "Definition " + flashCard.getDefinition());
        }

        deck.shuffle();

        for (FlashCard flashCard : deck) {
            System.out.println("Term " + flashCard.getTerm() + ": " + "Definition " + flashCard.getDefinition());
        }

        deck.shuffle();

        for (FlashCard flashCard : deck) {
            System.out.println("Term " + flashCard.getTerm() + ": " + "Definition " + flashCard.getDefinition());
        }
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
