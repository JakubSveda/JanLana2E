package Utils;

public class Doucko {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            getRightTriangle();
        }
    }

    private static int getRandomInt(int rangeStart, int rangeEnd) {
        int range = rangeEnd - rangeStart + 1;
        return (int) Math.floor((Math.random() * range + rangeStart));
    }

    private static void getSquare() {
        int a = getRandomInt(1, 20);
        int circumference = 4 * a;
        int area = a * a;

        System.out.println("----------------------------");
        System.out.println("strana: " + a);
        System.out.println("obvod: " + circumference);
        System.out.println("obsah: " + area);
        System.out.println("----------------------------");
    }

    private static void getRightTriangle() {
        int a = getRandomInt(1, 12);
        int b = getRandomInt(1, 12);
        int c = (int) Math.floor(Math.sqrt((a * a + b * b)));

        System.out.println("----------------------------");
        System.out.println("strany: " + a + ", " + b + ", " + c);
        System.out.println("obvod: " + (a + b + c));
        System.out.println("obsah: " + (a * b / 2));
        System.out.println("----------------------------");
    }
}
