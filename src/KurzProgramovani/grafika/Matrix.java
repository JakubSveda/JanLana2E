package KurzProgramovani.grafika;

/**
 * ****************************************************************************
 * Compilation: javac Matrix.java Execution: java Matrix
 *
 * A bare-bones immutable data type for M-by-N matrices.
 *
 *****************************************************************************
 */
public class Matrix {

    private final int m;             // number of rows
    private final int n;             // number of columns
    private final double[][] data;   // M-by-N array

    // create M-by-N matrix of 0's
    public Matrix(int mm, int nn) {
        this.m = mm;
        this.n = nn;
        data = new double[m][n];
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public double get(int x, int y) {
        return data[x][y];
    }

    public void set(int x, int y, double v) {
        data[x][y] = v;
    }

    public void setPointInMatrix(int x, int y) {
        this.set(0, 0, x);
        this.set(1, 0, y);
        this.set(2, 0, 1);
    }

    public void setPointInMatrix(int x, int y, int z) {
        this.set(0, 0, x);
        this.set(1, 0, y);
        this.set(2, 0, z);
        this.set(3, 0, 1);
    }

    // create matrix based on 2d array
    public Matrix(double[][] data2) {
        m = data2.length;
        n = data2[0].length;
        this.data = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.data[i][j] = data2[i][j];
            }
        }
    }

    // copy constructor
    private Matrix(Matrix a) {
        this(a.data);
    }

    // create and return a random M-by-N matrix with values between 0 and 1
    public static Matrix random(int m, int n) {
        Matrix a = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a.data[i][j] = Math.random();
            }
        }

        return a;
    }

    // create and return the N-by-N identity matrix
    public static Matrix identity(int n) {
        Matrix ii = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            ii.set(i, i, 1);
            ii.data[i][i] = 1;
        }
        return ii;
    }

    public static Matrix rotation(double rad) {
        rad = -rad;
        Matrix m = Matrix.identity(3);

        m.data[0][0] = m.data[1][1] = Math.cos(rad);
        m.data[0][1] = Math.sin(rad);
        m.data[1][0] = -1 * Math.sin(rad);

        return m;
    }
    public static Matrix rotate3D_X(double angle) {
        Matrix m = Matrix.identity(4);
        m.set(1, 1, Math.cos(angle));
        m.set(1, 2, -Math.sin(angle));
        m.set(2, 1, Math.sin(angle));
        m.set(2, 2, Math.cos(angle));
        return m;
    }

    public static Matrix rotate3D_Y(double angle) {
        Matrix m = Matrix.identity(4);
        m.set(0, 0, Math.cos(angle));
        m.set(0, 2, Math.sin(angle));
        m.set(2, 0, -Math.sin(angle));
        m.set(2, 2, Math.cos(angle));
        return m;
    }

    public static Matrix rotate3D_Z(double angle) {
        Matrix m = Matrix.identity(4);
        m.set(0, 0, Math.cos(angle));
        m.set(0, 1, -Math.sin(angle));
        m.set(1, 0, Math.sin(angle));
        m.set(1, 1, Math.cos(angle));
        return m;
    }

    public static Matrix changeSize3D(double resizeValue_X, double resizeValue_Y, double resizeValue_Z) {
        Matrix m = Matrix.identity(4);
        m.set(0, 0, resizeValue_X);
        m.set(1, 1, resizeValue_Y);
        m.set(2, 2, resizeValue_Z);
        return m;
    }

    public static Matrix changeSize3D(double resizeValue) {
        return changeSize3D(resizeValue, resizeValue, resizeValue);
    }

    public static Matrix transposition(double dx, double dy) {
        Matrix m = Matrix.identity(3);
        m.data[0][2] = dx;
        m.data[1][2] = dy;

        return m;
    }

    public static Matrix scale(double sx, double sy) {
        Matrix m = Matrix.identity(3);
        m.data[0][0] = sx;
        m.data[1][1] = sy;

        return m;
    }

    // swap rows i and j
    private void swap(int i, int j) {
        double[] temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // create and return the transpose of the invoking matrix
    public Matrix transpose() {
        Matrix a = new Matrix(n, m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a.data[j][i] = this.data[i][j];
            }
        }
        return a;
    }

    // return C = A + B
    public Matrix plus(Matrix b) {
        Matrix a = this;
        if (b.m != a.m || b.n != a.n) {
            throw new RuntimeException("Illegal matrix dimensions.");
        }
        Matrix c = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                c.data[i][j] = a.data[i][j] + b.data[i][j];
            }
        }
        return c;
    }

    // return C = A - B
    public Matrix minus(Matrix b) {
        Matrix a = this;
        if (b.m != a.m || b.n != a.n) {
            throw new RuntimeException("Illegal matrix dimensions.");
        }
        Matrix c = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                c.data[i][j] = a.data[i][j] - b.data[i][j];
            }
        }
        return c;
    }

    // does A = B exactly?
    public boolean eq(Matrix b) {
        Matrix a = this;
        if (b.m != a.m || b.n != a.n) {
            throw new RuntimeException("Illegal matrix dimensions.");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a.data[i][j] != b.data[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // return C = A * B
    public Matrix times(Matrix b) {
        Matrix a = this;
        if (a.n != b.m) {
            throw new RuntimeException("Illegal matrix dimensions.");
        }
        Matrix c = new Matrix(a.m, b.n);
        for (int i = 0; i < c.m; i++) {
            for (int j = 0; j < c.n; j++) {
                for (int k = 0; k < a.n; k++) {
                    c.data[i][j] += (a.data[i][k] * b.data[k][j]);
                }
            }
        }
        return c;
    }

    // return x = A^-1 b, assuming A is square and has full rank
    public Matrix solve(Matrix rhs) {
        if (m != n || rhs.m != n || rhs.n != 1) {
            throw new RuntimeException("Illegal matrix dimensions.");
        }

        // create copies of the data
        Matrix a = new Matrix(this);
        Matrix b = new Matrix(rhs);

        // Gaussian elimination with partial pivoting
        for (int i = 0; i < n; i++) {

            // find pivot row and swap
            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(a.data[j][i]) > Math.abs(a.data[max][i])) {
                    max = j;
                }
            }
            a.swap(i, max);
            b.swap(i, max);

            // singular
            if (a.data[i][i] == 0.0) {
                throw new RuntimeException("Matrix is singular.");
            }

            // pivot within b
            for (int j = i + 1; j < n; j++) {
                b.data[j][0] -= b.data[i][0] * a.data[j][i] / a.data[i][i];
            }

            // pivot within A
            for (int j = i + 1; j < n; j++) {
                double x = a.data[j][i] / a.data[i][i];
                for (int k = i + 1; k < n; k++) {
                    a.data[j][k] -= a.data[i][k] * x;
                }
                a.data[j][i] = 0.0;
            }
        }

        // back substitution
        Matrix x = new Matrix(n, 1);
        for (int j = n - 1; j >= 0; j--) {
            double t = 0.0;
            for (int k = j + 1; k < n; k++) {
                t += a.data[j][k] * x.data[k][0];
            }
            x.data[j][0] = (b.data[j][0] - t) / a.data[j][j];
        }
        return x;

    }

    // print matrix to standard output
    public void show() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%9.4f ", data[i][j]);
            }
            System.out.println();
        }
    }
}
