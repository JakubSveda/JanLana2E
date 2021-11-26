package Ukoly.Algoritmy;

public class PrevodSoustav {
    public static void main(String[] args) {
        System.out.println(intToBin(10));
        System.out.println(binToInt("1010"));
        System.out.println(intToHex(15));
        System.out.println(hexToInt("64"));
    }

    private static int binToInt(String bin) {
        int out = 0;
        char[] binCharArray = bin.toCharArray();

        for (int i = 0; i < binCharArray.length; i++) {
            out = out * 2 + Character.getNumericValue(binCharArray[i]);
        }

        return out;
    }

    private static String intToBin(int intValue) {
        String[] characters = {"0", "1"};
        String out = "";
        while (intValue != 0) {
            out = characters[intValue % 2] + out;
            intValue /= 2;
        }

        return out;
    }

    private static int hexToInt(String hex) {
        int out = 0;
        char[] hexCharArray = hex.toCharArray();

        for (int i = 0; i < hexCharArray.length; i++) {
            out = out * 16 + findInHexArray(hexCharArray[i]);
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
        String out = "";
        while (intValue != 0) {
            out = characters[intValue % 16] + out;
            intValue /= 16;
        }

        return out;
    }

    private static String binToHex(String bin) {
        int intValue = binToInt(bin);
        return intToHex(intValue);
    }

    private static String hexToBin(String hex) {
        int intValue = hexToInt(hex);
        return intToBin(intValue);
    }
}
