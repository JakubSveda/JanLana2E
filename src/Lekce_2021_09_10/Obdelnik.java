/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lekce_2021_09_10;

import java.util.Scanner;

/**
 *
 * @author 2020-e-sveda
 */
public class Obdelnik {
    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        String input = scan.nextLine();
        String firstString = "";
        String secondString = "";
        boolean secondPart = false;
        
        for (char character : input.toCharArray()) {
            if (Character.isWhitespace(character)) {
                secondPart = true;
            } else if (!secondPart) {
                firstString += character;
            } else if (secondPart) {
                secondString += character;
            }
        }
        
        int width = Integer.parseInt(firstString);
        int height = Integer.parseInt(secondString);
        
        for (int i = 0; i < height; i++) {
            if (i == 0 || i == height - 1) {
                for (int j = 0; j < width; j++) {
                    System.out.print("+");
                }
            } else {
                for (int j = 0; j < width; j++) {
                    if (j == 0 || j == width - 1) {
                        System.out.print("+");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("");
        }
    }
}
