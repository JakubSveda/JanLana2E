/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lekce_03_09_2021;

import java.util.Scanner;

/**
 *
 * @author 2020-e-sveda
 */
public class Ctverec {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Velikost strany:");
        int squareSize = scan.nextInt();
        
        for (int i = 0; i < squareSize; i++) {
            if (i == 0 || i == (squareSize - 1)) {
                for (int j = 0; j < squareSize; j++) {
                    System.out.print("#");
                }
                System.out.println();
            } else {
                for (int j = 0; j < squareSize; j++) {
                    if (j == 0 || j == (squareSize - 1)) {
                        System.out.print("#");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
