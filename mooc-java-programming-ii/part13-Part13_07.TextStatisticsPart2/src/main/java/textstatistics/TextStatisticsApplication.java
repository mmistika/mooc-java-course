package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage stage) {
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane);

        TextArea input = new TextArea();
        pane.setCenter(input);

        HBox box = new HBox();
        box.setSpacing(15);

        Label letters = new Label("Letters: 0");
        box.getChildren().add(letters);

        Label words = new Label("Words: 0");
        box.getChildren().add(words);

        Label longest = new Label("The longest word is: ");
        box.getChildren().add(longest);

        pane.setBottom(box);

        input.textProperty().addListener((change, oldValue, newValue) -> {
            letters.setText("Letters: " + newValue.length());

            final var wordList = newValue.trim().split(" ");
            words.setText("Words: " + wordList.length);

            final var longestWord = Arrays.stream(wordList)
                    .max((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                    .orElse("");
            longest.setText("The longest word is: " + longestWord);
        });

        stage.setScene(scene);
        stage.show();
    }

}
