package Lekce_03_09_2021;


import java.util.Scanner;

public class Trojuhelnik {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Diaphragm size:");
        int triangleSize = scan.nextInt();

        if (triangleSize >= 3) {
            int triangleHeight;
            boolean isEven;

            if (triangleSize % 2 == 0) {
                triangleHeight = triangleSize / 2;
                isEven = true;
            } else {
                triangleHeight = triangleSize / 2 + 1;
                isEven = false;
            }

            if (isEven) {
                for (int i = 0; i < triangleHeight; i++) {
                    if (i == 0) {
                        for (int j = 0; j < triangleSize; j++) {
                            if (j == triangleHeight - 1) {
                                System.out.print("#");
                            } else if (j == triangleHeight) {
                                System.out.print("#");
                                break;
                            } else {
                                System.out.print(" ");
                            }
                        }
                    } else if (i == triangleHeight - 1) {
                        for (int j = 0; j < triangleSize; j++) {
                            System.out.print("#");
                        }
                    } else {
                        for (int j = 0; j < triangleSize; j++) {
                            if (j == triangleHeight - i - 1) {
                                System.out.print("#");
                            } else if (j == triangleHeight + i) {
                                System.out.print("#");
                                break;
                            } else {
                                System.out.print(" ");
                            }
                        }
                    }
                    System.out.println();
                }
            } else {
                for (int i = 0; i < triangleHeight; i++) {
                    if (i == 0) {
                        for (int j = 0; j < triangleSize; j++) {
                            if (j == triangleHeight - 1) {
                                System.out.print("#");
                            } else {
                                System.out.print(" ");
                            }
                        }
                    } else if (i == triangleHeight - 1) {
                        for (int j = 0; j < triangleSize; j++) {
                            System.out.print("#");
                        }
                    } else {
                        for (int j = 0; j < triangleSize; j++) {
                            if (j == triangleHeight - i - 1) {
                                System.out.print("#");
                            } else if (j == triangleHeight + i - 1) {
                                System.out.print("#");
                                break;
                            } else {
                                System.out.print(" ");
                            }
                        }
                    }
                    System.out.println();
                }
            }
        } else {
            System.out.println("Triangle is too small");
        }
    }
}
