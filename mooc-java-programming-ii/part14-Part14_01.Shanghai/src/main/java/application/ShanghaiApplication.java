package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage stage) {
        NumberAxis axisX = new NumberAxis("Year", 2006, 2018, 1);
        NumberAxis axisY = new NumberAxis("Ranking", 0, 100, 10);
        
        LineChart chart = new LineChart(axisX, axisY);
        chart.setTitle("University of Helsinki, Shanghai ranking");
        
        XYChart.Series ranking = new XYChart.Series<>();
        ranking.getData().add(new XYChart.Data(2007, 73));
        ranking.getData().add(new XYChart.Data(2008, 68));
        ranking.getData().add(new XYChart.Data(2009, 72));
        ranking.getData().add(new XYChart.Data(2010, 72));
        ranking.getData().add(new XYChart.Data(2011, 74));
        ranking.getData().add(new XYChart.Data(2012, 73));
        ranking.getData().add(new XYChart.Data(2013, 76));
        ranking.getData().add(new XYChart.Data(2014, 73));
        ranking.getData().add(new XYChart.Data(2015, 67));
        ranking.getData().add(new XYChart.Data(2016, 56));
        ranking.getData().add(new XYChart.Data(2017, 56));
        chart.getData().add(ranking);
        
        Scene scene = new Scene(chart, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}
