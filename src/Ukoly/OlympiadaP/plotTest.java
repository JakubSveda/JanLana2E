package Ukoly.OlympiadaP;

import org.junit.Test;

import java.util.Arrays;

import static Ukoly.OlympiadaP.plot.testInitialRead;
import static org.junit.Assert.assertEquals;

public class plotTest {

    @Test
    public void test2() {

    }

    @Test
    public void test1() {
        for (int i = 0; i < 10; i++) {
            long[] planks = new long[10];
            for (int j = 0; j < planks.length; j++) {
                planks[j] = (int) Math.round(Math.random() * 9) + 1;
            }

            testInitialRead(1, 6, planks);
            int result = plot.test1();
            System.out.println(Arrays.toString(planks));
            System.out.println(result + "\n");
        }
    }

    @Test
    public void normalTest1() {
        long[] planks = new long[]{8, 3, 8, 5, 7, 6, 2, 3, 1, 2};
        testInitialRead(1, 2, planks);
        int result = plot.test1();
        System.out.println(Arrays.toString(planks));
        System.out.println(result + "\n");
        assertEquals(5, result);
    }

    private void normalTest1priv(long[] planks, int days, int expected) {
        testInitialRead(1, days, planks);
        int result = plot.test1();
        System.out.println(Arrays.toString(planks));
        System.out.println(result + "\n");
        assertEquals(expected, result);
    }

    @Test
    public void test1Final() {
        normalTest1priv(new long[]{3, 3, 1, 3}, 2, 3);
        normalTest1priv(new long[]{1, 2, 3, 1},2, 4);
        normalTest1priv(new long[]{8, 3, 8, 5, 8, 6, 2, 3, 1, 2}, 2, 5);
        normalTest1priv(new long[]{8, 1, 3, 1},1, 3);
    }
}