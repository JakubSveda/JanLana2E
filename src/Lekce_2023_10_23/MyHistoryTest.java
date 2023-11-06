package Lekce_2023_10_23;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MyHistoryTest {
    @Test
    public void read() {
        MyHistory mh = new MyHistory("abc");
        try {
            mh.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void save() {
    }

    @Test
    public void addLine() {
        MyHistory mh = new MyHistory("abc");
        mh.addLine("radek 1");
        assertEquals("radek 1", mh.toString());
    }

    @Test
    public void addMoreLines() {
        MyHistory mh = new MyHistory("abc");
        for (int i = 1; i <= 5; i++) {
            mh.addLine("radek " + i);
        }

        assertEquals("radek 1\nradek 2\nradek 3\nradek 4\nradek 5", mh.toString());
    }

    @Test
    public void testToString() {
    }
}
