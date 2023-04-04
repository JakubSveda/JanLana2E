package Lekce_2023_03_28;

public class Dvojice<T extends Comparable<T>> implements Comparable<Dvojice<T>> {
    T first;
    T second;

    public Dvojice(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public T min() {
        return first.compareTo(second) < 0 ? first : second;
    }

    @Override
    public String toString() {
        return "Dvojice{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public static void main(String[] args) {
        Dvojice<String> dvaRetezce = new Dvojice<>("str", "Ahoj");
        Dvojice<Integer> dveCisla1 = new Dvojice<>(123, 111);
        Dvojice<Integer> dveCisla2 = new Dvojice<>(123, 110);

        System.out.println(dveCisla1.compareTo(dveCisla2));
    }

    @Override
    public int compareTo(Dvojice<T> o) {
        return this.min().compareTo(o.min());
    }
}
