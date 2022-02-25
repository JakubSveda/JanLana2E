package Lekce_2022_02_11.Pisemka;

public class Hydra extends Thread {

    public Hydra(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName());
        if (Integer.parseInt(getName()) == 8) {
            return;
        }
        int newNumber = Integer.parseInt(getName());
        newNumber++;
        String newName = "" + newNumber;
        new Hydra(newName).start();
        new Hydra(newName).start();
    }

    public static void main(String[] args) {
        new Hydra("1").start();
    }
}
