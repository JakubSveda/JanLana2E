package Lekce_2023_10_16;

import org.junit.*;
import static org.junit.Assert.*;

public class MyMinTest {
    @Test
    public void testPositive() {
        int out = MyMin.min(1, 2);
        assertEquals(1, out);
    }

    @Test
    public void testNegative() {
        int out = MyMin.min(-1, -2);
        assertEquals(-2, out);
    }
}
