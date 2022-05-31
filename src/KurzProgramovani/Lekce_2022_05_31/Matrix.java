package KurzProgramovani.Lekce_2022_05_31;

import java.util.Arrays;

public class Matrix {

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
                1, 0, u.getX(),
                    0, 1, u.getY(),
                0, 0, 1);
    }

    public static Matrix rotation(double a) {
        return new Matrix(3, 3,
                Math.cos(a), -Math.sin(a), 0,
                Math.sin(a), Math.cos(a), 0,
                0, 0, 1);
    }

    private final double[][] m;
    private final int rows, columns;

    public Matrix(int rows, int columns, double... values) {
        this.rows = rows;
        this.columns = columns;

        m = new double[rows][columns];
        int i = -1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (++i < values.length) {
                    m[row][col] = values[i];
                }
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Matrix multiply(Matrix m) {
        if (this.getColumns() != m.getRows()) {
            throw new IllegalArgumentException();
        }
        Matrix r = new Matrix(this.getRows(), m.getColumns())
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < getRows(); row++) {
            sb.append("(");
            for (int col = 0; col < getColumns(); col++) {
                sb.append(m[row][col] + " ");
            }
            sb.append(")").append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Matrix m = new Matrix(3, 3,
                2, 0, 0,
                        0, 2, 0,
                        0, 0, 1);

        System.out.println(m);
    }
}
