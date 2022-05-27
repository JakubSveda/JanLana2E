package Lekce_2022_05_20;

import java.util.ArrayList;

public class Halda {
    private ArrayList<Integer> halda = new ArrayList<>();

    public Halda() {
    }

    public void add(int number) {
        if (halda.get(0) == null) {
            halda.set(0, number);
            return;
        }

        int myIdx = halda.size() - 1;
        int parentIdx = (myIdx - 1) / 2;
        if (halda.get(myIdx) < halda.get(parentIdx)) {
            switchNumbersByIndex(myIdx, parentIdx);
        } else {
            return;
        }
    }

    private void switchUntilCorrect(int a, int b) {
        if (halda.get(a) < halda.get(b)) {
            
        }
    }

    private void switchNumbersByIndex(int a, int b) {
        int change = halda.get(a);
        halda.set(a, halda.get(b));
        halda.set(b, change);
    }

    public int getMin() {
        return halda.get(0);
    }

    public void removeNumber(int number) {

    }

    public void removeIndex(int number) {

    }

    @Override
    public String toString() {
        return halda.toString();
    }

    public static void main(String[] args) {
        Halda heap = new Halda();
        heap.add(12);
        System.out.println(heap);
    }
}
