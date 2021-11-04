package Testing;

import java.util.Arrays;
import java.util.Scanner;

public class MocninyMatematika {
    private static double[] arr = {-3, -2.5, -2, -1.5, -1, -0.5, 0, 0.5, 1, 1.5, 2, 2.5, 3};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(powNumbersInArray(arr, 3)));

        arr = new double[]{-3, -2.5, -2, -1.5, -1, -0.5, 0, 0.5, 1, 1.5, 2, 2.5, 3};

        System.out.println(Arrays.toString(powNumbersInArray(arr, 4)));

        arr = new double[]{-3, -2.5, -2, -1.5, -1, -0.5, 0, 0.5, 1, 1.5, 2, 2.5, 3};

        System.out.println(Arrays.toString(powNumbersInArray(arr, 5)));

        arr = new double[]{-3, -2.5, -2, -1.5, -1, -0.5, 0, 0.5, 1, 1.5, 2, 2.5, 3};

        System.out.println(Arrays.toString(powNumbersInArray(arr, 6)));
    }

    private static double[] powNumbersInArray(double[] array, int powValue) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.pow(array[i], powValue);
        }

        return array;
    }
}
