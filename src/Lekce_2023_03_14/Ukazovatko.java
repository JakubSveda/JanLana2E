package Lekce_2023_03_14;

public class Ukazovatko implements MujIterator {

    private SpojovyBod current;

    public Ukazovatko(SpojovyBod current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public SpojovyBod next() {
        SpojovyBod b = current;
        current = current.right;
        return b;
    }
}
