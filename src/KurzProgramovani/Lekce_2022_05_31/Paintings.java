/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KurzProgramovani.Lekce_2022_05_31;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author kahoun
 */
public class Paintings extends Application {

    public static final double MIN_X = -6;                       // unit
    public static final double MAX_X = 6;                        // unit
    public static final double MIN_Y = -6;                       // unit
    public static final double MAX_Y = 6;                        // unit
    public static final double SCALE = 50;                       // pixel/unit
    public static final double WIDTH = (MAX_X - MIN_X) * SCALE;  // pixel
    public static final double HEIGHT = (MAX_Y - MIN_Y) * SCALE; // pixel
    public static final double ORIGIN_X = WIDTH / 2;             // pixel
    public static final double ORIGIN_Y = HEIGHT / 2;            // pixel
    private static final Point[] HOUSE = {
        new Point(1, 3),
        new Point(1, 1),
        new Point(3, 1),
        new Point(3, 3),
        new Point(1, 3),
        new Point(2, 4),
        new Point(3, 3)
    };
    private GraphicsContext gc;

    private void renderAxis() {
        gc.strokeLine(ORIGIN_X, 0, ORIGIN_X, HEIGHT);
        gc.strokeLine(0, ORIGIN_Y, WIDTH, ORIGIN_Y);
        gc.setStroke(Color.LIGHTGREY);
        for (int i = 1; i <= MAX_X; i++) {
            gc.strokeLine(ORIGIN_X + i * SCALE, 0, ORIGIN_X + i * SCALE, HEIGHT);
        }
        for (int i = -1; i >= MIN_X; i--) {
            gc.strokeLine(ORIGIN_X + i * SCALE, 0, ORIGIN_X + i * SCALE, HEIGHT);
        }
        for (int i = 1; i <= MAX_Y; i++) {
            gc.strokeLine(0, ORIGIN_Y + i * SCALE, WIDTH, ORIGIN_Y + i * SCALE);
        }
        for (int i = -1; i >= MIN_Y; i--) {
            gc.strokeLine(0, ORIGIN_Y + i * SCALE, WIDTH, ORIGIN_Y + i * SCALE);
        }

    }

    private double xUnit2Pixel(double unit) {
        return ORIGIN_X + SCALE * unit;
    }

    private double yUnit2Pixel(double unit) {
        return ORIGIN_Y - SCALE * unit;
    }

    private void renderPolyline(Point[] points) {
        if (points.length < 2) {
            return;
        }
        gc.beginPath();
        gc.moveTo(xUnit2Pixel(points[0].getX()), yUnit2Pixel(points[0].getY()));
        for (int i = 1; i < points.length; i++) {
            gc.lineTo(xUnit2Pixel(points[i].getX()), yUnit2Pixel(points[i].getY()));
        }
        gc.closePath();
        gc.stroke();
    }

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();

        StackPane root = new StackPane();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Paintings");
        primaryStage.setScene(scene);
        primaryStage.show();

        renderAxis();
        gc.setStroke(Color.RED);
        renderPolyline(HOUSE);
        
        Vector u = new Vector(-4, -6);
//        Point[] house2 = u.move(HOUSE);
//        Point[] house2 = Vector.multiply(HOUSE, 2);
        gc.setStroke(Color.BLUE);
        Matrix m1 = Matrix.translate(u);
        Matrix m2 = Matrix.scale(0.5, 0.5);
        Matrix m3 = Matrix.rotation(Math.PI / 4);
        Matrix m = m1.multiply(m2).multiply(m3);
        renderPolyline(Matrix.rotation(u, Math.PI / 4).transform(HOUSE));
        System.out.println(m);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
