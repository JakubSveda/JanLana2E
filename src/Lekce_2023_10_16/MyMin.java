package Lekce_2023_10_16;

import java.util.Scanner;

public class MyMin {
    public static int min(int x, int y) {
        return (x < y) ? x : y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
        System.out.println(min(numbers[0], numbers[1]));
        System.out.println(min(numbers[0], 1, numbers));
    }

    public static int min(int min, int position, int[] numbers) {
        if (position == numbers.length)
            return min;

        return min(Math.min(min, numbers[position]), position + 1, numbers);
    }
}
