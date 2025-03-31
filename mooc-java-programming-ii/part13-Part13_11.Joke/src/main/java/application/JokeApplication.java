package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        Scene scene = new Scene(layout);

        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        Button jokeBtn = new Button("Joke");
        Button answerBtn = new Button("Answer");
        Button explanationBtn = new Button("Explanation");
        menu.getChildren().addAll(jokeBtn, answerBtn, explanationBtn);

        layout.setTop(menu);

        StackPane firstLayout = createView("What do you call a bear with no teeth?");
        StackPane secondLayout = createView("A gummy bear.");
        StackPane thirdLayout = createView("...");

        jokeBtn.setOnAction((event) -> layout.setCenter(firstLayout));
        answerBtn.setOnAction((event) -> layout.setCenter(secondLayout));
        explanationBtn.setOnAction((event) -> layout.setCenter(thirdLayout));

        layout.setCenter(firstLayout);
        stage.setScene(scene);
        stage.show();
    }

    private StackPane createView(String text) {

        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
}
