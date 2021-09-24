package Testing;

public class Kata {
    public static void main(String[] args) {
        System.out.println(spinWords("This is sample test"));
        System.out.println(spinWords("I dont know whats wrong"));

    }

    public static String spinWords(String sentence) {
        String finalStr = "";
        for (String s : sentence.split(" ")) {
            if (s.length() >= 5) finalStr += (new StringBuilder(s).reverse().toString());
            else finalStr += s;
        }
        return String.join(finalStr, " ");
    }
}
