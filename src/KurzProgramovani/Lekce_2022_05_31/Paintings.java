package KurzProgramovani.Lekce_2022_05_31;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Paintings extends Application {
    private GraphicsContext gc;
    private static final double MIN_X = -6;
    private static final double MIN_Y = 6;
    private static final double MAX_X = -6;
    private static final double MAX_Y = -6;
    private static final double SCALE = 30;
    private static final double WIDTH = (MAX_X - MIN_X) * SCALE;
    private static final double HEIGHT = (MAX_Y - MIN_Y) * SCALE;
    private static final double ORIGIN_X = 30;
    private static final double ORIGIN_Y = 30;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(300, 200);

        gc = canvas.getGraphicsContext2D();
        StackPane root = new StackPane();
        root.getChildren().add(canvas);

        Scene sc = new Scene(root);
        primaryStage.setTitle("Vectors");
        primaryStage.setScene(sc);

    }
}
