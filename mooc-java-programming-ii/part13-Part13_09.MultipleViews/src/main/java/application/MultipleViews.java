package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    private Stage stage;
    private Scene scene1;
    private Scene scene2;
    private Scene scene3;

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.constructView1();
        this.constructView2();
        this.constructView3();
        
        this.stage.setScene(this.scene1);
        this.stage.show();
    }

    private void constructView1() {
        BorderPane l = new BorderPane();
        this.scene1 = new Scene(l);
        
        l.setTop(new Label("First view!"));
        
        Button btn = new Button("To the second view!");
        l.setCenter(btn);

        btn.setOnAction((ev) -> this.stage.setScene(this.scene2));
    }

    private void constructView2() {
        VBox l = new VBox();
        this.scene2 = new Scene(l);
        
        Button btn = new Button("To the third view!");
        l.getChildren().add(btn);
        
        l.getChildren().add(new Label("Second view!"));

        btn.setOnAction((ev) -> this.stage.setScene(this.scene3));
    }

    private void constructView3() {
        GridPane l = new GridPane();
        this.scene3 = new Scene(l);
        
        l.add(new Label("Third view!"), 0, 0);
        
        Button btn = new Button("To the first view!");
        l.add(btn, 1, 1);
        
        btn.setOnAction((ev) -> this.stage.setScene(this.scene1));
    }
}
