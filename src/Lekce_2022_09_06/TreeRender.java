package Lekce_2022_09_06;

public class TreeRender {
    public static void main(String[] args) {
        renderTree(3, 2);
    }

    /*

     *
     ***
     *****

     */

    private static void renderTree(int cols, int amount) {
        int base = 0;
        for (int i = 1; i <= cols; i += 2)
            base += i;

        StringBuilder tree = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < base; j++) {
                if (j == base/2)
                    tree.append("*");
                else if (j == base/2 - i || j == base/2 + i)
                    tree.append("*");
                else
                    tree.append(" ");
            }
            if (cols != i + 1)
                tree.append("\n");
        }

        StringBuilder stonek = new StringBuilder();

        for (int i = 0; i < amount; i++) {
            System.out.println(tree);
        }
        System.out.println(stonek);
    }
}
