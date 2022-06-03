package KurzProgramovani.grafika;


public class AppBox extends Gyarab2D {

    private void renderAxis() {
        for (int i = -maxXY; i < maxXY; i++) {
            namalujBod(i, 0);
            namalujBod(0, i);
        }
    }

    private void drawNewPoint(Matrix transform, Matrix point, int x, int y, int z) {
        point.setPointInMatrix(x, y, z);

        Matrix m = transform.times(point);
        double LAST_MATRIX_NUMBER = m.get(3, 0);
        int finalx = (int) (m.get(0, 0) / LAST_MATRIX_NUMBER);
        int finaly = (int) (m.get(1, 0) / LAST_MATRIX_NUMBER);
        //int finalz = (int) (m.get(2, 0) / LAST_MATRIX_NUMBER);
        namalujBod(finalx, finaly);
    }

    @Override
    public boolean maluj(int idx) {
        renderAxis();

        double ANGLE = Math.PI / 100 * idx;
        double SIZE = 2;
        //Color color = Color.RED;
        Matrix point = new Matrix(4, 1);

        Matrix rotation_x = Matrix.rotate3D_X(ANGLE);
        Matrix rotation_y = Matrix.rotate3D_Y(ANGLE);
        Matrix rotation_z = Matrix.rotate3D_Z(ANGLE);

        Matrix resize = Matrix.changeSize3D(SIZE);

        Matrix transform = resize.times(rotation_z);

        int START_X = 25;
        int END_X = 75;
        for (int i = START_X; i <= END_X; i++) {
            drawNewPoint(transform, point, START_X, i, 0);
            drawNewPoint(transform, point, i, START_X, 0);
            drawNewPoint(transform, point, END_X, i, 0);
            drawNewPoint(transform, point, i, END_X, 0);
        }

        return true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
