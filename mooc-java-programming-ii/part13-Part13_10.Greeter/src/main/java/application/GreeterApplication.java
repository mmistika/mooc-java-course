package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage stage) {
        GridPane l = new GridPane();
        l.setPrefSize(300, 180);
        l.setAlignment(Pos.CENTER);
        l.setVgap(10);
        l.setPadding(new Insets(20, 20, 20, 20));

        Scene scene = new Scene(l);

        l.add(new Label("Enter your name and start."), 0, 0);

        TextField input = new TextField();
        l.add(input, 0, 1);

        Button btn = new Button("Start");
        l.add(btn, 0, 2);

        GridPane l2 = new GridPane();
        l2.setPrefSize(300, 180);
        l2.setAlignment(Pos.CENTER);
        l2.setVgap(10);
        l2.setPadding(new Insets(20, 20, 20, 20));

        Scene scene2 = new Scene(l2);

        Label label = new Label();
        l2.add(label, 0, 0);

        btn.setOnAction((ev) -> {
            label.setText("Welcome " + input.getText() + "!");
            stage.setScene(scene2);
        });

        stage.setScene(scene);
        stage.show();
    }
}
