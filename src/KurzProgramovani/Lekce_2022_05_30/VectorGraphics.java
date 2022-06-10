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
        Pane root = new Pane();

        double currentWidth = Screen.getPrimary().getBounds().getWidth();
        double currentHeight = Screen.getPrimary().getBounds().getHeight();
        Line x = new Line(0, currentHeight / 2, currentWidth, currentHeight / 2);
        x.setStroke(Color.BLACK);
        Line y = new Line(currentWidth / 2, 0, currentWidth / 2, currentHeight);
        y.setStroke(Color.BLACK);

        for (int i = 0; i < currentWidth / 2; i+=SCALE) {
            VectorLine l = new VectorLine(i, currentHeight/2, i, -currentHeight / 2, true);
            l.setStroke(Color.LIGHTGRAY);
            root.getChildren().add(l);
        }
        for (int i = 0; i >= -currentWidth / 2; i-=SCALE) {
            VectorLine l = new VectorLine(i, currentHeight/2, i, -currentHeight / 2, true);
            l.setStroke(Color.LIGHTGRAY);
            root.getChildren().add(l);
        }
        for (int i = 0; i <= currentHeight / 2; i+=SCALE) {
            VectorLine l = new VectorLine(-currentWidth / 2, i, currentWidth / 2, i, true);
            l.setStroke(Color.LIGHTGRAY);
            root.getChildren().add(l);
        }
        for (int i = 0; i >= -currentHeight / 2; i-=SCALE) {
            VectorLine l = new VectorLine(-currentWidth / 2, i, currentWidth / 2, i, true);
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

        ArrayList<VectorLine> HOUSE = createHouse(Color.DARKBLUE);
        for (VectorLine vectorLine: HOUSE) {
            root.getChildren().add(vectorLine);
            System.out.println("House: [" + vectorLine.getStartX() + "; " + vectorLine.getStartY() + "], [" + vectorLine.getEndX() + "; " + vectorLine.getEndY() + "]");
        }

        Vector moveVector = new Vector(-4, -6);
        HOUSE = moveByVector(moveVector, HOUSE.toArray(new VectorLine[HOUSE.size()]));
        for (VectorLine vectorLine: HOUSE) {
            root.getChildren().add(vectorLine);
            System.out.println("House: [" + vectorLine.getStartX() + "; " + vectorLine.getStartY() + "], [" + vectorLine.getEndX() + "; " + vectorLine.getEndY() + "]");
        }

        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }

    public static void add(Vector...vectors) {
        VectorGraphics.vectors.addAll(Arrays.asList(vectors));
    }

    private static VectorLine createVectorLine(Vector vector, Color color) {
        return new VectorLine(0, 0, vector.getX(), vector.getY(), color);
    }

    private static ArrayList<VectorLine> createHouse(Color houseColor) {
        ArrayList<VectorLine> houseLines = new ArrayList<>();

        houseLines.add(new VectorLine(1, 1, 3, 1, houseColor));
        houseLines.add(new VectorLine(1, 1, 1, 3, houseColor));
        houseLines.add(new VectorLine(1, 3, 3, 3, houseColor));
        houseLines.add(new VectorLine(1, 3, 2, 4, houseColor));
        houseLines.add(new VectorLine(2, 4, 3, 3, houseColor));
        houseLines.add(new VectorLine(3, 3, 3, 1, houseColor));

        return houseLines;
    }

    private static ArrayList<VectorLine> moveByVector(Vector moveVector, VectorLine... vectorLinesToMove) {
        ArrayList<VectorLine> vectorLineArrayList = new ArrayList<>();
        double X_MOVE = moveVector.getX();
        double Y_MOVE = moveVector.getY();

        for (VectorLine v : vectorLinesToMove) {
            vectorLineArrayList.add(new VectorLine(v.getStartX() + X_MOVE, v.getStartY() + Y_MOVE, v.getEndX() + X_MOVE, v.getEndY() + Y_MOVE));
        }

        return vectorLineArrayList;
    }

    public static double getScale() {
        return SCALE;
    }

}
