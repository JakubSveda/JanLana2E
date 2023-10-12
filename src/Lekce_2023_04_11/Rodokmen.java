package Lekce_2023_04_11;

import java.util.ArrayList;
import java.util.Collections;

public class Rodokmen {
    public static void main(String[] args) {
        Class<?> cl = String.class;
         printSupers(cl);
        // printInterfaces(cl);
    }

    private static void printSupers(Class<?> cl) {
        Class<?> superClass = cl.getSuperclass();
        if (superClass != null) {
            System.out.println(superClass.getName());
            printSupers(superClass);
        }
    }

    private static void printInterfaces(Class<?> cl) {
        Class<?>[] interfaces = cl.getInterfaces();
        if (interfaces.length > 0) {
            for (Class<?> interfaceCl : interfaces) {
                System.out.println(interfaceCl);
                printInterfaces(interfaceCl);
            }
        }
    }

    private static ArrayList<Class<?>> getInterfaces(Class<?> cl) {
        ArrayList<Class<?>> interfaces = new ArrayList<>();
        //interfaces.addAll(cl.getInterfaces());
        return interfaces;
    }

    private static void getSameInterfaces(Class<?> cl1, Class<?> cl2) {

    }
}
