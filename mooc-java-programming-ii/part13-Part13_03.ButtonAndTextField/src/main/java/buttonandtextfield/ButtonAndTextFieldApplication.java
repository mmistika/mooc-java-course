package buttonandtextfield;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {

    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

    @Override
    public void start(Stage stage) {
        FlowPane group = new FlowPane();
        Scene view = new Scene(group);

        group.getChildren().add(new Button("Button"));
        group.getChildren().add(new TextField());

        stage.setScene(view);
        stage.show();
    }
}
