package Lekce_2023_03_14;

public class Strom {
    String name;
    Strom left = null;
    Strom right = null;

    public Strom(String name, Strom left, Strom right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Strom s = new Strom("A", new Strom("B", new Strom("C", null, null), null), new Strom("D", null, null));

        UkazovatkoStrom u = new UkazovatkoStrom(s);
        while (u.hasNext()) {
            System.out.println(u.next());
        }
    }
}
