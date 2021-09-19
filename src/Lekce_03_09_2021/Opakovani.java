/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lekce_03_09_2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author 2020-e-sveda
 */
public class Opakovani {

    private static Scanner scan = new Scanner(System.in);
    private static String input;
    private static ArrayList<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Number input:");
        input = scan.nextLine();
        
        if (input.isEmpty() || !isNumeric(input)) {
            System.out.println("Wrong input");
        }

        for (char character : input.toCharArray()) {
            numbers.add(Character.getNumericValue(character));
        }
        
        Collections.sort(numbers);
        
        if ((numbers.size() % 2) == 0) {
            System.out.println("Not yet");
        } else {
            System.out.println(numbers.get((int)((numbers.size() / 2) + 0.5)));
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
