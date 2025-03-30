package textstatistics;

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

        pane.setCenter(new TextArea());
        
        HBox box = new HBox();
        box.getChildren().add(new Label("Letters: 0"));
        box.getChildren().add(new Label("Words: 0"));
        box.getChildren().add(new Label("The longest word is:"));
        pane.setBottom(box);

        stage.setScene(scene);
        stage.show();
    }

}
