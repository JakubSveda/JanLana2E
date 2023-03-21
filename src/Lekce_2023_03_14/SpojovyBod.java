package Lekce_2023_03_14;

public class SpojovyBod {
    String name;
    SpojovyBod right = null;

    public SpojovyBod(String name, SpojovyBod right) {
        this.name = name;
        this.right = right;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        SpojovyBod b = new SpojovyBod("Jakub", new SpojovyBod("Pavel", new SpojovyBod("Klára", new SpojovyBod("Jan", null))));

        Ukazovatko i = new Ukazovatko(b);
        while (i.hasNext()) {
            SpojovyBod iPoint = i.next();
            Ukazovatko u = new Ukazovatko(b);
            while(u.hasNext()) {
                SpojovyBod uPoint = u.next();
                if (iPoint.equals(uPoint))
                    continue;

                System.out.print(iPoint + "--" + uPoint + "\n");
            }
        }
    }
}
