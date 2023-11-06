package Lekce_2023_10_23;

public class Retezec {
    public static void main(String[] args) {
        System.out.println(isSubsequence("ahoj svete", "svete"));
    }

    private static boolean isSubsequence(String a, String b) {
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) == b.charAt(0) && a.startsWith(b, i))
                    return true;

        return false;
    }
}
