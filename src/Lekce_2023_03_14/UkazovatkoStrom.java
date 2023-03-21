package Lekce_2023_03_14;

import java.util.LinkedList;
import java.util.Queue;

public class UkazovatkoStrom {

    private Queue<Strom> queue;

    public UkazovatkoStrom(Strom s) {
        queue = new LinkedList<>();
        queue.add(s);
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public Strom next() {
        Strom s = queue.remove();
        if (s.left != null)
            queue.add(s.left);
        if (s.right != null)
            queue.add(s.right);
        return s;
    }
}
