package Lekce_2023_05_17;

import java.lang.annotation.Annotation;
import java.util.Scanner;

@Deprecated
public class Anotace {
    String jmeno, prijmeni;

    public Anotace(String jmeno, String prijmeni) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
    }

    @Override
    public String toString() {
        return "Anotace{" +
                "jmeno='" + jmeno + '\'' +
                ", prijmeni='" + prijmeni + '\'' +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Anotace an = new Anotace("jakub", "sveda");
        System.out.println(an);

        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();

        Class<?> myClass = Class.forName(className);
        for (Annotation a: myClass.getAnnotations()) {
            if (a != null && a.annotationType() == Deprecated.class) {
                System.out.println("zastaralé třídy nepoužívám!!\n");
            }
        }
    }
}
