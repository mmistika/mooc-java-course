package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView implements View {

    final Dictionary dict;

    public InputView(Dictionary dict) {
        this.dict = dict;
    }

    @Override
    public Parent getView() {
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        TextField wordField = new TextField();
        TextField translationField = new TextField();
        Button addButton = new Button("Add the word pair");

        layout.add(new Label("Word"), 0, 0);
        layout.add(wordField, 0, 1);
        layout.add(new Label("Translation"), 0, 2);
        layout.add(translationField, 0, 3);
        layout.add(addButton, 0, 4);

        addButton.setOnMouseClicked((ev) -> {
            String word = wordField.getText();
            String translation = translationField.getText();

            dict.add(word, translation);

            wordField.clear();
            translationField.clear();
        });

        return layout;
    }

}
