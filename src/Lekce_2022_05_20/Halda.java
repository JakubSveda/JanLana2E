package Lekce_2022_05_20;

import java.util.ArrayList;

public class Halda {
    private ArrayList<Integer> halda = new ArrayList<>();

    public Halda() {
    }

    public void add(int number) {
        if (halda.isEmpty()) {
            halda.add(number);
            return;
        }

        halda.add(number);
        int myIdx = halda.size() - 1;
        int parentIdx = (myIdx - 1) / 2;
        while (halda.get(myIdx) > halda.get(parentIdx)) {
            switchNumbersByIndex(myIdx, parentIdx);
            myIdx = parentIdx;
            parentIdx = (myIdx - 1) / 2;
        }
    }

    private void switchNumbersByIndex(int a, int b) {
        int change = halda.get(a);
        halda.set(a, halda.get(b));
        halda.set(b, change);
    }

    public int getFirst() {
        return halda.get(0);
    }

    public void removeNumber(int number) {

    }

    public void removeIndex(int index) {

    }

    @Override
    public String toString() {
        return halda.toString();
    }

    public static void main(String[] args) {
        Halda heap = new Halda();
        heap.add(12);
        heap.add(2);
        heap.add(4);
        heap.add(1);
        heap.add(6);
        heap.add(3);
        System.out.println(heap);
    }
}
