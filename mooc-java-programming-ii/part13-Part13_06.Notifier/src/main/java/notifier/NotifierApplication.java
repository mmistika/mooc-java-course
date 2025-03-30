package notifier;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage stage) {
        VBox box = new VBox();
        Scene scene = new Scene(box);

        TextField input = new TextField();
        Button btn = new Button("Update");
        Label label = new Label();

        box.getChildren().add(input);
        box.getChildren().add(btn);
        box.getChildren().add(label);

        btn.setOnAction((ev) -> {
            label.setText(input.getText());
        });

        stage.setScene(scene);
        stage.show();
    }

}
