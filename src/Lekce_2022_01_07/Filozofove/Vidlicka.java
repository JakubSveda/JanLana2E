package Lekce_2022_01_07.Filozofove;

public class Vidlicka {
    private String name;

    public Vidlicka(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Vidlicka{" +
                "name='" + name + '\'' +
                '}';
    }
}
