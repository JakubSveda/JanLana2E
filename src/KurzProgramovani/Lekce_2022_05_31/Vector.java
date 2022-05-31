/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KurzProgramovani.Lekce_2022_05_31;

/**
 *
 * @author kahoun
 */
public class Vector extends Point {

    public static void main(String[] args) {
        Vector u = new Vector(3, 7);
        Vector v = new Vector(1, -2);
        Vector w = u.move(v);
        System.out.println(u);
        System.out.println(v);
        System.out.println(w);
        System.out.println(w.axialYSymmetry());
        System.out.println(u.move(v).multiply(2));
    }

    public Vector(double x, double y) {
        super(x, y);
    }

    public Point move(Point p) {
        return new Point(getX() + p.getX(), getY() + p.getY());
    }

    public Vector move(Vector v) {
        return new Vector(getX() + v.getX(), getY() + v.getY());
    }

    public Point[] move(Point[] v) {
        Point[] w = new Point[v.length];
        for (int i = 0; i < v.length; i++) {
            w[i] = move(v[i]);
        }
        return w;
    }

    public Vector[] move(Vector[] v) {
        Vector[] w = new Vector[v.length];
        for (int i = 0; i < v.length; i++) {
            w[i] = move(v[i]);
        }
        return w;
    }

    public Vector multiply(double k) {
        return new Vector(getX() * k, getY() * k);
    }

    public static Point[] multiply(Point[] v, double k) {
        Point[] w = new Point[v.length];
        for (int i = 0; i < v.length; i++) {
            w[i] = v[i].multiply(k);
        }
        return w;
    }

    public static Vector[] multiply(Vector[] v, double k) {
        Vector[] w = new Vector[v.length];
        for (int i = 0; i < v.length; i++) {
            w[i] = v[i].multiply(k);
        }
        return w;
    }

    public Vector centralSymmetry() {
        return new Vector(-getX(), -getY());
    }

    public Vector axialXSymmetry() {
        return new Vector(getX(), -getY());
    }

    public Vector axialYSymmetry() {
        return new Vector(-getX(), getY());
    }

    @Override
    public String toString() {
        return "(" + getX() + "; " + getY() + ")";
    }

}
