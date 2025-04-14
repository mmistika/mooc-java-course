package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");

        PixelReader imageReader = sourceImage.getPixelReader();

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter imageWriter = targetImage.getPixelWriter();

        for (int x = 0; x < width; x += 2) {
            for (int y = 0; y < height; y += 2) {
                Color negative = getNegative(imageReader.getColor(x, y));
                
                int xHalf = x / 2;
                int yHalf = y / 2;
                
                for (int dx = 0; dx < 2; ++dx) {
                    for (int dy = 0; dy < 2; ++dy) {
                        int xNew = xHalf + dx * (width / 2);
                        int yNew = yHalf + dy * (height / 2);
                        imageWriter.setColor(xNew, yNew, negative);
                    }
                }
            }
        }

        ImageView image = new ImageView(targetImage);

        Pane pane = new Pane();
        pane.getChildren().add(image);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    private Color getNegative(Color color) {
        double red = 1.0 - color.getRed();
        double green = 1.0 - color.getGreen();
        double blue = 1.0 - color.getBlue();
        double opacity = color.getOpacity();
        return new Color(red, green, blue, opacity);

    }

    public static void main(String[] args) {
        launch(args);
    }

}
