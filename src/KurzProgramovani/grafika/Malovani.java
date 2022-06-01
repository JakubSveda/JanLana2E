package KurzProgramovani.grafika;

public class Malovani extends Gyarab2D {

    @Override
    public boolean maluj(int idx) {
        // render axis
        for (int i = -maxXY; i < maxXY; i++) {
            namalujBod(i, 0);
            namalujBod(0, i);
        }

        Matrix rotace = Matrix.rotation(Math.PI/6);
        Matrix bod = new Matrix(1, 3);

        for (int i = 0; i < maxXY; i++) {
            bod.setPointInMatrix(i, 0);
            namalujBod(i, 0);
        }
        return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
