package Ukoly.OlympiadaP;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class plot {
    private static final int MAX_PLANKS = 250000;
    private static final int MAX_DAYS = MAX_PLANKS;
    private static final long MAX_COLORS = 1000000000;
    private static int days, testType;
    private static long[] planks;
    private static int[] lastSeen;

    private static HashMap<Long, Integer> helpMap;

    public static void main(String[] args) {
        initialRead();
        if (testType == 1)
            System.out.println(test1());
        else
            test2();
    }

    private static void initialRead() {
        Scanner scan = new Scanner(System.in);
        testType = scan.nextInt();
        planks = new long[scan.nextInt()];
        lastSeen = new int[planks.length];
        days = scan.nextInt();
        helpMap = new HashMap<>();

        for (int i = 0; i < planks.length; i++) {
            planks[i] = scan.nextInt();
            lastSeen[i] = helpMap.getOrDefault(planks[i], -1);
            helpMap.put(planks[i], i);
        }
    }

    public static void testInitialRead(int myTestType, int myDays, long[] myPlanks) {
        testType = myTestType;
        planks = myPlanks;
        lastSeen = new int[planks.length];
        days = myDays;
        helpMap = new HashMap<>();

        for (int i = 0; i < planks.length; i++) {
            lastSeen[i] = helpMap.getOrDefault(planks[i], -1);
            helpMap.put(planks[i], i);
        }
    }

    /*
    Pro testy s t = 2 vypište dále d řádků popisujících libovolný postup malování, kterým tohoto výsledku dosáhnete.
    Na j-tém z nich vypište dvě celá čísla: Číslo bj laťky přebarvené j-tý den a číslo gj nové barvy této laťky.
    Připomínáme, že nová barva se vždy musí lišit od aktuální barvy laťky.
     */
    public static void test2() {
        //System.out.println("Test barvení");
        long fillNumber = -1;
        int fillNumberIdx = -1, fillNumberLength = 0;

        // dní je více jak planěk ==> možné přebarvit na barvu, která ještě na plotě není
        if (days >= planks.length) {
            Arrays.sort(planks);

            for (int i = 1; i < planks.length; i++) {
                if (planks[i - 1] + 1 != planks[i]) {
                    fillNumber = planks[i - 1] + 1;
                    break;
                }
            }

            if (fillNumber == -1)
                fillNumber = (planks[planks.length - 1] == MAX_COLORS) ? 1 : (planks[planks.length - 1] + 1);

            for (int i = 0; i < planks.length; i++)
                System.out.println(i + " " + fillNumber);
        }

        helpMap = new HashMap<>();
        HashMap<Long, Integer> remainingDaysForPlankColor = new HashMap<>();

        for (int i = planks.length - 1; i >= 0; i--) {
            int remainingDays = remainingDaysForPlankColor.getOrDefault(planks[i], days);
            int space = i - lastSeen[i] - 1;
            if (lastSeen[i] == -1) {
                int sequence = helpMap.getOrDefault(planks[i], 1) + remainingDays;
                //System.out.println("here (==-1): " + planks[i] + ", " + sequence);
                if (planks.length >= sequence) {
                    if (sequence > fillNumberLength) {
                        fillNumber = planks[i];
                        fillNumberIdx = i;
                        fillNumberLength = sequence;
                    }
                } else {
                    int finalSequence = (sequence - planks.length == 1) ? (planks.length - 1) : planks.length;
                    if (finalSequence > fillNumberLength) {
                        fillNumber = planks[i];
                        fillNumberIdx = i;
                        fillNumberLength = finalSequence;
                    }
                }
            } else if (space == 0) {
                helpMap.put(planks[i], helpMap.getOrDefault(planks[i], 1) + 1);
                //System.out.println("here (==0): " + planks[i]);
            } else if (remainingDays < space) {
                int sequence = helpMap.getOrDefault(planks[i], 1) + remainingDays;

                if (sequence > fillNumberLength) {
                    fillNumber = planks[i];
                    fillNumberIdx = i;
                    fillNumberLength = sequence;
                }

                helpMap.remove(planks[i]);
                remainingDaysForPlankColor.put(planks[i], days);
                //System.out.println("here (<): " + planks[i]);
            } else {
                helpMap.put(planks[i], (helpMap.getOrDefault(planks[i], 1) + space + 1));
                int newRemainingDays = remainingDays - space;
                //System.out.print("here (>=): " + planks[i] + ", ");
                if (newRemainingDays != 0) {
                    remainingDaysForPlankColor.put(planks[i], newRemainingDays);
                    int sequence = helpMap.get(planks[i]) + newRemainingDays;
                    //System.out.print(" :seq: " + sequence);
                    if (planks.length >= sequence) {
                        if (sequence > fillNumberLength) {
                            fillNumber = planks[i];
                            fillNumberIdx = i;
                            fillNumberLength = sequence;
                        }
                    } else {
                        int finalSequence = (sequence - planks.length == 1) ? (planks.length - 1) : planks.length;
                        if (finalSequence > fillNumberLength) {
                            fillNumber = planks[i];
                            fillNumberIdx = i;
                            fillNumberLength = finalSequence;
                        }
                    }

                    //System.out.print(" :here (!=0)\n");
                    continue;
                }
                //System.out.println(helpMap.get(planks[i]) + "\n");

                if (helpMap.get(planks[i]) > fillNumberLength) {
                    fillNumber = planks[i];
                    fillNumberIdx = i;
                    fillNumberLength = helpMap.get(planks[i]);
                }

                helpMap.remove(planks[i]);
                remainingDaysForPlankColor.put(planks[i], days);
            }
        }
        System.out.println(fillNumberLength);

        for (int i = fillNumberIdx; i >= 0 && days > 0; i--) {
            if (planks[i] != fillNumber) {
                System.out.println(i + " " + fillNumber);
                days--;
            }
        }

        if (days != 0) {
            for (int i = fillNumberIdx; i < planks.length && days > 0; i++) {
                if (planks[i] != fillNumber) {
                    System.out.println(i + " " + fillNumber);
                    days--;
                }
            }
        }

        if (days != 0) {
            for (int i = 0, j = fillNumberIdx + i + 1; i < days && j < planks.length; i++, j++) {
                if (planks[j] != fillNumber) {
                    System.out.println(j + " " + fillNumber);
                    days--;
                }
            }
        }

        if (days > 1) {
            boolean boo = true;
            int helpPlank1 = (fillNumber == 1) ? 2 : 1;
            int helpPlank2 = (fillNumber == 3) ? 4 : 3;
            for (int i = 0; i < days - 1; i++) {
                System.out.println(0 + " " + ((boo) ? helpPlank1 : helpPlank2));
                boo = !boo;
            }

            System.out.println(0 + " " + fillNumber);
        }

        if (days == 1) {
            System.out.println(0 + " " + ((fillNumber == 1) ? 2 : 1));
        }
    }

    public static int test1() {
        //System.out.println("Test délky");

//        System.out.println(Arrays.toString(planks));
//        System.out.println(Arrays.toString(lastSeen));
//        System.out.println(helpMap + "\n");

        if (days >= planks.length)
            return planks.length;

        helpMap = new HashMap<>();
        HashMap<Long, Integer> remainingDaysForPlankColor = new HashMap<>();
        HashMap<Long, Integer> maxSequences = new HashMap<>();

        for (int i = planks.length - 1; i >= 0; i--) {
            int remainingDays = remainingDaysForPlankColor.getOrDefault(planks[i], days);
            int space = i - lastSeen[i] - 1;
            if (lastSeen[i] == -1) {
                int sequence = helpMap.getOrDefault(planks[i], 1) + remainingDays;
                //System.out.println("here (==-1): " + planks[i] + ", " + sequence);
                if (planks.length >= sequence)
                    maxSequences.put(planks[i], Math.max(maxSequences.getOrDefault(planks[i], 0), sequence));
                else
                    maxSequences.put(planks[i], (sequence - planks.length == 1) ? (planks.length - 1) : planks.length);
            } else if (space == 0) {
                helpMap.put(planks[i], helpMap.getOrDefault(planks[i], 1) + 1);
                //System.out.println("here (==0): " + planks[i]);
            } else if (remainingDays < space) {
                int sequence = helpMap.getOrDefault(planks[i], 1) + remainingDays;
                maxSequences.put(planks[i], Math.max(maxSequences.getOrDefault(planks[i], 0), sequence));
                helpMap.remove(planks[i]);
                remainingDaysForPlankColor.put(planks[i], days);
                //System.out.println("here (<): " + planks[i]);
            } else {
                helpMap.put(planks[i], (helpMap.getOrDefault(planks[i], 1) + space + 1));
                int newRemainingDays = remainingDays - space;
                //System.out.print("here (>=): " + planks[i] + ", ");
                if (newRemainingDays != 0) {
                    remainingDaysForPlankColor.put(planks[i], newRemainingDays);
                    int sequence = helpMap.get(planks[i]) + newRemainingDays;
                    //System.out.print(" :seq: " + sequence);
                    if (planks.length >= sequence)
                        maxSequences.put(planks[i], sequence);
                    else
                        maxSequences.put(planks[i], (sequence - planks.length == 1) ? (planks.length - 1) : planks.length);

                    //System.out.print(" :here (!=0)\n");
                    continue;
                }
                //System.out.println(helpMap.get(planks[i]) + "\n");

                maxSequences.put(planks[i], Math.max(maxSequences.getOrDefault(planks[i], 0), helpMap.get(planks[i])));
                helpMap.remove(planks[i]);
                remainingDaysForPlankColor.put(planks[i], days);
            }
        }

        //System.out.println(maxSequences);

        return Collections.max(maxSequences.values());
    }
}
