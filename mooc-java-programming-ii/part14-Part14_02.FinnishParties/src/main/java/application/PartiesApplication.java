package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage stage) throws IOException {
        NumberAxis x = new NumberAxis(1968, 2008, 4);
        NumberAxis y = new NumberAxis(0, 30, 5);

        LineChart chart = new LineChart(x, y);
        chart.setTitle("Relative support of the parties");

        List<String> lines = Files.readAllLines(Paths.get("partiesdata.tsv"));

        // Parse years
        String[] parts = lines.get(0).split("\t");
        String[] years = Arrays.copyOfRange(parts, 1, parts.length);

        // Parse parties
        for (int i = 1; i < lines.size(); ++i) {
            parts = lines.get(i).split("\t");
            String[] values = Arrays.copyOfRange(parts, 1, parts.length);
            chart.getData().add(createData(parts[0], years, values));
        }
        
        stage.setScene(new Scene(chart, 640, 480));
        stage.show();
    }

    private XYChart.Series createData(String name, String[] years, String[] values) {
        XYChart.Series data = new XYChart.Series();
        data.setName(name);
        for (int i = 0; i < years.length; ++i) {
            if (!values[i].equals("-")) {
                data.getData().add(new XYChart.Data(Integer.parseInt(years[i]), Double.parseDouble(values[i])));
            }
        }
        return data;
    }
}
