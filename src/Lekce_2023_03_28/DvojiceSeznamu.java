package Lekce_2023_03_28;

import java.util.HashSet;
import java.util.Set;

public class DvojiceSeznamu<T extends Set<?>> {
    T set1;
    T set2;

    public DvojiceSeznamu(T set1, T set2) {
        this.set1 = set1;
        this.set2 = set2;
    }

    public Set<?> min() {
        return set1.size() < set2.size() ? set1 : set2;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        Set<String> set2 = new HashSet<>();
        set2.add("ahoj");

        DvojiceSeznamu<Set<?>> dvojiceSeznamu = new DvojiceSeznamu<>(set1, set2);


        System.out.println(dvojiceSeznamu.min());
    }
}
