Project Name: StudyBuddy powered by Java
Team Name: StudyBuddy
Team Members: Jaskaran Singh & Brendan Spranger

Project Description: This program is a virtual flash card application that can help students study course material. This application was built to help students study key terms and their definitions. This application can be useful for students who want to achieve higher scores in their courses.

How to run the application:
Replace [JAVAFX_FILEPATH] in the line below with the file path of the JavaFX lib folder. Replace [STUDY_BUDDY_FILEPATH] in the line below with the file path of the StudyBuddy.jar file. Then, copy and paste the line below into the command prompt. Make sure to use forward-slashes (/), instead of back-slashes (\), in the file paths.
java --module-path "[JAVAFX_FILEPATH]" --add-modules javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web -jar [STUDY_BUDDY_FILEPATH]/StudyBuddy.jar

How to use the application:
After loading the application, the user will be presented with the application GUI in a window. The two text fields, labeled "term" and "definition" will appear blank until the first flash card is created.

To add the first flash card, simply fill in the term and definition text fields and click the button at the top right corner of the application labeled “add new card”. Additional cards can be created by replacing the text in the term and definition fields and clicking the “add new card” button. If the definition of a term needs to be changed after adding a card, re-type the definition and then click the “add new card” button again.

After adding some flash cards to the deck, click the “shuffle cards” button on the right side of the window. The user is now ready to start studying their terms! Each time a new card is presented, the definition will be hidden. To make the definition appear, click the button labeled “show definition”. To move on to the next term in the deck, click the button labeled “next card”. The previous term can be seen by pressing “previous card”.

The user can add as many flash cards as they would like and they can shuffle the order of the cards at any time. The deck can be cleared by closing and restarting the application.