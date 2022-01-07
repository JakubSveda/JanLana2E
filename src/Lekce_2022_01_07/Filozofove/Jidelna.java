package Lekce_2022_01_07.Filozofove;

public class Jidelna {
    public static void main(String[] args) throws InterruptedException {
        Vidlicka left = new Vidlicka("levá");
        Vidlicka right = new Vidlicka("pravá");

        Filozof jan = new Filozof(left, right, "Jan");
        Filozof jakub = new Filozof(left, right, "Jakub");

        jan.start();
        jakub.start();
    }
}
