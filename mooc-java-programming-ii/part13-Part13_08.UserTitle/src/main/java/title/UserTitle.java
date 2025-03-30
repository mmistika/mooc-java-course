package title;

import javafx.application.Application;
import javafx.stage.Stage;

public class UserTitle extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle(getParameters().getRaw().get(0));
        stage.show();
    }
    
}
