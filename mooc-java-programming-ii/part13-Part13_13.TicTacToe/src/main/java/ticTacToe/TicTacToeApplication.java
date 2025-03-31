package ticTacToe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    // true - X, false - O
    private boolean isX;
    private char[][] board;
    private int count;
    private boolean isEnd;

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage stage) {
        isX = true; // X turn
        board = new char[3][3];
        count = 0;
        isEnd = false;

        BorderPane layout = new BorderPane();
        Label topInfo = new Label("Turn: X");
        topInfo.setFont(Font.font("Monospaced", 40));
        layout.setTop(topInfo);

        GridPane grid = new GridPane();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int row = i, col = j;
                Button btn = new Button(" ");
                btn.setFont(Font.font("Monospaced", 40));
                btn.setOnAction((ev) -> onClick(ev, topInfo, btn, row, col));
                grid.add(btn, row, col);
            }
        }
        layout.setCenter(grid);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

    private void onClick(ActionEvent ev, Label topInfo, Button sender, int row, int col) {
        if (!sender.getText().equals(" ") || isEnd) {
            return;
        }

        sender.setText(getPlayerChar());

        var playerChar = getPlayerChar().toCharArray()[0];
        board[row][col] = playerChar;

        if (isWin(row, col, playerChar) || count == 8) {
            topInfo.setText("The end!");
            isEnd = true;
            return;
        }

        togglePlayer(topInfo);
        ++count;
    }

    private void togglePlayer(Label topInfo) {
        isX = !isX;
        topInfo.setText("Turn: " + getPlayerChar());
    }

    private String getPlayerChar() {
        return isX ? "X" : "O";
    }

    private boolean isWin(int row, int col, char player) {
        if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
            return true;
        }
        if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
            return true;
        }
        if (row == col && board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        return row + col == 2 && board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }
}
