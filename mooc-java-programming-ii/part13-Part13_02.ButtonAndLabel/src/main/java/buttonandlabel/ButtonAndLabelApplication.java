package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

    @Override
    public void start(Stage stage) {
        FlowPane group = new FlowPane();
        Scene view = new Scene(group);
        
        group.getChildren().add(new Label("Label"));
        group.getChildren().add(new Button("Button"));
        
        stage.setScene(view);
        stage.show();
    }

}
