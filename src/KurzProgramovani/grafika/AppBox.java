package KurzProgramovani.grafika;


import javafx.scene.paint.Color;

public class AppBox extends Gyarab2D {

    private void renderAxis() {
        for (int i = -maxXY; i < maxXY; i++) {
            namalujBod(i, 0);
            namalujBod(0, i);
        }
    }

    private Matrix rotaceY(double angle) {
        Matrix m = new Matrix(4, 4);
        m.set(0, 0, Math.cos(angle));
        m.set(0, 2, Math.sin(angle));
        m.set(1, 1, 1);
        m.set(2, 0, -Math.sin(angle));
        m.set(2, 2, Math.cos(angle));
        m.set(3, 3, 1);
        return m;
    }

    private void myPoint(Matrix transform, Matrix point, int x, int y, int z) {
        point.setPointInMatrix(x, y, z);

        Matrix m = transform.times(point);
        int finalx = (int) m.get(0, 0);
        int finaly = (int) m.get(1, 0);
        //int finalz = (int) m.get(2, 0);
        namalujBod(finalx, finaly);
    }

    @Override
    public boolean maluj(int idx) {
        renderAxis();

        double ANGLE = Math.PI / 100 * idx;
        //Color color = Color.RED;
        Matrix bod = new Matrix(4, 1);

        Matrix transform = rotaceY(ANGLE);

        for (int i = 25; i <= 75; i++) {
            myPoint(transform, bod, 25, i, 0);
            myPoint(transform, bod, i, 25, 0);
            myPoint(transform, bod, 75, i, 0);
            myPoint(transform, bod, i, 75, 0);
        }

        return true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
