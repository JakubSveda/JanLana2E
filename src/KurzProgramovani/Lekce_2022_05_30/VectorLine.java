package KurzProgramovani.Lekce_2022_05_30;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Screen;

public class VectorLine extends Line {
    private final double SCALE = VectorGraphics.getScale();

    public VectorLine(double startX, double startY, double endX, double endY) {
        construct(startX, startY, endX, endY);
    }

    public VectorLine(double startX, double startY, double endX, double endY, boolean classicMove) {
        double widthMove = Screen.getPrimary().getBounds().getWidth() / 2;
        double heightMove = Screen.getPrimary().getBounds().getHeight() / 2;

        System.out.println("width move" + widthMove);
        System.out.println("height move" + heightMove);
        setStartX((startX + widthMove));
        setStartY((startY + heightMove));
        setEndX((endX + widthMove));
        setEndY((endY + heightMove));

        System.out.println(startX + widthMove);
        System.out.println(startY - heightMove);
        System.out.println(endX + widthMove);
        System.out.println(endY - heightMove);
    }

    public VectorLine(double startX, double startY, double endX, double endY, Color color) {
        construct(startX, startY, endX, endY);
        setStroke(color);
    }

    private void construct(double startX, double startY, double endX, double endY) {
        double widthMove = Screen.getPrimary().getBounds().getWidth() / 2;
        double heightMove = Screen.getPrimary().getBounds().getHeight() / 2;

        startY = -startY;
        endY = -endY;

        System.out.println("width move: " + widthMove);
        System.out.println("height move: " + heightMove);
        setStartX((startX*SCALE + widthMove));
        setStartY((startY*SCALE + heightMove));
        setEndX((endX*SCALE + widthMove));
        setEndY((endY*SCALE + heightMove));

        System.out.println(startX + widthMove);
        System.out.println(startY - heightMove);
        System.out.println(endX + widthMove);
        System.out.println(endY - heightMove);
    }
}
