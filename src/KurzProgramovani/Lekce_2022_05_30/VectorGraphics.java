package KurzProgramovani.Lekce_2022_05_30;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class VectorGraphics extends Application {
    private static ArrayList<Vector> vectors = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("VectorGraphics");
        primaryStage.setFullScreen(true);
        double currentWidth = Screen.getPrimary().getBounds().getWidth();
        double currentHeight = Screen.getPrimary().getBounds().getHeight();
        Line x = new Line(0, currentHeight / 2, currentWidth, currentHeight / 2);
        Line y = new Line(currentWidth / 2, 0, currentWidth / 2, currentHeight);
        //line.setStroke(Color.RED);
        Pane root = new Pane();
        root.getChildren().add(x);
        root.getChildren().add(y);

        if (!vectors.isEmpty()) {
            for (Vector v: vectors) {
                Vector u = v.multiply(20);
                VectorLine line = new VectorLine(0, 0, u.getX(), u.getY());
                Random rand = new Random();
                line.setStroke(v.getC());
                root.getChildren().add(line);
            }
        }

        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }

    public static void add(Vector...vectors) {
        VectorGraphics.vectors.addAll(Arrays.asList(vectors));
    }
}
