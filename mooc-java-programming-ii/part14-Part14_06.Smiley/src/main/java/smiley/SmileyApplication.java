package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SmileyApplication extends Application {


    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        
        Canvas canvas = new Canvas(640, 480);
        layout.setCenter(canvas);
        
        drawSmile(canvas.getGraphicsContext2D());
        
        stage.setScene(new Scene(layout));
        stage.show();
    }

    private void drawSmile(GraphicsContext painter) {
        int side = 60;
        painter.setFill(Color.BLACK);
        
        painter.fillRect(2*side, side, side, side);
        painter.fillRect(5*side, side, side, side);
        
        painter.fillRect(side, 4*side, side, side);
        painter.fillRect(6*side, 4*side, side, side);
        
        painter.fillRect(2*side, 5*side, 4*side, side);
    }
}
