package Lekce_2022_06_09;

import java.util.Arrays;

public class HeapSort {
    private int[] heap;

    public HeapSort(int[] halda) {
        this.heap = halda;
        createHeap();
    }

    private void createHeap() {
        for (int i = 0; i < heap.length; i++) {
            add(i);
        }
    }

    public void add(int index) {
        int myIdx = index, parentIdx = (myIdx - 1) / 2;
        while (myIdx > 0 && heap[myIdx] > heap[parentIdx]) {
            swapByIndex(myIdx, parentIdx);
            parentIdx = ((myIdx = parentIdx) - 1) / 2;
        }
    }

    private void swapByIndex(int a, int b) {
        heap[a] = (heap[a] + heap[b]) - (heap[b] = heap[a]);
    }

    public int getFirst() {
        return heap[0];
    }

    public void sort() {
        for (int i = heap.length - 1; i >= 0; i--) {
            if (heap[0] > heap[i])
                swapByIndex(0, i);
            int son, parent = 0, son_L = getLeftSon(parent), son_R = son_L + 1;
            while ((son = getMax(son_L, son_R, i)) != -1) {
                swapByIndex(son, parent);
                son_R = (son_L = getLeftSon(parent = son)) + 1;
            }
        }
    }

    private int getMax(int leftSon, int rightSon, int i) {
        if (leftSon >= i)
            return -1;
        if (rightSon >= i)
            return leftSon;

        return (heap[leftSon] > heap[rightSon]) ? leftSon : rightSon;
    }

    private int getLeftSon(int parent) {
        return parent*2 + 1;
    }

    public void removeNumber(int index) {
        // TODO
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }

    public static void main(String[] args) {
        HeapSort heap = new HeapSort(new int[] {1, 13, 20, 5, 4});
        System.out.println("original heap: " + heap);
        heap.sort();
        System.out.println("sorted heap: " + heap);
    }
}
