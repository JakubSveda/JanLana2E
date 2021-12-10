package Ukoly.Bezci;

public class Bezec extends Thread {
    String jmeno;
    double rychlostKilometryZaSekundu;

    public Bezec(String jmeno, double rychlostKilometryZaSekundu) throws ChybnaRychlostBezceException {
        this.jmeno = jmeno;

        float MIN_RYCHLOST_KMH = 5F;
        float MAX_RYCHLOST_KMH = 23.83F;
        double RYCHLOST_KMH = rychlostKilometryZaSekundu * 3600;

        if (RYCHLOST_KMH < MIN_RYCHLOST_KMH) {
            throw new ChybnaRychlostBezceException("Bezec je moc pomalý! -> minRychlost: " + MIN_RYCHLOST_KMH + "km/h");
        } else if (RYCHLOST_KMH > MAX_RYCHLOST_KMH) {
            throw new ChybnaRychlostBezceException("Bezec je moc rychlý! -> maxRychlost: " + MAX_RYCHLOST_KMH + "km/h");
        } else {
            this.rychlostKilometryZaSekundu = rychlostKilometryZaSekundu;
        }
    }

    @Override
    public void run() {
        double rychlostKilometruZaMinutu = (1 / (rychlostKilometryZaSekundu * 60));
        long rychlostProgramu = (long) (rychlostKilometruZaMinutu * 1000);

        for (int i = 1; i <= 4; i++) {
            try {
                Thread.sleep(rychlostProgramu);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Bezec " + this.jmeno + " je na " + i + " kilometru");
        }

        try {
            Thread.sleep(rychlostProgramu);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Bezec " + this.jmeno + " je v cíli s casem " + ((int) Math.floor(5 * rychlostKilometruZaMinutu)));
    }

    private static void zavod() {
        try {
            new Bezec("Jakub", (10F/3600F)).start();
            new Bezec("Usain Bolt", (23F/3600F)).start();
            new Bezec("Zdislava", (8F/3600F)).start();
            new Bezec("Alfons", (15F/3600F)).start();
        } catch (ChybnaRychlostBezceException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        zavod();
    }

    static class ChybnaRychlostBezceException extends Exception {
        public ChybnaRychlostBezceException(String message) {
            super(message);
        }
    }
}
