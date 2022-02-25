package Lekce_2022_02_25;

import Ukoly.Algoritmy.Kompozice_2E_2021;

public class SoustavyCisel {
    public static void main(String[] args) {
        int[] p = {1, 2, 1, 2, 1};
        System.out.println(intTToTripple(p));
    }

    private static int binToInt(String bin) {
        int out = 0;
        char[] binCharArray = bin.toCharArray();

        for (char c : binCharArray) {
            out = out * 2 + Character.getNumericValue(c);
        }

        return out;
    }

    private static String intToBin(int intValue) {
        String[] characters = {"0", "1"};
        StringBuilder out = new StringBuilder();
        while (intValue != 0) {
            out.insert(0, characters[intValue % 2]);
            intValue /= 2;
        }

        return out.toString();
    }

    private static int hexToInt(String hex) {
        int out = 0;
        char[] hexCharArray = hex.toCharArray();

        for (char c : hexCharArray) {
            out = out * 16 + findInHexArray(c);
        }

        return out;
    }

    private static int findInHexArray(char character) {
        char[] characters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == character) return i;
        }

        return -1;
    }

    private static String intToHex(int intValue) {
        char[] characters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder out = new StringBuilder();
        while (intValue != 0) {
            out.insert(0, characters[intValue % 16]);
            intValue /= 16;
        }

        return out.toString();
    }

    private static String binToHex(String bin) {
        int intValue = binToInt(bin);
        return intToHex(intValue);
    }

    private static String hexToBin(String hex) {
        int intValue = hexToInt(hex);
        return intToBin(intValue);
    }

    private static int intTToTripple(int[] arr) {
        return Kompozice_2E_2021.vypocetPolynomu(3, arr);
    }
}
