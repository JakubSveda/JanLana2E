package KurzProgramovani.grafika;

/**
 * Maldebrotova množina.
 *
 * Volně převzato z
 * https://github.com/joni/fractals
 *
 * @author jlana
 */
public class AppMaldebrot extends Gyarab2D {
    @Override
    public boolean maluj(int idx) {
        for (int row = -100; row < 100; row++) {
            for (int col = -100; col < 100; col++) {
                double x = 0, y = 0;
                int n = 0;
                while (x * x + y * y <= 4 && n++ < 254) {
                    double x_new = x * x - y * y + (col + idx)/(1.0 + idx);
                    y = 2 * x * y + (row + idx)/(1.0 + idx);
                    x = x_new;
                }

                namalujBod(col, row, n);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
