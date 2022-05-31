package KurzProgramovani.Lekce_2022_05_30;

public class Vector {
    public static void main(String[] args) {
        Vector u = new Vector(3, 6);
        Vector v = new Vector(2, -2);
        Vector w = u.move(v);
        System.out.println(w);
        w = u.multiply(2);
        System.out.println(w);
        w = u.centralSymmetry();
        System.out.println(w);
        w = u.axialSymmetryByY();
        System.out.println(w);
        w = u.axialSymmetryByX();
        System.out.println(w);
        Vector.displayVector(u, v, w);
    }

    private final double x, y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector move(Vector vector) {
        return new Vector(this.getX() + vector.getX(), this.getY() + vector.getY());
    }

    public Vector multiply(double k) {
        return new Vector(this.getX() * k, this.getY() * k);
    }

    public Vector centralSymmetry() {
        return new Vector(-this.getX(), -this.getY());
    }

    public Vector axialSymmetryByY() {
        return new Vector(-this.getX(), this.getY());
    }

    public Vector axialSymmetryByX() {
        return new Vector(this.getX(), -this.getY());
    }

    @Override
    public String toString() {
        return "vector=(" + this.getX() + "; " + this.getY() + ")";
    }

    public static void displayVector(Vector... vectors) {
        VectorGraphics.add(vectors);
        VectorGraphics.main(null);
    }
}
