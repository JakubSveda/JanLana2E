package KurzProgramovani.Lekce_2022_05_31;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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
    private static final double ORIGIN_X = WIDTH / 2;
    private static final double ORIGIN_Y = HEIGHT / 2;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);

        gc = canvas.getGraphicsContext2D();
        StackPane root = new StackPane();
        root.getChildren().add(canvas);

        Scene sc = new Scene(root);
        primaryStage.setTitle("Vectors");
        primaryStage.setScene(sc);
        primaryStage.show();

        renderAxis();
    }

    public void renderAxis() {
        gc.strokeLine(ORIGIN_X, 0, ORIGIN_X, HEIGHT);
        gc.strokeLine(0, ORIGIN_Y, WIDTH, ORIGIN_Y);
        gc.strokeLine(ORIGIN_X + SCALE, 0, ORIGIN_X + SCALE, HEIGHT);
        gc.setStroke(Color.LIGHTGREY);
        for (int i = 1; i <= MAX_X; i++) {
            gc.strokeLine(ORIGIN_X + i * SCALE, 0, ORIGIN_X + i * SCALE, HEIGHT);
        }
        for (int i = -1; i >= MIN_X ; i--) {
            gc.strokeLine(ORIGIN_X + i * SCALE, 0, ORIGIN_X + i * SCALE, HEIGHT);
        }
        for (int i = 1; i <= MAX_Y; i++) {
            gc.strokeLine(0, ORIGIN_Y + i * SCALE, WIDTH, ORIGIN_Y + i * SCALE);
        }
        for (int i = -1; i >= MIN_Y ; i--) {
            gc.strokeLine(0, ORIGIN_Y + i * SCALE, WIDTH, ORIGIN_Y + i * SCALE);
        }
    }
}
