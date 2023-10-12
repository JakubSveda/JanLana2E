package Lekce_2023_04_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MojeTrida implements Comparable<MojeTrida> {
    private final Class<?> myClass;
    private final int ancestors;

    public MojeTrida(String className) throws ClassNotFoundException {
        this.myClass = Class.forName(className);
        this.ancestors = getSupers(myClass, 0);
    }

    public int getAncestors() {
        return ancestors;
    }

    public String getName() {
        return myClass.getName();
    }

    private int getSupers(Class<?> myClass, int supers) {
        Class<?> ancestor = myClass.getSuperclass();
        if (ancestor == null) {
            return supers;
        }

        return getSupers(ancestor, ++supers);
    }

    @Override
    public int compareTo(MojeTrida anotherClass) {
        int comparison = Integer.compare(this.ancestors, anotherClass.getAncestors());
        if (comparison == 0)
            return this.getName().compareTo(anotherClass.getName());

        return comparison;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        List<MojeTrida> classes = new ArrayList<>();

        boolean end = false;
        while (!end) {
            String str = scan.nextLine();
            if (str.equals("END")) {
                end = true;
                break;
            }
            classes.add(new MojeTrida(str));
        }

        Collections.sort(classes);
        for (MojeTrida cl: classes) {
            System.out.println(cl.getName());
        }
    }
}
