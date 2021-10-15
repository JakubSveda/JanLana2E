/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lekce_2021_09_10;

/**
 * @author 2020-e-sveda
 */
public class Kryptogram {
    public static void main(String[] args) {
        for (int s = 1; s < 10; s++) {
            for (int m = 1; m < 10; m++) {
                if (m == s) continue;
                for (int e = 0; e < 10; e++) {
                    for (int n = 0; n < 10; n++) {
                        for (int o = 0; o < 10; o++) {
                            for (int r = 0; r < 10; r++) {
                                for (int d = 0; d < 10; d++) {
                                    for (int y = 0; y < 10; y++) {
                                        int send = (s * 1000 + e * 100 + n * 10 + d);
                                        int more = (m * 1000 + o * 100 + r * 10 + e);
                                        int money = (m * 10000 + o * 1000 + n * 100 + e * 10 + y);

                                        if (send + more == money) {
                                            System.out.println("Send: " + send);
                                            System.out.println("More: " + more);
                                            System.out.println("Money: " + money + "\n");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
