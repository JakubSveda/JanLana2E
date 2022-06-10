package Lekce_2022_05_20;

import java.util.Arrays;

public class HeapSort {
    private int[] heap;
    private int heapLength;

    public HeapSort(int[] halda) {
        this.heap = halda;
        this.heapLength = halda.length;
        createHeap();
    }

    private void createHeap() {
        for (int i = 0; i < heap.length; i++) {
            add(i);
        }
    }

    public void add(int index) {
        int myIdx = index;
        int parentIdx = (myIdx - 1) / 2;
        while (myIdx != 0 && heap[myIdx] > heap[parentIdx]) {
            switchNumbersByIndex(myIdx, parentIdx);
            myIdx = parentIdx;
            parentIdx = (myIdx - 1) / 2;
        }
    }

    private void switchNumbersByIndex(int a, int b) {
        int change = heap[a];
        heap[a] = heap[b];
        heap[b] = change;
    }

    public int getFirst() {
        return heap[0];
    }

    public void sort() {

        switchNumbersByIndex(0, heapLength);
        int myIdx = 0;
        int rightSonIdx = (myIdx + 1) * 2;
        int leftSonIdx = rightSonIdx - 1;
        int sonIdx = (heap[leftSonIdx] > heap[rightSonIdx]) ? leftSonIdx : rightSonIdx;
        while (myIdx < heapLength) {

        }
    }

    public void removeNumber(int number) {
        int myIdx = heapLength - 1;
        heapLength--;
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }

    public static void main(String[] args) {
        HeapSort heap = new HeapSort(new int[] {1, 13, 20, 5, 4});
        System.out.println(heap);
        //heap.sort();
        System.out.println(heap);
    }
}
