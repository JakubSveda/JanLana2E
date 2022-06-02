package KurzProgramovani.grafika;

public class AppCaraVyhlazena extends Gyarab2D {
    private void renderAxis() {
        for (int i = -maxXY; i < maxXY; i++) {
            namalujBod(i, 0);
            namalujBod(0, i);
        }
    }

    @Override
    public boolean maluj(int idx) {
        renderAxis();

        float newIndex = (float) idx / 2;
        for (int i = 0; i < maxXY; i++) {
            namalujBod(i, 2 + idx/2, 127);
            namalujBod(i, 1 + idx/2, 0);
            namalujBod(i, idx/2, 127);
        }

        return idx < 200;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
