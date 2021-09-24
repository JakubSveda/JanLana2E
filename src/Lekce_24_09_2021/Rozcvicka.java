package Lekce_24_09_2021;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Rozcvicka {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        ArrayList<Integer> intList = new ArrayList<>();

        for (char ch : input) {
            if (ch == 'a') intList.add(1);
            else intList.add(0);
        }

        long output = 0;
        Collections.reverse(intList);

        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) != 0) output += Math.pow(2, i);
        }



        System.out.println(output);
    }
}
