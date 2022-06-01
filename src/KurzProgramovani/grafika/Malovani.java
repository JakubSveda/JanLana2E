package KurzProgramovani.grafika;

public class Malovani extends Gyarab2D {

    @Override
    public boolean maluj(int idx) {
        // render axis
        for (int i = -maxXY; i < maxXY; i++) {
            namalujBod(i, 0);
            namalujBod(0, i);
        }


        Matrix transformace = Matrix.rotation(Math.PI/6);
        Matrix bod = new Matrix(3, 1);

        for (int i = 0; i < maxXY; i++) {
            bod.setPointInMatrix(i, 50);

            Matrix m = transformace.times(bod);
            int x = (int) m.get(0, 0);
            int y = (int) m.get(1, 0);
            namalujBod(x, y);
        }
        return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
