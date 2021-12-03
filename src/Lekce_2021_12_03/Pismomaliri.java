package Lekce_2021_12_03;

public class Pismomaliri extends Thread {
    String text;

    public Pismomaliri(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        super.run();

        for (char c: this.text.toCharArray()) {
            System.out.print(c);
            if (!Character.isWhitespace(c)) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Pismomaliri("Nazdar").start();
        new Pismomaliri("Hello").start();
    }
}
