package KurzProgramovani.grafika;

public class Malovani extends Gyarab2D {

    private void renderAxis() {
        for (int i = -maxXY; i < maxXY; i++) {
            namalujBod(i, 0);
            namalujBod(0, i);
        }
    }






    @Override
    public boolean maluj(int idx) {
        renderAxis();

        Matrix posunDolu = Matrix.transposition(-50, -50);
        double ANGLE = Math.PI/100;
        Matrix otoceni = Matrix.rotation(ANGLE);
        Matrix posunNahoru = Matrix.transposition(50, 50);
        Matrix transformace = posunNahoru.times(otoceni).times(posunDolu);

        transformLine(transformace, 0, maxXY, 50);

        return false;
    }




    private void transformLine(Matrix transform, int startX, int endX, int defaultY) {
        Matrix bod = new Matrix(3, 1);

        for (int i = startX; i < endX; i++) {
            bod.setPointInMatrix(i, defaultY);

            Matrix m = transform.times(bod);
            int x = (int) m.get(0, 0);
            int y = (int) m.get(1, 0);
            namalujBod(x, y);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
