package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class SavingsCalculatorApplication extends Application {

    public void start(Stage window) {
        VBox sliders = new VBox();

        BorderPane savingsUI = new BorderPane();
        Label savingsLabel = new Label("Monthly savings");
        Label savingsValue = new Label("25.0");
        Slider savingsSlider = new Slider(25, 250, 25);
        savingsSlider.setShowTickMarks(true);
        savingsSlider.setShowTickLabels(true);
        savingsSlider.setMajorTickUnit(25);
        savingsUI.setLeft(savingsLabel);
        savingsUI.setCenter(savingsSlider);
        savingsUI.setRight(savingsValue);

        BorderPane interestUI = new BorderPane();
        Label interestLabel = new Label("Yearly interest rate");
        Label interestValue = new Label("0.0");
        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setShowTickMarks(true);
        interestSlider.setShowTickLabels(true);
        interestSlider.setMajorTickUnit(1);
        interestUI.setLeft(interestLabel);
        interestUI.setCenter(interestSlider);
        interestUI.setRight(interestValue);

        sliders.getChildren().addAll(savingsUI, interestUI);

        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Savings");
        chart.setLegendVisible(false);

        XYChart.Series<Number, Number> savingsLine = new XYChart.Series<>();
        XYChart.Series<Number, Number> interestLine = new XYChart.Series<>();
        chart.getData().addAll(savingsLine, interestLine);

        savingsSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            savingsValue.setText(String.format("%.1f", newVal));
            updateChart(savingsLine, yAxis, savingsSlider.getValue(), interestSlider.getValue(), false);
            updateChart(interestLine, yAxis, savingsSlider.getValue(), interestSlider.getValue(), true);
        });

        interestSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            interestValue.setText(String.format("%.1f", newVal));
            updateChart(interestLine, yAxis, savingsSlider.getValue(), interestSlider.getValue(), true);
        });

        updateChart(savingsLine, yAxis, savingsSlider.getValue(), interestSlider.getValue(), false);
        updateChart(interestLine, yAxis, savingsSlider.getValue(), interestSlider.getValue(), true);
        
        BorderPane layout = new BorderPane();
        layout.setTop(sliders);
        layout.setCenter(chart);

        window.setScene(new Scene(layout, 640, 480));
        window.show();
    }

    private void updateChart(XYChart.Series<Number, Number> series, NumberAxis yAxis,
                             double monthly, double interest, boolean applyInterest) {
        series.getData().clear();
        double rate = applyInterest ? interest / 100 : 0;
        double savings = 0;
        double max = 0;

        for (int year = 0; year <= 30; year++) {
            if (year > 0) {
                savings = (savings + monthly * 12) * (1 + rate);
            }
            series.getData().add(new XYChart.Data<>(year, savings));
            if (savings > max) max = savings;
        }

        yAxis.setUpperBound(Math.ceil(max / 1000) * 1000);
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }
}
