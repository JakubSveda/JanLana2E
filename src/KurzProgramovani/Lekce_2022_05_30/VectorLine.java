package KurzProgramovani.Lekce_2022_05_30;

import javafx.scene.shape.Line;
import javafx.stage.Screen;

public class VectorLine extends Line {
    public VectorLine(double startX, double startY, double endX, double endY) {
        double widthMove = Screen.getPrimary().getBounds().getWidth() / 2;
        double heightMove = Screen.getPrimary().getBounds().getHeight() / 2;

        endY = -endY;

        System.out.println("width move" + widthMove);
        System.out.println("height move" + heightMove);
        setStartX(startX + widthMove);
        setStartY(startY + heightMove);
        setEndX(endX + widthMove);
        setEndY(endY + heightMove);

        System.out.println(startX + widthMove);
        System.out.println(startY - heightMove);
        System.out.println(endX + widthMove);
        System.out.println(endY - heightMove);
    }
}
