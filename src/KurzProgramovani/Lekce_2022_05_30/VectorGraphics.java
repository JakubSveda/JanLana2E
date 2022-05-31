package KurzProgramovani.Lekce_2022_05_30;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class VectorGraphics extends Application {
    private static ArrayList<Vector> vectors = new ArrayList<>();
    private static final double SCALE = 30;

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
        x.setStroke(Color.BLACK);
        Line y = new Line(currentWidth / 2, 0, currentWidth / 2, currentHeight);
        y.setStroke(Color.BLACK);

        //line.setStroke(Color.RED);
        Pane root = new Pane();

        for (int i = 0; i < currentWidth / 2; i+=SCALE) {
            VectorLine l = new VectorLine(i, currentHeight/2, i, -currentHeight / 2);
            l.setStroke(Color.LIGHTGRAY);
            root.getChildren().add(l);
        }
        for (int i = 0; i >= -currentWidth / 2; i-=SCALE) {
            VectorLine l = new VectorLine(i, currentHeight/2, i, -currentHeight / 2);
            l.setStroke(Color.LIGHTGRAY);
            root.getChildren().add(l);
        }
        for (int i = 0; i <= currentHeight / 2; i+=SCALE) {
            VectorLine l = new VectorLine(-currentWidth / 2, i, currentWidth / 2, i);
            l.setStroke(Color.LIGHTGRAY);
            root.getChildren().add(l);
        }
        for (int i = 0; i >= -currentHeight / 2; i-=SCALE) {
            VectorLine l = new VectorLine(-currentWidth / 2, i, currentWidth / 2, i);
            l.setStroke(Color.LIGHTGRAY);
            root.getChildren().add(l);
        }

        root.getChildren().add(x);
        root.getChildren().add(y);

        if (!vectors.isEmpty()) {
            for (Vector v: vectors) {
                root.getChildren().add(createVectorLine(v, v.getColor()));
            }
        }

        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }

    public static void add(Vector...vectors) {
        VectorGraphics.vectors.addAll(Arrays.asList(vectors));
    }

    private static VectorLine createVectorLine(Vector vector, Color color) {
        VectorLine line = new VectorLine(0, 0, vector.getX() * SCALE, vector.getY() * SCALE);
        line.setStroke(color);
        return line;
    }

    /*
    private static ArrayList<Vector> =
     */

}
