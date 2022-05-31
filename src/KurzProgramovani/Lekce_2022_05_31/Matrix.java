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
public class Matrix {

    public static void main(String[] args) {
        Matrix m = new Matrix(3, 3,
                2, 0, 0,
                0, 2, 0,
                0, 0, 1);
        System.out.println(m);
    }

    public static Matrix identity(int size) {
        Matrix m = new Matrix(size, size);
        for (int i = 0; i < size; i++) {
            m.m[i][i] = 1;
        }
        return m;
    }

    public static Matrix translate(Vector v) {
        return translate(v.getX(), v.getY());
    }

    public static Matrix translate(double x, double y) {
        return new Matrix(3, 3,
                1, 0, x,
                0, 1, y,
                0, 0, 1);
    }

    public static Matrix rotation(double a) {
        return new Matrix(3, 3,
                +Math.cos(a), -Math.sin(a), 0,
                +Math.sin(a), +Math.cos(a), 0,
                0, 0, 1);
    }

    public static Matrix rotation(Vector v, double a) {
        return translate(v)
                .multiply(rotation(a))
                .multiply(translate(v.multiply(-1)));
    }

    public static Matrix scale(double x, double y) {
        return new Matrix(3, 3,
                x, 0, 0,
                0, y, 0,
                0, 0, 1);
    }

    public static Matrix from(Point v) {
        return new Matrix(3, 1,
                v.getX(),
                v.getY(),
                1);
    }
    private final double[][] m;
    private final int rows;
    private final int columns;

    public Matrix(int rows, int cols, double... values) {
        this.rows = rows;
        this.columns = cols;
        m = new double[rows][cols];
        int i = -1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (++i < values.length) {
                    m[row][col] = values[i];
                }
            }
        }
    }

    public Matrix multiply(Matrix m) {
        // this x m
        if (this.getColumns() != m.getRows()) {
            throw new IllegalArgumentException();
        }
        Matrix r = new Matrix(this.getRows(), m.getColumns());
        for (int row = 0; row < r.getRows(); row++) {
            for (int col = 0; col < r.getColumns(); col++) {
                for (int i = 0; i < this.getColumns(); i++) {
                    r.m[row][col] += this.m[row][i] * m.m[i][col];
                }
            }
        }
        return r;
    }

    public Point toPoint() {
        if ((columns != 1) || (rows != 3)) {
            throw new IllegalArgumentException();
        }
        return new Point(m[0][0], m[1][0]);
    }

    public Vector toVector() {
        if ((columns != 1) || (rows != 3)) {
            throw new IllegalArgumentException();
        }
        return new Vector(m[0][0], m[1][0]);
    }

    public Point[] transform(Point[] v) {
        Point[] w = new Point[v.length];
        for (int i = 0; i < v.length; i++) {
            w[i] = this.multiply(Matrix.from(v[i])).toPoint();
        }
        return w;
    }

    public Vector[] transform(Vector[] v) {
        Vector[] w = new Vector[v.length];
        for (int i = 0; i < v.length; i++) {
            w[i] = this.multiply(Matrix.from(v[i])).toVector();
        }
        return w;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            sb.append('(');
            for (int col = 0; col < columns; col++) {
                sb.append(m[row][col]);
                sb.append(' ');
            }
            sb.append(')').append('\n');
        }
        return sb.toString();
    }

}
